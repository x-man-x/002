package com.xxx.weixin.ssh.DAO;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xxx.weixin.ssh.Model.Awards;

/**
 * A data access object (DAO) providing persistence and search support for
 * Awards entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xxx.weixin.ssh.Model.Awards
 * @author MyEclipse Persistence Tools
 */
public class AwardsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AwardsDAO.class);
	// property constants
	public static final String AWARD_ID = "awardId";
	public static final String NUMS = "nums";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(Awards transientInstance) {
		log.debug("saving Awards instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Awards persistentInstance) {
		log.debug("deleting Awards instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Awards findById(java.lang.Integer id) {
		log.debug("getting Awards instance with id: " + id);
		try {
			Awards instance = (Awards) getHibernateTemplate().get("com.xxx.weixin.ssh.Model.Awards", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Awards instance) {
		log.debug("finding Awards instance by example");
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
		log.debug("finding Awards instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Awards as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAwardId(Object awardId) {
		return findByProperty(AWARD_ID, awardId);
	}

	public List findByNums(Object nums) {
		return findByProperty(NUMS, nums);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Awards instances");
		try {
			String queryString = "from Awards";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Awards merge(Awards detachedInstance) {
		log.debug("merging Awards instance");
		try {
			Awards result = (Awards) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Awards instance) {
		log.debug("attaching dirty Awards instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Awards instance) {
		log.debug("attaching clean Awards instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AwardsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AwardsDAO) ctx.getBean("AwardsDAO");
	}
}