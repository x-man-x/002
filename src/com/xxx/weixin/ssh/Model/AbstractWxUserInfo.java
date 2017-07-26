package com.xxx.weixin.ssh.Model;

/**
 * AbstractWxUserInfo entity provides the base persistence definition of the
 * WxUserInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWxUserInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String openId;
	private Integer subscribe;
	private String subscribeTime;
	private String nickname;
	private Integer sex;
	private String country;
	private String province;
	private String city;
	private String privilege;
	private String headImgUrl;
	private String language;
	private String unionid;

	// Constructors

	/** default constructor */
	public AbstractWxUserInfo() {
	}

	/** full constructor */
	public AbstractWxUserInfo(String openId, Integer subscribe, String subscribeTime, String nickname, Integer sex,
			String country, String province, String city, String privilege, String headImgUrl, String language,
			String unionid) {
		this.openId = openId;
		this.subscribe = subscribe;
		this.subscribeTime = subscribeTime;
		this.nickname = nickname;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.privilege = privilege;
		this.headImgUrl = headImgUrl;
		this.language = language;
		this.unionid = unionid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getSubscribe() {
		return this.subscribe;
	}

	public void setSubscribe(Integer subscribe) {
		this.subscribe = subscribe;
	}

	public String getSubscribeTime() {
		return this.subscribeTime;
	}

	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getHeadImgUrl() {
		return this.headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUnionid() {
		return this.unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

}