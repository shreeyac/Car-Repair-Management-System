package com.CarRepairManagementSystem.helper;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.SQLException;

import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.CarRepairManagementSystem.beans.BrandModalBean;
import com.CarRepairManagementSystem.beans.CustomerBean;
import com.CarRepairManagementSystem.beans.StatusBean;
import com.CarRepairManagementSystem.dao.BookingDao;
import com.CarRepairManagementSystem.dao.BookingItemDao;
import com.CarRepairManagementSystem.dao.CarModalDao;
import com.CarRepairManagementSystem.dao.CustomerDao;
import com.CarRepairManagementSystem.dao.JobDao;
import com.CarRepairManagementSystem.pojo.Booking;
import com.CarRepairManagementSystem.pojo.BookingItem;
import com.CarRepairManagementSystem.pojo.CarModal;
import com.CarRepairManagementSystem.pojo.Customer;
import com.CarRepairManagementSystem.pojo.Job;




public class CustomerHelper 
{
	public StatusBean registerCustomer(CustomerBean bean) throws SQLException 
	{
		StatusBean statusBean = new StatusBean();
		
		Customer customer = new Customer();
		customer.setFirstName(bean.getFirstName());
		customer.setLastName(bean.getLastName());
		customer.setEmail(bean.getEmail());
		customer.setMobileNo(bean.getMobileNo());
		customer.setCity(bean.getCity());
		customer.setAddress(bean.getAddress());
		customer.setPassword(bean.getPassword());
		long status = new CustomerDao().registerCustomer(customer);
		  if (status > 0) 
		  {
			   statusBean.setMessage("registerd successfully");
			   statusBean.setStatus(true);
		  }
		  else
		  {
			   statusBean.setMessage("registerd unsuccessfully");
			   statusBean.setStatus(false);
		  }
		  
		return statusBean;
		
		
	}
	public StatusBean bookJob(long Totalprice,long modalId,long customerId,List list,String appDate,String bookingTime) throws SQLException 
	{
		long status = 0;
		StatusBean statusBean = new StatusBean();
		  
		CarModal carModal = new CarModalDao().getCarModalById(modalId);
		Customer customer = new CustomerDao().getCustomerById(customerId);
		Booking booking = new Booking();
		booking.setBookingDate(appDate);
		booking.setTimeOfBooking(bookingTime);
		booking.setIsActive("y");
		booking.setCreatedDate(new Date());
		booking.setCarModal(carModal);
		booking.setCustomer(customer);
		booking.setTotalBookingPrice(Totalprice);
		long bookinId = new BookingDao().saveBooking(booking);
		Booking booking2 = new BookingDao().getBooingById(bookinId);
		ListIterator iterator = list.listIterator();
		while(iterator.hasNext())
		{
			
			String id = (String) iterator.next();
			Job job = new JobDao().getJobById(Long.parseLong(id));
			BigDecimal price = job.getPrice();
			BookingItem bookingItem = new BookingItem();
			bookingItem.setBooking(booking2);
			bookingItem.setJob(job);
			bookingItem.setPrice(price.longValue());
			 status = new BookingItemDao().saveBookingItem(bookingItem);
		}	
		if (status > 0) 
		  {
			   statusBean.setMessage("registerd successfully");
			   statusBean.setStatus(true);
		  }
		  else
		  {
			   statusBean.setMessage("registerd unsuccessfully");
			   statusBean.setStatus(false);
		  }
		  
		return statusBean;
	
		
		  
		
		
	}
	public StatusBean loginCustomer(String email,String password)throws SQLException 
	{
		StatusBean statusBean = new StatusBean();
		if(email != null && !"".equals(email) && password != null && !"".equals(password))
		{
			List list = new CustomerDao().loginCustomer(email, password);
		
			
			if(list!=null && list.size()>0)
			{
				
				
				for(int i=0; i < list.size(); i++)
				{
					Object[] obj = (Object[])list.get(i);
					
					CustomerBean bean = new CustomerBean();
					bean.setEmail(obj[0].toString());
					bean.setPassword(obj[1].toString());
					bean.setIsAdmin(obj[2].toString());
					bean.setFirstName(obj[3].toString());
					bean.setLastName(obj[4].toString());
					bean.setPkCustomerId((Long) obj[5]);
					statusBean.setCustomerBean(bean);
					statusBean.setMessage("User Exist");
					statusBean.setStatus(true);
				}
			}
			else
			{
				statusBean.setMessage("User not Exist");
				statusBean.setStatus(false);
			}
		}
		else
		{
			statusBean.setMessage("Email or password is invalid");
			statusBean.setStatus(false);
		}
		  
		return statusBean;
	}
}
