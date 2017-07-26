package com.xxx.weixin.ssh.Model;

import java.sql.Timestamp;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String nickname;
	private Integer age;
	private String flag;
	private Timestamp regtime;

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** full constructor */
	public AbstractUser(String name, String password, String nickname, Integer age, String flag, Timestamp regtime) {
		this.name = name;
		this.password = password;
		this.nickname = nickname;
		this.age = age;
		this.flag = flag;
		this.regtime = regtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Timestamp getRegtime() {
		return this.regtime;
	}

	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}

}