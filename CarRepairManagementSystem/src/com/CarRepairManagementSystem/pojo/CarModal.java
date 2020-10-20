package com.CarRepairManagementSystem.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CarModal implements Serializable {

    /** identifier field */
    private Long pkCarModalId;

    /** persistent field */
    private String carModalName;

    /** persistent field */
    private String modalNumber;

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
    private com.CarRepairManagementSystem.pojo.VechicleBrand vechicleBrand;

    /** persistent field */
    private Set bookings;

    /** full constructor */
    public CarModal(Long pkCarModalId, String carModalName, String modalNumber, String isActive, Date createdDate, String createdBy, Date modifyDate, String modifyBy, com.CarRepairManagementSystem.pojo.VechicleBrand vechicleBrand, Set bookings) {
        this.pkCarModalId = pkCarModalId;
        this.carModalName = carModalName;
        this.modalNumber = modalNumber;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.vechicleBrand = vechicleBrand;
        this.bookings = bookings;
    }

    /** default constructor */
    public CarModal() {
    }

    /** minimal constructor */
    public CarModal(Long pkCarModalId, String carModalName, String modalNumber, com.CarRepairManagementSystem.pojo.VechicleBrand vechicleBrand, Set bookings) {
        this.pkCarModalId = pkCarModalId;
        this.carModalName = carModalName;
        this.modalNumber = modalNumber;
        this.vechicleBrand = vechicleBrand;
        this.bookings = bookings;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPkCarModalId() {
        return this.pkCarModalId;
    }

    public void setPkCarModalId(Long pkCarModalId) {
        this.pkCarModalId = pkCarModalId;
    }

    public String getCarModalName() {
        return this.carModalName;
    }

    public void setCarModalName(String carModalName) {
        this.carModalName = carModalName;
    }

    public String getModalNumber() {
        return this.modalNumber;
    }

    public void setModalNumber(String modalNumber) {
        this.modalNumber = modalNumber;
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

    public com.CarRepairManagementSystem.pojo.VechicleBrand getVechicleBrand() {
        return this.vechicleBrand;
    }

    public void setVechicleBrand(com.CarRepairManagementSystem.pojo.VechicleBrand vechicleBrand) {
        this.vechicleBrand = vechicleBrand;
    }

    public Set getBookings() {
        return this.bookings;
    }

    public void setBookings(Set bookings) {
        this.bookings = bookings;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkCarModalId", getPkCarModalId())
            .toString();
    }

}
