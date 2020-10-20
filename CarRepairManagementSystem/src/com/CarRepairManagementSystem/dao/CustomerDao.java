package com.CarRepairManagementSystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRepairManagementSystem.pojo.CarModal;
import com.CarRepairManagementSystem.pojo.Customer;
import com.CarRepairManagementSystem.utils.ConfigDB;



public class CustomerDao 
{
	public Long registerCustomer(Customer customer ) throws SQLException 
	{
		long count = 0;
		Session session = ConfigDB.getSession();
		Transaction tx = session.beginTransaction();
		try
		{
			count=(Long) session.save(customer);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			tx.rollback();
		}
		finally
		{
			ConfigDB.closeSessionFactory();
		}
		return count;
		
	}
	
	public List loginCustomer(String email, String password) 
	{
		List list = null;

		Session session = ConfigDB.getSession();

		String sqlQuery = "select email,password,isAdmin,firstName,lastName,pkCustomerId from Customer  where email = :email and password = :password ";
		Query query = session.createQuery(sqlQuery);
		query.setParameter("email", email);
		query.setParameter("password", password);

		list = query.list();

		return list;

	}

	public Customer getCustomerById(long customerId)
	{
		Session session = ConfigDB.getSession();
		Customer customer  = (Customer) session.get(Customer.class, customerId);
		return customer;
		
	}
}
