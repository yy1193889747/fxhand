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

import com.cyporj.model.Cyclassd;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cyclassd entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cyporj.model.Cyclassd
 * @author MyEclipse Persistence Tools
 */
@Repository("cyclassdDAO")
@Transactional
public class CyclassdDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CyclassdDAO.class);
	// property constants
	public static final String CDNAME = "cdname";
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

	public void save(Cyclassd transientInstance) {
		log.debug("saving Cyclassd instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cyclassd persistentInstance) {
		log.debug("deleting Cyclassd instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cyclassd findById(java.lang.Integer id) {
		log.debug("getting Cyclassd instance with id: " + id);
		try {
			Cyclassd instance = (Cyclassd) getCurrentSession().get(
					"com.cyporj.model.Cyclassd", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cyclassd> findByExample(Cyclassd instance) {
		log.debug("finding Cyclassd instance by example");
		try {
			List<Cyclassd> results = (List<Cyclassd>) getCurrentSession()
					.createCriteria("com.cyporj.model.Cyclassd")
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
		log.debug("finding Cyclassd instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cyclassd as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cyclassd> findByCdname(Object cdname) {
		return findByProperty(CDNAME, cdname);
	}

	public List findAll() {
		log.debug("finding all Cyclassd instances");
		try {
			String queryString = "from Cyclassd";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cyclassd merge(Cyclassd detachedInstance) {
		log.debug("merging Cyclassd instance");
		try {
			Cyclassd result = (Cyclassd) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cyclassd instance) {
		log.debug("attaching dirty Cyclassd instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cyclassd instance) {
		log.debug("attaching clean Cyclassd instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List<Cyclassd> findbycgid(int i) {
		try {
			String queryString = "from Cyclassd where cgid="+i;
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	public static CyclassdDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CyclassdDAO) ctx.getBean("CyclassdDAO");
	}
}