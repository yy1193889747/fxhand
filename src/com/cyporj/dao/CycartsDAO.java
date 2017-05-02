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

import com.cyporj.model.Cycarts;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cycarts entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cyporj.model.Cycarts
 * @author MyEclipse Persistence Tools
 */
@Repository("cycartsDAO")
@Transactional
public class CycartsDAO {
	private static final Logger log = LoggerFactory.getLogger(CycartsDAO.class);
	// property constants

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

	public void save(Cycarts transientInstance) {
		log.debug("saving Cycarts instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cycarts persistentInstance) {
		log.debug("deleting Cycarts instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cycarts findById(java.lang.Integer id) {
		log.debug("getting Cycarts instance with id: " + id);
		try {
			Cycarts instance = (Cycarts) getCurrentSession().get(
					"com.cyporj.model.Cycarts", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cycarts> findByExample(Cycarts instance) {
		log.debug("finding Cycarts instance by example");
		try {
			List<Cycarts> results = (List<Cycarts>) getCurrentSession()
					.createCriteria("com.cyporj.model.Cycarts")
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
		log.debug("finding Cycarts instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cycarts as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Cycarts instances");
		try {
			String queryString = "from Cycarts";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cycarts merge(Cycarts detachedInstance) {
		log.debug("merging Cycarts instance");
		try {
			Cycarts result = (Cycarts) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cycarts instance) {
		log.debug("attaching dirty Cycarts instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cycarts instance) {
		log.debug("attaching clean Cycarts instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CycartsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CycartsDAO) ctx.getBean("CycartsDAO");
	}
}