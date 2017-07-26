package com.xxx.weixin.ssh.Model;

/**
 * AbstractAwardsLogs entity provides the base persistence definition of the
 * AwardsLogs entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAwardsLogs implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private String username;
	private Integer awardId;
	private String actionTime;

	// Constructors

	/** default constructor */
	public AbstractAwardsLogs() {
	}

	/** full constructor */
	public AbstractAwardsLogs(String userId, String username, Integer awardId, String actionTime) {
		this.userId = userId;
		this.username = username;
		this.awardId = awardId;
		this.actionTime = actionTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAwardId() {
		return this.awardId;
	}

	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}

	public String getActionTime() {
		return this.actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

}