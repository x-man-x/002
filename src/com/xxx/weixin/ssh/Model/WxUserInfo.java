package com.xxx.weixin.ssh.Model;

/**
 * WxUserInfo entity. @author MyEclipse Persistence Tools
 */
public class WxUserInfo extends AbstractWxUserInfo implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public WxUserInfo() {
	}

	/** full constructor */
	public WxUserInfo(String openId, Integer subscribe, String subscribeTime, String nickname, Integer sex,
			String country, String province, String city, String privilege, String headImgUrl, String language,
			String unionid) {
		super(openId, subscribe, subscribeTime, nickname, sex, country, province, city, privilege, headImgUrl, language,
				unionid);
	}

}
