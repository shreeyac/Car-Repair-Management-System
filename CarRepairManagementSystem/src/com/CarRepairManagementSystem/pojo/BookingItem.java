package com.CarRepairManagementSystem.pojo;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class BookingItem implements Serializable {

    /** identifier field */
    private Long pkBookinItemId;

    /** persistent field */
    private Long price;

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
    private com.CarRepairManagementSystem.pojo.Booking booking;

    /** persistent field */
    private com.CarRepairManagementSystem.pojo.Job job;

    /** full constructor */
    public BookingItem(Long pkBookinItemId, Long price, String isActive, Date createdDate, String createdBy, Date modifyDate, String modifyBy, com.CarRepairManagementSystem.pojo.Booking booking, com.CarRepairManagementSystem.pojo.Job job) {
        this.pkBookinItemId = pkBookinItemId;
        this.price = price;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.booking = booking;
        this.job = job;
    }

    /** default constructor */
    public BookingItem() {
    }

    /** minimal constructor */
    public BookingItem(Long pkBookinItemId, Long price, com.CarRepairManagementSystem.pojo.Booking booking, com.CarRepairManagementSystem.pojo.Job job) {
        this.pkBookinItemId = pkBookinItemId;
        this.price = price;
        this.booking = booking;
        this.job = job;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPkBookinItemId() {
        return this.pkBookinItemId;
    }

    public void setPkBookinItemId(Long pkBookinItemId) {
        this.pkBookinItemId = pkBookinItemId;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
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

    public com.CarRepairManagementSystem.pojo.Booking getBooking() {
        return this.booking;
    }

    public void setBooking(com.CarRepairManagementSystem.pojo.Booking booking) {
        this.booking = booking;
    }

    public com.CarRepairManagementSystem.pojo.Job getJob() {
        return this.job;
    }

    public void setJob(com.CarRepairManagementSystem.pojo.Job job) {
        this.job = job;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkBookinItemId", getPkBookinItemId())
            .toString();
    }

}
