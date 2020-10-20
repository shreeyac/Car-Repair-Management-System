package com.CarRepairManagementSystem.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Job implements Serializable {

    /** identifier field */
    private Long pkJobId;

    /** persistent field */
    private String jobName;

    /** persistent field */
    private Integer timeRequired;

    /** persistent field */
    private String whyNeeded;

    /** persistent field */
    private BigDecimal price;

    /** nullable persistent field */
    private String jobImage;

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
    private com.CarRepairManagementSystem.pojo.TypeOfJob typeOfJob;

    /** persistent field */
    private com.CarRepairManagementSystem.pojo.Description description;

    /** persistent field */
    private Set descriptions;

    /** persistent field */
    private Set bookingItems;

    /** full constructor */
    public Job(Long pkJobId, String jobName, Integer timeRequired, String whyNeeded, BigDecimal price, String jobImage, String isActive, Date createdDate, String createdBy, Date modifyDate, String modifyBy, com.CarRepairManagementSystem.pojo.TypeOfJob typeOfJob, com.CarRepairManagementSystem.pojo.Description description, Set descriptions, Set bookingItems) {
        this.pkJobId = pkJobId;
        this.jobName = jobName;
        this.timeRequired = timeRequired;
        this.whyNeeded = whyNeeded;
        this.price = price;
        this.jobImage = jobImage;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.typeOfJob = typeOfJob;
        this.description = description;
        this.descriptions = descriptions;
        this.bookingItems = bookingItems;
    }

    /** default constructor */
    public Job() {
    }

    /** minimal constructor */
    public Job(Long pkJobId, String jobName, Integer timeRequired, String whyNeeded, BigDecimal price, com.CarRepairManagementSystem.pojo.TypeOfJob typeOfJob, com.CarRepairManagementSystem.pojo.Description description, Set descriptions, Set bookingItems) {
        this.pkJobId = pkJobId;
        this.jobName = jobName;
        this.timeRequired = timeRequired;
        this.whyNeeded = whyNeeded;
        this.price = price;
        this.typeOfJob = typeOfJob;
        this.description = description;
        this.descriptions = descriptions;
        this.bookingItems = bookingItems;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPkJobId() {
        return this.pkJobId;
    }

    public void setPkJobId(Long pkJobId) {
        this.pkJobId = pkJobId;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getTimeRequired() {
        return this.timeRequired;
    }

    public void setTimeRequired(Integer timeRequired) {
        this.timeRequired = timeRequired;
    }

    public String getWhyNeeded() {
        return this.whyNeeded;
    }

    public void setWhyNeeded(String whyNeeded) {
        this.whyNeeded = whyNeeded;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getJobImage() {
        return this.jobImage;
    }

    public void setJobImage(String jobImage) {
        this.jobImage = jobImage;
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

    public com.CarRepairManagementSystem.pojo.TypeOfJob getTypeOfJob() {
        return this.typeOfJob;
    }

    public void setTypeOfJob(com.CarRepairManagementSystem.pojo.TypeOfJob typeOfJob) {
        this.typeOfJob = typeOfJob;
    }

    public com.CarRepairManagementSystem.pojo.Description getDescription() {
        return this.description;
    }

    public void setDescription(com.CarRepairManagementSystem.pojo.Description description) {
        this.description = description;
    }

    public Set getDescriptions() {
        return this.descriptions;
    }

    public void setDescriptions(Set descriptions) {
        this.descriptions = descriptions;
    }

    public Set getBookingItems() {
        return this.bookingItems;
    }

    public void setBookingItems(Set bookingItems) {
        this.bookingItems = bookingItems;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkJobId", getPkJobId())
            .toString();
    }

}
