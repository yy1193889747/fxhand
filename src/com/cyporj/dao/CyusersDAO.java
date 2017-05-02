package com.cyporj.dao;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cyporj.model.Cygoods;
import com.cyporj.model.Cyusers;
import com.cyporj.model.Page;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cyusers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cyporj.model.Cyusers
 * @author MyEclipse Persistence Tools
 */
@Repository("cyusersDAO")
@Transactional
public class CyusersDAO {
	private static final Logger log = LoggerFactory.getLogger(CyusersDAO.class);
	// property constants
	public static final String CYUNAME = "cyuname";
	public static final String CYUPHONE = "cyuphone";
	public static final String CYUPWD = "cyupwd";
	public static final String CYRDATE = "cyrdate";
	public static final String CYEMAIL = "cyemail";
	public static final String CYUQQ = "cyuqq";
	public static final String CYUADDRESS = "cyuaddress";
	public static final String CYUPHOTO = "cyuphoto";
	public static final String CYUSTAT = "cyustat";

	private SessionFactory sessionFactory;
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Cyusers transientInstance) {
		log.debug("saving Cyusers instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cyusers persistentInstance) {
		log.debug("deleting Cyusers instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cyusers findById(java.lang.Integer id) {
		log.debug("getting Cyusers instance with id: " + id);
		try {
			Cyusers instance = (Cyusers) getCurrentSession().get(
					"com.cyporj.model.Cyusers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cyusers> findByExample(Cyusers instance) {
		log.debug("finding Cyusers instance by example");
		try {
			List<Cyusers> results = (List<Cyusers>) getCurrentSession()
					.createCriteria("com.cyporj.model.Cyusers")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cyusers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cyusers as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cyusers> findByCyuname(Object cyuname) {
		return findByProperty(CYUNAME, cyuname);
	}

	public List<Cyusers> findByCyuphone(Object cyuphone) {
		return findByProperty(CYUPHONE, cyuphone);
	}

	public List<Cyusers> findByCyupwd(Object cyupwd) {
		return findByProperty(CYUPWD, cyupwd);
	}

	public List<Cyusers> findByCyrdate(Object cyrdate) {
		return findByProperty(CYRDATE, cyrdate);
	}

	public List<Cyusers> findByCyemail(Object cyemail) {
		return findByProperty(CYEMAIL, cyemail);
	}

	public List<Cyusers> findByCyuqq(Object cyuqq) {
		return findByProperty(CYUQQ, cyuqq);
	}

	public List<Cyusers> findByCyuaddress(Object cyuaddress) {
		return findByProperty(CYUADDRESS, cyuaddress);
	}

	public List<Cyusers> findByCyuphoto(Object cyuphoto) {
		return findByProperty(CYUPHOTO, cyuphoto);
	}

	public List<Cyusers> findByCyustat(Object cyustat) {
		return findByProperty(CYUSTAT, cyustat);
	}

	public List findAll() {
		log.debug("finding all Cyusers instances");
		try {
			String queryString = "from Cyusers";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cyusers merge(Cyusers detachedInstance) {
		log.debug("merging Cyusers instance");
		try {
			Cyusers result = (Cyusers) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cyusers instance) {
		log.debug("attaching dirty Cyusers instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cyusers instance) {
		log.debug("attaching clean Cyusers instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public void userpage(Page p) {
		String hql=" from Cyusers where cyuphone <> '15235835664'";
			
			Query q=getCurrentSession().createQuery(hql);
			q.setFirstResult((p.getPageNo()-1)*p.getPageSize());
			q.setMaxResults(p.getPageSize());
			p.setList(q.list());
			//查询结果
			hql="select count(cyuid)"+hql;
			q=getCurrentSession().createQuery(hql);
			Long count=(Long)q.uniqueResult();
	        p.setRowCount(count.intValue());
		}
	public void userpage(Page p, String s) {
		String hql=" from Cyusers where cyuphone <> '15235835664' and cyuphone like '%"+s+"%' or cyuname like '%"+s+"%' or cyuqq like '%"+s+"%'";
			
			Query q=getCurrentSession().createQuery(hql);
			q.setFirstResult((p.getPageNo()-1)*p.getPageSize());
			q.setMaxResults(p.getPageSize());
			p.setList(q.list());
			//查询结果
			hql="select count(cyuid)"+hql;
			q=getCurrentSession().createQuery(hql);
			Long count=(Long)q.uniqueResult();
	        p.setRowCount(count.intValue());
		}
	public void checkuserpage(Page p) {
		String hql=" from Cyusers where cyustat = '2'";
			
			Query q=getCurrentSession().createQuery(hql);
			q.setFirstResult((p.getPageNo()-1)*p.getPageSize());
			q.setMaxResults(p.getPageSize());
			p.setList(q.list());
			//查询结果
			hql="select count(cyuid)"+hql;
			q=getCurrentSession().createQuery(hql);
			Long count=(Long)q.uniqueResult();
	        p.setRowCount(count.intValue());
		}
	public void lockuser(java.lang.Integer id) {
		try {
			String queryString = "update cyusers set cyustat = '-1' where cyuid = "+id;
			 getCurrentSession().createSQLQuery(queryString).executeUpdate();
			 System.out.println(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void passuser(java.lang.Integer id) {
		try {
			String queryString = "update cyusers set cyustat = '3' where cyuid = "+id;
			getCurrentSession().createSQLQuery(queryString).executeUpdate();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void nopassuser(java.lang.Integer id , String str) {
		try {
			String queryString = "update cyusers set cyustat = '4', cyuphoto = '" +str+ "' where cyuid = "+id;
			System.out.println(queryString);
			 getCurrentSession().createSQLQuery(queryString).executeUpdate();
			 System.out.println(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void unlockuser(java.lang.Integer id) {
		try {
			String queryString = "update cyusers set cyustat = '1' where cyuid = "+id;
			System.out.println(queryString);
			getCurrentSession().createSQLQuery(queryString).executeUpdate();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void userphoto(java.lang.Integer id ,String photo) {
		try {
			String queryString = "update cyusers set cyustat = '2', cyuphoto = '" +photo+ "' where cyuid = "+id;
			System.out.println(queryString);
			getCurrentSession().createSQLQuery(queryString).executeUpdate();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public static CyusersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CyusersDAO) ctx.getBean("CyusersDAO");
	}
}