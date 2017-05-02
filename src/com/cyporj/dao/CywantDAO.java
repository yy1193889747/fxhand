package com.cyporj.dao;

import java.util.List;

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

import com.cyporj.model.Cywant;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cywant entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cyporj.model.Cywant
 * @author MyEclipse Persistence Tools
 */
@Repository("cywantDAO")
@Transactional
public class CywantDAO {
	private static final Logger log = LoggerFactory.getLogger(CywantDAO.class);
	// property constants
	public static final String CYWTITLE = "cywtitle";
	public static final String CYWSTR = "cywstr";
	public static final String CYWPRICE = "cywprice";
	public static final String CYWDATE = "cywdate";

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

	public void save(Cywant transientInstance) {
		log.debug("saving Cywant instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cywant persistentInstance) {
		log.debug("deleting Cywant instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cywant findById(java.lang.Integer id) {
		log.debug("getting Cywant instance with id: " + id);
		try {
			Cywant instance = (Cywant) getCurrentSession().get(
					"com.cyporj.model.Cywant", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cywant> findByExample(Cywant instance) {
		log.debug("finding Cywant instance by example");
		try {
			List<Cywant> results = (List<Cywant>) getCurrentSession()
					.createCriteria("com.cyporj.model.Cywant")
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
		log.debug("finding Cywant instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cywant as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cywant> findByCywtitle(Object cywtitle) {
		return findByProperty(CYWTITLE, cywtitle);
	}

	public List<Cywant> findByCywstr(Object cywstr) {
		return findByProperty(CYWSTR, cywstr);
	}

	public List<Cywant> findByCywprice(Object cywprice) {
		return findByProperty(CYWPRICE, cywprice);
	}

	public List<Cywant> findByCywdate(Object cywdate) {
		return findByProperty(CYWDATE, cywdate);
	}

	public List findAll() {
		log.debug("finding all Cywant instances");
		try {
			String queryString = "from Cywant";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cywant merge(Cywant detachedInstance) {
		log.debug("merging Cywant instance");
		try {
			Cywant result = (Cywant) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cywant instance) {
		log.debug("attaching dirty Cywant instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cywant instance) {
		log.debug("attaching clean Cywant instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CywantDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CywantDAO) ctx.getBean("CywantDAO");
	}
}