package com.xxx.weixin.ssh.Model;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String password, String nickname, Integer age, String flag, Timestamp regtime) {
		super(name, password, nickname, age, flag, regtime);
	}

}
