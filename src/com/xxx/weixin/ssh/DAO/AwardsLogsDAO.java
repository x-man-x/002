package com.xxx.weixin.ssh.DAO;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xxx.weixin.ssh.Model.AwardsLogs;

/**
 * A data access object (DAO) providing persistence and search support for
 * AwardsLogs entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xxx.weixin.ssh.Model.AwardsLogs
 * @author MyEclipse Persistence Tools
 */
public class AwardsLogsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AwardsLogsDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USERNAME = "username";
	public static final String AWARD_ID = "awardId";
	public static final String ACTION_TIME = "actionTime";

	protected void initDao() {
		// do nothing
	}

	public void save(AwardsLogs transientInstance) {
		log.debug("saving AwardsLogs instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AwardsLogs persistentInstance) {
		log.debug("deleting AwardsLogs instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AwardsLogs findById(java.lang.Integer id) {
		log.debug("getting AwardsLogs instance with id: " + id);
		try {
			AwardsLogs instance = (AwardsLogs) getHibernateTemplate().get("com.xxx.weixin.ssh.Model.AwardsLogs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AwardsLogs instance) {
		log.debug("finding AwardsLogs instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AwardsLogs instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from AwardsLogs as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByAwardId(Object awardId) {
		return findByProperty(AWARD_ID, awardId);
	}

	public List findByActionTime(Object actionTime) {
		return findByProperty(ACTION_TIME, actionTime);
	}

	public List findAll() {
		log.debug("finding all AwardsLogs instances");
		try {
			String queryString = "from AwardsLogs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AwardsLogs merge(AwardsLogs detachedInstance) {
		log.debug("merging AwardsLogs instance");
		try {
			AwardsLogs result = (AwardsLogs) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AwardsLogs instance) {
		log.debug("attaching dirty AwardsLogs instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AwardsLogs instance) {
		log.debug("attaching clean AwardsLogs instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AwardsLogsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AwardsLogsDAO) ctx.getBean("AwardsLogsDAO");
	}
}