package com.cyporj.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cyporj.model.Cyclassd;
import com.cyporj.model.Cyclassg;
import com.cyporj.model.Page;
import com.cyporj.service.CyclassService;
import com.cyporj.service.GoodService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Controller
@Scope("properties")
public class CyclassAction extends ActionSupport{
	private GoodService goodService;
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}


	private CyclassService cyclassService;
	@Resource
	public void setCyclassService(CyclassService cyclassService) {
		this.cyclassService = cyclassService;
	}

	
	Page p=new Page();
	public String classall() throws Exception {
		
		List<Cyclassg> cyclassg = cyclassService.classglist();
		ActionContext.getContext().getSession().put("c", cyclassg);
		List<Cyclassd> cyclass1 = cyclassService.classlist(1);
		ActionContext.getContext().getSession().put("c1", cyclass1);
		List<Cyclassd> cyclass2 = cyclassService.classlist(2);
		ActionContext.getContext().getSession().put("c2", cyclass2);
		List<Cyclassd> cyclass3 = cyclassService.classlist(3);
		ActionContext.getContext().getSession().put("c3", cyclass3);
		List<Cyclassd> cyclass4 = cyclassService.classlist(4);
		ActionContext.getContext().getSession().put("c4", cyclass4);
		List<Cyclassd> cyclass5 = cyclassService.classlist(5);
		ActionContext.getContext().getSession().put("c5", cyclass5);
		List<Cyclassd> cyclass6 = cyclassService.classlist(6);
		ActionContext.getContext().getSession().put("c6", cyclass6);
		p.setPageSize(8);
		goodService.goodspage(p,"");
		ActionContext.getContext().put("p", p);
		return "index";
	}
	
}
