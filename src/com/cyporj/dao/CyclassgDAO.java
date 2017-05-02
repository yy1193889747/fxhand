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

import com.cyporj.model.Cyclassg;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cyclassg entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cyporj.model.Cyclassg
 * @author MyEclipse Persistence Tools
 */
@Repository("cyclassgDAO")
@Transactional
public class CyclassgDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CyclassgDAO.class);
	// property constants
	public static final String CGNAME = "cgname";

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

	public void save(Cyclassg transientInstance) {
		log.debug("saving Cyclassg instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cyclassg persistentInstance) {
		log.debug("deleting Cyclassg instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cyclassg findById(java.lang.Integer id) {
		log.debug("getting Cyclassg instance with id: " + id);
		try {
			Cyclassg instance = (Cyclassg) getCurrentSession().get(
					"com.cyporj.model.Cyclassg", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cyclassg> findByExample(Cyclassg instance) {
		log.debug("finding Cyclassg instance by example");
		try {
			List<Cyclassg> results = (List<Cyclassg>) getCurrentSession()
					.createCriteria("com.cyporj.model.Cyclassg")
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
		log.debug("finding Cyclassg instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cyclassg as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cyclassg> findByCgname(Object cgname) {
		return findByProperty(CGNAME, cgname);
	}

	public List findAll() {
		log.debug("finding all Cyclassg instances");
		try {
			String queryString = "from Cyclassg";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cyclassg merge(Cyclassg detachedInstance) {
		log.debug("merging Cyclassg instance");
		try {
			Cyclassg result = (Cyclassg) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cyclassg instance) {
		log.debug("attaching dirty Cyclassg instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cyclassg instance) {
		log.debug("attaching clean Cyclassg instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CyclassgDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CyclassgDAO) ctx.getBean("CyclassgDAO");
	}
}