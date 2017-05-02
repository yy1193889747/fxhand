package com.cyporj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyporj.dao.CyclassdDAO;
import com.cyporj.dao.CyclassgDAO;
import com.cyporj.model.Cyclassd;
import com.cyporj.model.Cyclassg;
@Service
public class CyclassService {
	

	private CyclassdDAO cyclassdDAO;
	@Resource
	public void setCyclassdDAO(CyclassdDAO cyclassdDAO) {
		this.cyclassdDAO = cyclassdDAO;
	}
	private CyclassgDAO cyclassgDAO;
	@Resource
	public void setCyclassgDAO(CyclassgDAO cyclassgDAO) {
		this.cyclassgDAO = cyclassgDAO;
	}

	
	public List<Cyclassd> classlist(int i){
		
		return  cyclassdDAO.findbycgid(i);
	}
	@SuppressWarnings("unchecked")
	
	public List<Cyclassg> classglist(){
		return  cyclassgDAO.findAll();
	}

}
