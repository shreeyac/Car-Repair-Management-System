package com.CarRepairManagementSystem.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class TypeOfJob implements Serializable {

    /** identifier field */
    private Long pkTypeOfJobId;

    /** persistent field */
    private String typeOfJobName;

    /** nullable persistent field */
    private String typeOfJobDesc;

    /** nullable persistent field */
    private String typeOfJobImage;

    /** nullable persistent field */
    private String isActive;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private String createdBy;

    /** nullable persistent field */
    private Date modifyDate;

    /** nullable persistent field */
    private String modifyBy;

    /** persistent field */
    private Set jobs;

    /** full constructor */
    public TypeOfJob(Long pkTypeOfJobId, String typeOfJobName, String typeOfJobDesc, String typeOfJobImage, String isActive, Date createdDate, String createdBy, Date modifyDate, String modifyBy, Set jobs) {
        this.pkTypeOfJobId = pkTypeOfJobId;
        this.typeOfJobName = typeOfJobName;
        this.typeOfJobDesc = typeOfJobDesc;
        this.typeOfJobImage = typeOfJobImage;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.jobs = jobs;
    }

    /** default constructor */
    public TypeOfJob() {
    }

    /** minimal constructor */
    public TypeOfJob(Long pkTypeOfJobId, String typeOfJobName, Set jobs) {
        this.pkTypeOfJobId = pkTypeOfJobId;
        this.typeOfJobName = typeOfJobName;
        this.jobs = jobs;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPkTypeOfJobId() {
        return this.pkTypeOfJobId;
    }

    public void setPkTypeOfJobId(Long pkTypeOfJobId) {
        this.pkTypeOfJobId = pkTypeOfJobId;
    }

    public String getTypeOfJobName() {
        return this.typeOfJobName;
    }

    public void setTypeOfJobName(String typeOfJobName) {
        this.typeOfJobName = typeOfJobName;
    }

    public String getTypeOfJobDesc() {
        return this.typeOfJobDesc;
    }

    public void setTypeOfJobDesc(String typeOfJobDesc) {
        this.typeOfJobDesc = typeOfJobDesc;
    }

    public String getTypeOfJobImage() {
        return this.typeOfJobImage;
    }

    public void setTypeOfJobImage(String typeOfJobImage) {
        this.typeOfJobImage = typeOfJobImage;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifyDate() {
        return this.modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return this.modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Set getJobs() {
        return this.jobs;
    }

    public void setJobs(Set jobs) {
        this.jobs = jobs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkTypeOfJobId", getPkTypeOfJobId())
            .toString();
    }

}
