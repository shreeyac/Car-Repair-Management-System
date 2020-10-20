package com.CarRepairManagementSystem.beans;

import java.math.BigDecimal;

public class JobBean 
{
	private long pkJobId;
	private String jobName;
	private int timeRequired;
	private BigDecimal price;
	private String jobImage;
	public long getPkJobId() {
		return pkJobId;
	}
	public void setPkJobId(long pkJobId) {
		this.pkJobId = pkJobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public int getTimeRequired() {
		return timeRequired;
	}
	public void setTimeRequired(int timeRequired) {
		this.timeRequired = timeRequired;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal obj) {
		this.price = obj;
	}
	public String getJobImage() {
		return jobImage;
	}
	public void setJobImage(String jobImage) {
		this.jobImage = jobImage;
	}
	
	

}
