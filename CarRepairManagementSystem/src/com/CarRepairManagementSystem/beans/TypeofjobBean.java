package com.CarRepairManagementSystem.beans;

public class TypeofjobBean 
{
	private long pkTypeOfJobId;
	private String typeOfJobName;
	private String description;
	private String imgSrc;
	public long getPkTypeOfJobId() {
		return pkTypeOfJobId;
	}
	public void setPkTypeOfJobId(long pkTypeOfJobId) {
		this.pkTypeOfJobId = pkTypeOfJobId;
	}
	public String getTypeOfJobName() {
		return typeOfJobName;
	}
	public void setTypeOfJobName(String typeOfJobName) {
		this.typeOfJobName = typeOfJobName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	

}
