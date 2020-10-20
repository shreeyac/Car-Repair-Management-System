package com.CarRepairManagementSystem.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Description implements Serializable {

    /** identifier field */
    private Long pkDescriptionId;

    /** persistent field */
    private String descName;

    /** nullable persistent field */
    private String isActive;

    /** nullable persistent field */
    private String createdBy;

    /** nullable persistent field */
    private Date modifyDate;

    /** nullable persistent field */
    private Date createdDate;

    /** nullable persistent field */
    private String modifyBy;

    /** persistent field */
    private com.CarRepairManagementSystem.pojo.Job job;

    /** persistent field */
    private Set jobs;

    /** full constructor */
    public Description(Long pkDescriptionId, String descName, String isActive, String createdBy, Date modifyDate, Date createdDate, String modifyBy, com.CarRepairManagementSystem.pojo.Job job, Set jobs) {
        this.pkDescriptionId = pkDescriptionId;
        this.descName = descName;
        this.isActive = isActive;
        this.createdBy = createdBy;
        this.modifyDate = modifyDate;
        this.createdDate = createdDate;
        this.modifyBy = modifyBy;
        this.job = job;
        this.jobs = jobs;
    }

    /** default constructor */
    public Description() {
    }

    /** minimal constructor */
    public Description(Long pkDescriptionId, String descName, com.CarRepairManagementSystem.pojo.Job job, Set jobs) {
        this.pkDescriptionId = pkDescriptionId;
        this.descName = descName;
        this.job = job;
        this.jobs = jobs;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPkDescriptionId() {
        return this.pkDescriptionId;
    }

    public void setPkDescriptionId(Long pkDescriptionId) {
        this.pkDescriptionId = pkDescriptionId;
    }

    public String getDescName() {
        return this.descName;
    }

    public void setDescName(String descName) {
        this.descName = descName;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
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

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifyBy() {
        return this.modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public com.CarRepairManagementSystem.pojo.Job getJob() {
        return this.job;
    }

    public void setJob(com.CarRepairManagementSystem.pojo.Job job) {
        this.job = job;
    }

    public Set getJobs() {
        return this.jobs;
    }

    public void setJobs(Set jobs) {
        this.jobs = jobs;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkDescriptionId", getPkDescriptionId())
            .toString();
    }

}
