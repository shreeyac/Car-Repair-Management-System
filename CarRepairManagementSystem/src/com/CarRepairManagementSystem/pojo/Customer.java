package com.CarRepairManagementSystem.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Customer implements Serializable {

    /** identifier field */
    private Long pkCustomerId;

    /** persistent field */
    private String firstName;

    /** persistent field */
    private String lastName;

    /** persistent field */
    private String mobileNo;

    /** persistent field */
    private String email;

    

    /** persistent field */
    private String city;

    /** persistent field */
    private String address;

    
    private String password;

    /** persistent field */
    private String isAdmin;

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
    private Set bookings;

    /** full constructor */
    public Customer(Long pkCustomerId, String firstName, String lastName, String mobileNo, String email,  String city, String address,String password, String isAdmin, String isActive, Date createdDate, String createdBy, Date modifyDate, String modifyBy, Set bookings) {
        this.pkCustomerId = pkCustomerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.email = email;
        this.city = city;
        this.address = address;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
        this.bookings = bookings;
    }

    /** default constructor */
    public Customer() {
    }

    /** minimal constructor */
    public Customer(Long pkCustomerId, String firstName, String lastName, String mobileNo, String email, String city, String address,String password, String isAdmin, Set bookings) {
        this.pkCustomerId = pkCustomerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.email = email;
        this.city = city;
        this.address = address;
        this.password = password;
        this.isAdmin = isAdmin;
        this.bookings = bookings;
    }

    /** 
     * 		       auto_increment
     * 		    
     */
    public Long getPkCustomerId() {
        return this.pkCustomerId;
    }

    public void setPkCustomerId(Long pkCustomerId) {
        this.pkCustomerId = pkCustomerId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
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

    public Set getBookings() {
        return this.bookings;
    }

    public void setBookings(Set bookings) {
        this.bookings = bookings;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("pkCustomerId", getPkCustomerId())
            .toString();
    }

}
