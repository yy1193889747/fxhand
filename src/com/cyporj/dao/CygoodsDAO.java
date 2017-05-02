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
import com.cyporj.model.Page;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cygoods entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cyporj.model.Cygoods
 * @author MyEclipse Persistence Tools
 */
@Repository("cygoodsDAO")
@Transactional
public class CygoodsDAO {
	private static final Logger log = LoggerFactory.getLogger(CygoodsDAO.class);
	// property constants
	public static final String CYGTITLE = "cygtitle";
	public static final String CYGDEP = "cygdep";
	public static final String CYGPHOTO = "cygphoto";
	public static final String CYGVIEW = "cygview";
	public static final String CYPRICE = "cyprice";
	public static final String CYGSTATS = "cygstats";
	public static final String CYGDATE = "cygdate";

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

	public void save(Cygoods transientInstance) {
		log.debug("saving Cygoods instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cygoods persistentInstance) {
		log.debug("deleting Cygoods instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cygoods findById(java.lang.Integer id) {
		log.debug("getting Cygoods instance with id: " + id);
		try {
			Cygoods instance = (Cygoods) getCurrentSession().get(
					"com.cyporj.model.Cygoods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cygoods> findByExample(Cygoods instance) {
		log.debug("finding Cygoods instance by example");
		try {
			List<Cygoods> results = (List<Cygoods>) getCurrentSession()
					.createCriteria("com.cyporj.model.Cygoods")
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
		log.debug("finding Cygoods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cygoods as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cygoods> findByCygtitle(Object cygtitle) {
		return findByProperty(CYGTITLE, cygtitle);
	}

	public List<Cygoods> findByCygdep(Object cygdep) {
		return findByProperty(CYGDEP, cygdep);
	}

	public List<Cygoods> findByCygphoto(Object cygphoto) {
		return findByProperty(CYGPHOTO, cygphoto);
	}

	public List<Cygoods> findByCygview(Object cygview) {
		return findByProperty(CYGVIEW, cygview);
	}

	public List<Cygoods> findByCyprice(Object cyprice) {
		return findByProperty(CYPRICE, cyprice);
	}

	public List<Cygoods> findByCygstats(Object cygstats) {
		return findByProperty(CYGSTATS, cygstats);
	}

	public List<Cygoods> findByCygdate(Object cygdate) {
		return findByProperty(CYGDATE, cygdate);
	}

	public List findAll() {
		log.debug("finding all Cygoods instances");
		try {
			String queryString = "from Cygoods";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cygoods merge(Cygoods detachedInstance) {
		log.debug("merging Cygoods instance");
		try {
			Cygoods result = (Cygoods) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cygoods instance) {
		log.debug("attaching dirty Cygoods instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cygoods instance) {
		log.debug("attaching clean Cygoods instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Cygoods> findBycdid(java.lang.Integer id) {
		try {
			String queryString = "from Cygoods where cyclassd.cdid="+id;
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cygoods> findBycyuid(java.lang.Integer id) {
		try {
			String queryString = "from Cygoods where cyusers.cyuid="+id+" order by cygid desc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List<Cygoods> findLike(java.lang.Integer id , java.lang.Integer gid) {
		try {
			String queryString = "from Cygoods where cyclassd.cdid="+id;
			String q = queryString + " and cygid <> " + gid + "  order by rand()";
			Query queryObject = getCurrentSession().createQuery(q).setMaxResults(4);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Cygoods> search(String s) {
		try {
			String queryString = "from Cygoods where cyclassd.cdname like '%"+s+"%' or cygtitle like '%"+s+"%' or cygdep like '%"+s+"%'";
			Query queryObject = getCurrentSession().createQuery(queryString).setMaxResults(12);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void goodspage(Page p ,String s) {
		String hql=" from Cygoods where cyclassd.cdname like '%"+s+"%' or cygtitle like '%"+s+"%' or cygdep like '%"+s+"%' order by cygid desc";

		Query q=getCurrentSession().createQuery(hql);
		q.setFirstResult((p.getPageNo()-1)*p.getPageSize());
		q.setMaxResults(p.getPageSize());
		p.setList(q.list());
		//查询结果
		hql="select count(cygid)"+hql;
		q=getCurrentSession().createQuery(hql);
		Long count=(Long)q.uniqueResult();
        p.setRowCount(count.intValue());
		
	}
	public void usergupdate(Cygoods g) {
		try {
			String queryString = "update cygoods set cygtitle = '"
					+ g.getCygtitle() + "', cygdep = '" + g.getCygdep()
					+ "' , cygphoto = '" + g.getCygphoto()
					+ "', cyprice = '" + g.getCyprice()
					+ "', cygdate = '" + g.getCygdate()
					+ "'where cygid = " + g.getCygid();
			getCurrentSession().createSQLQuery(queryString).executeUpdate();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void usergupdate2(Cygoods g) {
		try {
			String queryString = "update cygoods set cygtitle = '"
					+ g.getCygtitle() + "', cygdep = '" + g.getCygdep()
					+ "', cyprice = '" + g.getCyprice()
					+ "', cygdate = '" + g.getCygdate()
					+ "'where cygid = " + g.getCygid();
			getCurrentSession().createSQLQuery(queryString).executeUpdate();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public static CygoodsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CygoodsDAO) ctx.getBean("CygoodsDAO");
	}
}