package com.cyporj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyporj.dao.CycartsDAO;
import com.cyporj.dao.CygoodsDAO;
import com.cyporj.model.Cycarts;
import com.cyporj.model.Cygoods;
import com.cyporj.model.Page;

@Service
public class GoodService {

	private CycartsDAO cycartsDAO;
	@Resource
	public void setCycartsDAO(CycartsDAO cycartsDAO) {
		this.cycartsDAO = cycartsDAO;
	}

	private CygoodsDAO cygoodsDAO;
	@Resource
	public void setCygoodsDAO(CygoodsDAO cygoodsDAO) {
		this.cygoodsDAO = cygoodsDAO;
	}
	
	public void AddGood(Cygoods g){
		cygoodsDAO.save(g);
	}
	public void usergupdate(Cygoods g){
		cygoodsDAO.usergupdate(g);
	}
	public void usergupdate2(Cygoods g){
		cygoodsDAO.usergupdate2(g);
	}
	public Cygoods queryd(int gid){
		Cygoods g = cygoodsDAO.findById(gid);
		g.setCygview(g.getCygview()+1);
		cygoodsDAO.attachDirty(g);
		return g;
	}
	public List<Cygoods> userlist(int cyuid){
		return cygoodsDAO.findBycyuid(cyuid);
	}
	public List<Cygoods> querylist(int cdid){
		return cygoodsDAO.findBycdid(cdid);
	}
	public List<Cygoods> querylike(int gid , int cdid){
		return cygoodsDAO.findLike(gid , cdid);
	}
	public List<Cygoods> search(String s){
		return cygoodsDAO.search(s);
	}
	public int allgoods() {
		return cygoodsDAO.findAll().size();
		
	}
	public int allview() {
		int all = 0;
		@SuppressWarnings("unchecked")
		List<Cygoods> list = cygoodsDAO.findAll();
		for (int i = 0; i <  list.size(); i++) {
			all = all + list.get(i).getCygview();
		}
		return all;
	}
	public void goodspage(Page p,String s){
		cygoodsDAO.goodspage(p,s);
		
	}
	
	public void delete(Cygoods cygid){
		cygoodsDAO.delete(cygid);
	}
	
	public void collect(Cycarts cycarts){
		cycartsDAO.save(cycarts);
	}
	public List<Cycarts> collectlist(Cycarts cycarts){
		return cycartsDAO.findByExample(cycarts);
	}
	public void deletecollect(Cycarts cycarts){
		cycartsDAO.delete(cycarts);
	}
	
}
