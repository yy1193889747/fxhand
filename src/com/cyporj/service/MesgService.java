package com.cyporj.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyporj.dao.CymsgDAO;
import com.cyporj.model.Cymsg;
import com.cyporj.model.Page;

@Service
public class MesgService {

	 private CymsgDAO cymsgDAO;
	 @Resource
	 
	public void setCymsgDAO(CymsgDAO cymsgDAO) {
		this.cymsgDAO = cymsgDAO;
	}
	 
	public void msgpage(Page p){
		 cymsgDAO.msgpage(p);
			
		}
	public void save(Cymsg cymsg) {
		cymsgDAO.save(cymsg);

	}
	public int allmesg() {
		return cymsgDAO.findAll().size();
		
	}
	public void delete(Cymsg cymsg) {
		cymsgDAO.delete(cymsg);
	}
}
