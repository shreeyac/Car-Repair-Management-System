package com.CarRepairManagementSystem.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRepairManagementSystem.pojo.Booking;
import com.CarRepairManagementSystem.pojo.Customer;
import com.CarRepairManagementSystem.utils.ConfigDB;

public class BookingDao 
{
	public Long saveBooking(Booking booking) throws SQLException 
	{
		long count = 0;
		Session session = ConfigDB.getSession();
		Transaction tx = session.beginTransaction();
		try
		{
			count=(Long) session.save(booking);
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
	public Booking getBooingById(long bookingId)
	{
		Session session = ConfigDB.getSession();
		Booking booking  = (Booking) session.get(Booking.class, bookingId);
		return booking;
		
	}

}
