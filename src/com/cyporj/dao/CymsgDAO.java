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

import com.cyporj.model.Cymsg;
import com.cyporj.model.Page;

/**
 * A data access object (DAO) providing persistence and search support for Cymsg
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cyporj.model.Cymsg
 * @author MyEclipse Persistence Tools
 */
@Repository("cymsgDAO")
@Transactional
public class CymsgDAO {
	private static final Logger log = LoggerFactory.getLogger(CymsgDAO.class);
	// property constants
	public static final String MSGSTR = "msgstr";
	public static final String MSGDATA = "msgdata";

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

	public void save(Cymsg transientInstance) {
		log.debug("saving Cymsg instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cymsg persistentInstance) {
		log.debug("deleting Cymsg instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cymsg findById(java.lang.Integer id) {
		log.debug("getting Cymsg instance with id: " + id);
		try {
			Cymsg instance = (Cymsg) getCurrentSession().get(
					"com.cyporj.model.Cymsg", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cymsg> findByExample(Cymsg instance) {
		log.debug("finding Cymsg instance by example");
		try {
			List<Cymsg> results = (List<Cymsg>) getCurrentSession()
					.createCriteria("com.cyporj.model.Cymsg")
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
		log.debug("finding Cymsg instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cymsg as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cymsg> findByMsgstr(Object msgstr) {
		return findByProperty(MSGSTR, msgstr);
	}

	public List<Cymsg> findByMsgdata(Object msgdata) {
		return findByProperty(MSGDATA, msgdata);
	}

	public List findAll() {
		log.debug("finding all Cymsg instances");
		try {
			String queryString = "from Cymsg";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cymsg merge(Cymsg detachedInstance) {
		log.debug("merging Cymsg instance");
		try {
			Cymsg result = (Cymsg) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cymsg instance) {
		log.debug("attaching dirty Cymsg instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cymsg instance) {
		log.debug("attaching clean Cymsg instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public void msgpage(Page p) {
		String hql=" from Cymsg ";
		
		Query q=getCurrentSession().createQuery(hql);
		q.setFirstResult((p.getPageNo()-1)*p.getPageSize());
		q.setMaxResults(p.getPageSize());
		p.setList(q.list());
		//查询结果
		hql="select count(msgid)"+hql;
		q=getCurrentSession().createQuery(hql);
		Long count=(Long)q.uniqueResult();
        p.setRowCount(count.intValue());
		
	}
	public static CymsgDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CymsgDAO) ctx.getBean("CymsgDAO");
	}
}