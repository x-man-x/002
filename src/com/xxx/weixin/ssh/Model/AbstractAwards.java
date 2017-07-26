package com.xxx.weixin.ssh.Model;

/**
 * AbstractAwards entity provides the base persistence definition of the Awards
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAwards implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer awardId;
	private Integer nums;
	private String description;

	// Constructors

	/** default constructor */
	public AbstractAwards() {
	}

	/** full constructor */
	public AbstractAwards(Integer awardId, Integer nums, String description) {
		this.awardId = awardId;
		this.nums = nums;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAwardId() {
		return this.awardId;
	}

	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}

	public Integer getNums() {
		return this.nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}