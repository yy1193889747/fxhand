package com.cyporj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cyporj.model.Cycarts;
import com.cyporj.model.Cygoods;
import com.cyporj.model.Page;
import com.cyporj.service.GoodService;
import com.cyporj.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
@Scope("properties")
public class GoodAction extends ActionSupport{
	private GoodService goodService;
	private UserService userService;
	private Cygoods cygoods;
	private Cycarts cycarts;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String content;
	private String str;
	@Resource
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}




	Page p=new Page();
	public String execute() throws Exception {
		
		if(str == null){
			str="";
		}
		setStr(str);
		str = new String(str.getBytes("ISO-8859-1"),"utf-8");
		goodService.goodspage(p,str);
		return "goods";   
		
	}
	
	
	public String hsearch() throws Exception {
		goodService.goodspage(p,str);
		return "goods";   
		
	}
	public String ugoodlist() throws Exception {
		ActionContext.getContext().getSession().put("uglist", goodService.userlist(cygoods.getCyusers().getCyuid()));
		ActionContext.getContext().getSession().put("u", userService.userff(cygoods.getCyusers().getCyuid()));
		return "quser";   
		
	}
	
	public String addGood() throws Exception {
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
		cygoods.setCygphoto(fileName);
		cygoods.setCygview(0);
		cygoods.setCygstats(1);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		cygoods.setCygdate(time);
		goodService.AddGood(cygoods);
		return "jump";
	}

	public String usergupdate() throws Exception {
		System.out.println(uploadFileName);
		if(uploadFileName!=null){
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
			cygoods.setCygphoto(fileName);
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(date);
			cygoods.setCygdate(time);
			goodService.usergupdate(cygoods);
			ActionContext.getContext().getSession().put("uglist", goodService.userlist(cygoods.getCyusers().getCyuid()));
			return "quser";
		}
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		cygoods.setCygdate(time);
		goodService.usergupdate2(cygoods);
		ActionContext.getContext().getSession().put("uglist", goodService.userlist(cygoods.getCyusers().getCyuid()));
		return "quser";
	}
	public String queryd() throws Exception {
		Cygoods gg = goodService.queryd(cygoods.getCygid());
		ActionContext.getContext().getSession().put("gd", gg);
		ActionContext.getContext().getSession().put("glike", goodService.querylike(gg.getCyclassd().getCdid(), gg.getCygid()));
		return "single";
	}

	
	public String querylist() throws Exception {
		System.out.println(cygoods.getCyclassd().getCdid());
		ActionContext.getContext().getSession().put("glist", goodService.querylist(cygoods.getCyclassd().getCdid()));
		return "products";
	}
	
	public String search() throws Exception {
		content = new String(content.getBytes("ISO-8859-1"),"utf-8");
		ActionContext.getContext().getSession().put("search", goodService.search(content));
		return "search";
	}
	
	public String delete() throws Exception {
		goodService.delete(cygoods);
		goodService.goodspage(p,"");
		return "goods";   
		
	}
	
	
	public String collect() throws Exception {
		if(goodService.collectlist(cycarts).size()>0){
			return "success";   
		}
		goodService.collect(cycarts);
		return "success";   
		
	}
	
	public String collectlist() throws Exception {
			
		ActionContext.getContext().getSession().put("collect", goodService.collectlist(cycarts));
			
		return "collect";   
		
	}
	
	public String deletecollect() throws Exception {
		
		goodService.deletecollect(cycarts);
		
		return "success";   
		
	}
	
	public String deleteugood() throws Exception {
		
		goodService.delete(cygoods);
		
		return "success";   
		
	}
	
	
	
	public Cygoods getCygoods() {
		return cygoods;
	}


	public void setCygoods(Cygoods cygoods) {
		this.cygoods = cygoods;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public Page getP() {
		return p;
	}

	public void setP(Page p) {
		this.p = p;
	}

	public Cycarts getCycarts() {
		return cycarts;
	}

	public void setCycarts(Cycarts cycarts) {
		this.cycarts = cycarts;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}


	
	
}
