package com.xxx.weixin.ssh.Model;

import java.sql.Timestamp;

public class WxMpAccessToken {
	
	public String grant_type;
	public String appid;
	public String secret;
	public String access_token;
	public String expires_in;
	
	/** full constructor */
	public WxMpAccessToken(String grant_type, String appid, String secret, String access_token,
			String expires_in) {
		this.grant_type = grant_type;
		this.appid = appid;
		this.secret = secret;
		this.access_token = access_token;
		this.expires_in = expires_in;
	}
	
	
	public String getGrant_type() {
		return this.grant_type;
	}
	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
	public String getAppid() {
		return this.appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecret() {
		return this.secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}


	public String getAccess_token() {
		return this.access_token;
	}


	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}


	public String getExpires_in() {
		return this.expires_in;
	}


	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

}
