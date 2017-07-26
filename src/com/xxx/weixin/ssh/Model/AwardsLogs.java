package com.xxx.weixin.ssh.Model;

/**
 * AwardsLogs entity. @author MyEclipse Persistence Tools
 */
public class AwardsLogs extends AbstractAwardsLogs implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public AwardsLogs() {
	}

	/** full constructor */
	public AwardsLogs(String userId, String username, Integer awardId, String actionTime) {
		super(userId, username, awardId, actionTime);
	}

}
