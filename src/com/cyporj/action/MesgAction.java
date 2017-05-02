package com.cyporj.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cyporj.model.Cymsg;
import com.cyporj.model.Page;
import com.cyporj.service.MesgService;

@Controller
@Scope("properties")
public class MesgAction {
	
	private MesgService mesgService;
	private Cymsg cymsg;
	@Resource
	public void setMesgService(MesgService mesgService) {
		this.mesgService = mesgService;
	}
	
	Page p=new Page();
	public String execute() throws Exception {
		mesgService.msgpage(p);
		return "message";   
	}
	
	public String save() throws Exception {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		String content = new String(cymsg.getMsgstr().getBytes("ISO-8859-1"),"utf-8");
		cymsg.setMsgstr(content);
		cymsg.setMsgdata(time);
		mesgService.save(cymsg);
		return "success";   
		
	}
	

	public String delete() throws Exception {
		mesgService.delete(cymsg);
		mesgService.msgpage(p);
		return "message";   
		
	}
	
	public Cymsg getCymsg() {
		return cymsg;
	}


	public void setCymsg(Cymsg cymsg) {
		this.cymsg = cymsg;
	}

	public Page getP() {
		return p;
	}

	public void setP(Page p) {
		this.p = p;
	}

}
