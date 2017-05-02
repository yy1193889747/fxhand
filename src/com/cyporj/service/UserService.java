package com.cyporj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyporj.dao.CyusersDAO;
import com.cyporj.model.Cyusers;
import com.cyporj.model.Page;
import com.cyporj.until.SendCode;

@Service
public class UserService {
	
	private CyusersDAO cyusersDAO;
	@Resource
	public void setCyusersDAO(CyusersDAO cyusersDAO) {
		this.cyusersDAO = cyusersDAO;
	}
	
    public Cyusers login(Cyusers users){
    	if(cyusersDAO.findByExample(users).size()>0){
    		return cyusersDAO.findByExample(users).get(0);
    	}
    	 return null;
    }
    public Cyusers userff(int userid){
    	 return cyusersDAO.findById(userid);
    }
    public Cyusers register(Cyusers users){
    	 cyusersDAO.save(users);
    	 return users;
    }
   
    public boolean checkphone(Cyusers users){
    	if(cyusersDAO.findByExample(users).size()>0){
    		return false;
    	}
    	 return true;
    }
	public void send(String p,String i){
		
		String httpUrl = "http://apis.baidu.com/kingtto_media/106sms/106sms";
		String httpArg = "mobile="+p+"&content=%E3%80%90fxhand%E3%80%91%E6%82%A8%E7%9A%84%E9%AA%8C%E8%AF%81%E7%A0%81%E6%98%AF"+i+"%EF%BC%8C%E6%9C%89%E6%95%88%E6%97%B6%E9%97%B45%E5%88%86%E9%92%9F%EF%BC%8C%E8%AF%B7%E4%B8%8D%E8%A6%81%E5%91%8A%E8%AF%89%E4%BB%96%E4%BA%BA";
		String jsonResult = SendCode.request(httpUrl, httpArg);
		System.out.println(jsonResult);
	}
	
	public int alluser(){
		return cyusersDAO.findAll().size()-1;
	}
	public int allcheckuser(){
		Cyusers cyuser =new Cyusers();
		cyuser.setCyustat("2");
		return cyusersDAO.findByExample(cyuser).size();
	}
	@SuppressWarnings("unchecked")
	public List<Cyusers> alllist(){
		return cyusersDAO.findAll();
	}
	
	public void userpage(Page p ,String s){
		 cyusersDAO.userpage(p,s);
	}
	public void userpage(Page p){
		 cyusersDAO.userpage(p);
	}
	public void checkuserpage(Page p){
		 cyusersDAO.checkuserpage(p);
	}
	
	public void lock(int cyuid){
		 cyusersDAO.lockuser(cyuid);
	}
	public void unlock(int cyuid){
		 cyusersDAO.unlockuser(cyuid);
	}
	public void pass(int cyuid){
		 cyusersDAO.passuser(cyuid);
	}
	public void nopass(int cyuid, String whystr){
		 cyusersDAO.nopassuser(cyuid , whystr);
	}
	public void delete(Cyusers cyuid){
		 cyusersDAO.delete(cyuid);
	}
	public void update(Cyusers cyuid){
		 cyusersDAO.attachDirty(cyuid);
	}
	public void userphoto(int cyuid ,String photo){
		cyusersDAO.userphoto(cyuid , photo);
	}
}
