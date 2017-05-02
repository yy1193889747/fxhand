package com.cyporj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;



import org.springframework.web.context.request.RequestContextHolder;

import com.cyporj.model.Cyusers;
import com.cyporj.model.Page;
import com.cyporj.service.GoodService;
import com.cyporj.service.MesgService;
import com.cyporj.service.UserService;
import com.cyporj.until.ExcelUtil;
import com.cyporj.until.IpUtil;
import com.cyporj.until.KeyUntil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller
@Scope("properties")
public class UserAction extends ActionSupport{
	private Cyusers cyuser;
	private String result;
	private HttpServletRequest hsr; 
	private UserService userService;
	private GoodService goodService;
	private MesgService mesgService;
	private String phonecode;
	private String phone;
	private String load;
	private String str;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Resource
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	@Resource
	public void setMesgService(MesgService mesgService) {
		this.mesgService = mesgService;
	}
	
	public String login() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();  
		System.out.println("login----------"+IpUtil.getIpAddr(request));
		Cyusers u=userService.login(cyuser);
		if(u!=null){
			if("15235835664".equals(cyuser.getCyuphone())){
				allcount();
				ActionContext.getContext().getSession().put("uu", u);
				return "admin";
			}
			System.out.println(cyuser.getCyuphone() + "======" + cyuser.getCyupwd());
			ActionContext.getContext().getSession().put("u", u);
			return "jump";
		}
		
		return "success";
		
	}
public String register() throws Exception {
	   Date date=new Date();
	  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String time=format.format(date);
		System.out.println("register"+date+"-----"+time);
		cyuser.setCyuphone(phone);
		cyuser.setCyrdate(time);
		cyuser.setCyustat("1");
		Cyusers u = userService.register(cyuser);
			ActionContext.getContext().getSession().put("u", u);
			return "jump";
		
	}
	public String checkphone() throws Exception {
        ActionContext ac = ActionContext.getContext();   
        HttpServletResponse res = (HttpServletResponse)ac.get(ServletActionContext.HTTP_RESPONSE);   
        res.setContentType("text/html;charset=UTF-8");   
        PrintWriter w = res.getWriter();   
        if(!userService.checkphone(cyuser)){   
            w.print("手机号已存在");   
        }else{   
            w.print("手机号不存在");   
        }   
        w.close();   
        return "success";   
		
	}
	
	
	public String sendcode() throws Exception {
		String i = KeyUntil.generateString(6);
		 System.out.println("进入了sendcode....."+i);
		userService.send(phone, i);
		ActionContext.getContext().getSession().put("i", i);
		return "success";   
		
	}
	
	public String checkphonecode() throws Exception {
		
        ActionContext ac = ActionContext.getContext();   
        HttpServletResponse res = (HttpServletResponse)ac.get(ServletActionContext.HTTP_RESPONSE);   
        String i = (String) ac.getSession().get("i");
    	System.out.println("checkphonecode    "+i+"----"+phonecode);
        res.setContentType("text/html;charset=UTF-8");   
        
        PrintWriter w = res.getWriter();   
       
        if(phonecode.equals(i)){   
            System.out.println("进入了.....");
            w.print("动态码正确");   
        }else{   
            w.print("动态码不正确");   
        }   
        w.close();   
        
        return "success";   
		
	}
	public String allcount() throws Exception {
		ActionContext.getContext().getSession().put("msgcount", mesgService.allmesg());
		ActionContext.getContext().getSession().put("usercount", userService.alluser());
		ActionContext.getContext().getSession().put("goodcount", goodService.allgoods());
		ActionContext.getContext().getSession().put("viewcount", goodService.allview());
		ActionContext.getContext().getSession().put("checkusercount", userService.allcheckuser());
		return "admin";   
		
	}
	Page p=new Page();
	public String execute() throws Exception {
		if(str == null){
			str="";
		}
		setStr(str);
		str = new String(str.getBytes("ISO-8859-1"),"utf-8");
		userService.userpage(p,str);
		return "users";   
		
	}
	
	public String checkpage() throws Exception {
		userService.checkuserpage(p);
		return "checkusers";   
		
	}
	
	public String lock() throws Exception {
		userService.lock(cyuser.getCyuid());
		userService.userpage(p);
		return "users";   
		
	}
	public String unlock() throws Exception {
		userService.unlock(cyuser.getCyuid());
		userService.userpage(p);
		return "users";   
		
	}
	
	public String pass() throws Exception {
		userService.pass(cyuser.getCyuid());
		userService.checkuserpage(p);
		return "success";   
		
	}
	public String nopass() throws Exception {
		String content = new String(cyuser.getCyuphoto().getBytes("ISO-8859-1"),"utf-8");
		userService.nopass(cyuser.getCyuid(),content);
		userService.checkuserpage(p);
		return "success";   
		
	}
	
	public String excel() throws Exception {
		System.out.println(load);
		FileOutputStream fout = new FileOutputStream("d:\\"+load+".xls");
		ExcelUtil.execlDoc(fout, userService.alllist(), "用户列表", new String[]{"编号","用户名","密码","手机号","QQ号","邮箱","注册时间"});
		userService.userpage(p);
		return "users";
		
	}
	
	public String delete() throws Exception {
		userService.delete(cyuser);
		userService.userpage(p);
		return "users";   
		
	}
	
	public String userupdate() throws Exception {
		userService.update(cyuser);
		ActionContext.getContext().getSession().put("u", cyuser);
		return "quser";   
		
	}
	
	public String userphoto() throws Exception {
		System.out.println("23123");
		int idx=uploadFileName.lastIndexOf(".");
		String subfix=uploadFileName.substring(idx);
		String fileName=new Date().getTime()+subfix;
		@SuppressWarnings("resource")
		FileOutputStream out=new FileOutputStream(getSavePath()+"\\"+fileName);
		@SuppressWarnings("resource")
		FileInputStream in=new FileInputStream(getUpload());
		byte[] b=new byte[1024];
		int len=0;
		while((len=in.read(b))>0){
			out.write(b, 0, len);
		}
		System.out.println(fileName);
		userService.userphoto(cyuser.getCyuid(),fileName);
		
		return "quser";
	}

	
	
	public Cyusers getCyuser() {
		return cyuser;
	}

	public void setCyuser(Cyusers cyuser) {
		this.cyuser = cyuser;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public HttpServletRequest getHsr() {
		return hsr;
	}

	public void setHsr(HttpServletRequest hsr) {
		this.hsr = hsr;
	}

	public String getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Page getP() {
		return p;
	}
	public void setP(Page p) {
		this.p = p;
	}
	public String getLoad() {
		return load;
	}
	public void setLoad(String load) {
		this.load = load;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		savePath=ServletActionContext.getServletContext().getRealPath(savePath);
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


}
