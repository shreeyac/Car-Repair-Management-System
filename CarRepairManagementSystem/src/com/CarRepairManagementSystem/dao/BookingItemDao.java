package com.CarRepairManagementSystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRepairManagementSystem.pojo.BookingItem;
import com.CarRepairManagementSystem.utils.ConfigDB;

public class BookingItemDao 
{

	public long saveBookingItem(BookingItem bookingItem) 
	{
		
		long count = 0;
		Session session = ConfigDB.getSession();
		Transaction tx = session.beginTransaction();
		try
		{
			count=(Long) session.save(bookingItem);
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
	
	public List getBookings(long userId)
	{
		
		Session session = ConfigDB.getSession();
		
		String queryString = "SELECT booking.bookingDate,booking.timeOfBooking,job.jobName,job.price,bi.price "
							+ " FROM BookingItem bi "
							+ " JOIN bi.booking booking "
							+ " JOIN bi.job job "
							+ " JOIN bi.booking.customer customerinfo"
							+ " WHERE customerinfo.pkCustomerId=:userId ";
		
		Query query = session.createQuery(queryString);
		query.setParameter("userId", (Long)userId);
		List list = query.list();
		return list;
	}

}
