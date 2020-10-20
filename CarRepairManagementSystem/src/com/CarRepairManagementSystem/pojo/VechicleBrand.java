package com.CarRepairManagementSystem.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class VechicleBrand implements Serializable {

    /** identifier field */
    private Long pkVechicleBrandId;

    /** persistent field */
    private String brandName;

    /** nullable persistent field */
    private String brandImage;

    /** nullable persistent field */
    private String isActive;

    /** nullable persistent field */
    private Date createDate;

    /** nullable persistent field */
    private String createdBy;

    /** nullable persistent field */
    private Date modifyDate;

    /** nullable persistent field */
    private String modifyBy;

    /** persistent field */
    private Set carModals;

    /** full constructor */
    public VechicleBrand(Long pkVechicleBrandId, String brandName, String brandImage, String isActive, Date createDate, String createdBy, Date modifyDate, String modifyBy, Set carModals) {
        this.pkVechicleBrandId = pkVechicleBrandId;
        this.brandName = brandName;
        this.brandImage = brandImage;
        this.isActive = isActive;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.carModals = carModals;
    }

    /** default constructor */
    public VechicleBrand() {
    }

    /** minimal constructor */
    public VechicleBrand(Long pkVechicleBrandId, String brandName, Set carModals) {
        this.pkVechicleBrandId = pkVechicleBrandId;
        this.brandName = brandName;
        this.carModals = carModals;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPkVechicleBrandId() {
        return this.pkVechicleBrandId;
    }

    public void setPkVechicleBrandId(Long pkVechicleBrandId) {
        this.pkVechicleBrandId = pkVechicleBrandId;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImage() {
        return this.brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Set getCarModals() {
        return this.carModals;
    }

    public void setCarModals(Set carModals) {
        this.carModals = carModals;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkVechicleBrandId", getPkVechicleBrandId())
            .toString();
    }

}
