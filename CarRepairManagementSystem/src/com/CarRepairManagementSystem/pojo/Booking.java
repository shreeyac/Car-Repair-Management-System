package com.CarRepairManagementSystem.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Booking implements Serializable {

    /** identifier field */
    private Long pkBookingId;

    /** persistent field */
    private String timeOfBooking;
    private String bookingDate;

    /** persistent field */
    private Long totalBookingPrice;

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
    private com.CarRepairManagementSystem.pojo.CarModal carModal;

    /** persistent field */
    private com.CarRepairManagementSystem.pojo.Customer customer;

    /** persistent field */
    private Set bookingItems;

    /** full constructor */
    public Booking(Long pkBookingId, String timeOfBooking,String bookingDate, Long totalBookingPrice, String isActive, Date createdDate, String createdBy, Date modifyDate, String modifyBy, com.CarRepairManagementSystem.pojo.CarModal carModal, com.CarRepairManagementSystem.pojo.Customer customer, Set bookingItems) {
        this.pkBookingId = pkBookingId;
        this.timeOfBooking = timeOfBooking;
        this.bookingDate =bookingDate;
        this.totalBookingPrice = totalBookingPrice;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.carModal = carModal;
        this.customer = customer;
        this.bookingItems = bookingItems;
    }

    /** default constructor */
    public Booking() {
    }

    /** minimal constructor */
    public Booking(Long pkBookingId, String timeOfBooking, String bookingDate, Long totalBookingPrice, com.CarRepairManagementSystem.pojo.CarModal carModal, com.CarRepairManagementSystem.pojo.Customer customer, Set bookingItems) {
        this.pkBookingId = pkBookingId;
        this.timeOfBooking = timeOfBooking;
        this.bookingDate= bookingDate;
        this.totalBookingPrice = totalBookingPrice;
        this.carModal = carModal;
        this.customer = customer;
        this.bookingItems = bookingItems;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPkBookingId() {
        return this.pkBookingId;
    }

    public void setPkBookingId(Long pkBookingId) {
        this.pkBookingId = pkBookingId;
    }

    public String getTimeOfBooking() {
        return this.timeOfBooking;
    }

    public void setTimeOfBooking(String timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
    }

    public Long getTotalBookingPrice() {
        return this.totalBookingPrice;
    }

    public void setTotalBookingPrice(Long totalBookingPrice) {
        this.totalBookingPrice = totalBookingPrice;
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

    public com.CarRepairManagementSystem.pojo.CarModal getCarModal() {
        return this.carModal;
    }

    public void setCarModal(com.CarRepairManagementSystem.pojo.CarModal carModal) {
        this.carModal = carModal;
    }

    public com.CarRepairManagementSystem.pojo.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(com.CarRepairManagementSystem.pojo.Customer customer) {
        this.customer = customer;
    }

    public Set getBookingItems() {
        return this.bookingItems;
    }

    public void setBookingItems(Set bookingItems) {
        this.bookingItems = bookingItems;
    }

    
    public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("pkBookingId", getPkBookingId())
            .toString();
    }

}
