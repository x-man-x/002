package com.xxx.weixin.ssh.DAO;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xxx.weixin.ssh.Model.WxUserInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * WxUserInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xxx.weixin.ssh.Model.WxUserInfo
 * @author MyEclipse Persistence Tools
 */
public class WxUserInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(WxUserInfoDAO.class);
	// property constants
	public static final String OPEN_ID = "openId";
	public static final String SUBSCRIBE = "subscribe";
	public static final String SUBSCRIBE_TIME = "subscribeTime";
	public static final String NICKNAME = "nickname";
	public static final String SEX = "sex";
	public static final String COUNTRY = "country";
	public static final String PROVINCE = "province";
	public static final String CITY = "city";
	public static final String PRIVILEGE = "privilege";
	public static final String HEAD_IMG_URL = "headImgUrl";
	public static final String LANGUAGE = "language";
	public static final String UNIONID = "unionid";

	protected void initDao() {
		// do nothing
	}

	public void save(WxUserInfo transientInstance) {
		log.debug("saving WxUserInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(WxUserInfo persistentInstance) {
		log.debug("deleting WxUserInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WxUserInfo findById(java.lang.Integer id) {
		log.debug("getting WxUserInfo instance with id: " + id);
		try {
			WxUserInfo instance = (WxUserInfo) getHibernateTemplate().get("com.xxx.weixin.ssh.Model.WxUserInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(WxUserInfo instance) {
		log.debug("finding WxUserInfo instance by example");
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
		log.debug("finding WxUserInfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from WxUserInfo as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOpenId(Object openId) {
		return findByProperty(OPEN_ID, openId);
	}

	public List findBySubscribe(Object subscribe) {
		return findByProperty(SUBSCRIBE, subscribe);
	}

	public List findBySubscribeTime(Object subscribeTime) {
		return findByProperty(SUBSCRIBE_TIME, subscribeTime);
	}

	public List findByNickname(Object nickname) {
		return findByProperty(NICKNAME, nickname);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByCountry(Object country) {
		return findByProperty(COUNTRY, country);
	}

	public List findByProvince(Object province) {
		return findByProperty(PROVINCE, province);
	}

	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findByPrivilege(Object privilege) {
		return findByProperty(PRIVILEGE, privilege);
	}

	public List findByHeadImgUrl(Object headImgUrl) {
		return findByProperty(HEAD_IMG_URL, headImgUrl);
	}

	public List findByLanguage(Object language) {
		return findByProperty(LANGUAGE, language);
	}

	public List findByUnionid(Object unionid) {
		return findByProperty(UNIONID, unionid);
	}

	public List findAll() {
		log.debug("finding all WxUserInfo instances");
		try {
			String queryString = "from WxUserInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public WxUserInfo merge(WxUserInfo detachedInstance) {
		log.debug("merging WxUserInfo instance");
		try {
			WxUserInfo result = (WxUserInfo) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(WxUserInfo instance) {
		log.debug("attaching dirty WxUserInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WxUserInfo instance) {
		log.debug("attaching clean WxUserInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WxUserInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WxUserInfoDAO) ctx.getBean("WxUserInfoDAO");
	}
}