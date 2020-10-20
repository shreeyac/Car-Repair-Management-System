package com.CarRepairManagementSystem.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRepairManagementSystem.pojo.Customer;
import com.CarRepairManagementSystem.pojo.Job;
import com.CarRepairManagementSystem.utils.ConfigDB;

public class JobDao 
{
	public List getJob(BigDecimal jobId)
	{
		List list = null;
		Session session = ConfigDB.getSession();
		
		String queryString = "SELECT pkJobId, jobName, timeRequired, price,jobImage"
							+ " FROM Job "
							+ " WHERE typeOfJob.id=:jobId";
		
		Query query = session.createQuery(queryString);
		query.setBigDecimal("jobId", jobId);
		list = query.list();
		
		
		return list;
	}
	public List getJobList(BigDecimal jobId)
	{
		List list = null;
		Session session = ConfigDB.getSession();
		
		String queryString = "SELECT pkJobId, jobName, timeRequired, price,jobImage"
							+ " FROM Job "
							+ " WHERE pkJobId=:jobId";
		
		Query query = session.createQuery(queryString);
		query.setBigDecimal("jobId", jobId);
		list = query.list();
		
		
		return list;
	}
	
	public Job getJobById(long id)
	{
		Session session = ConfigDB.getSession();
		Job job  = (Job) session.get(Job.class, id);
		return job;
		
	}
	
	public long savejob(Job job) 
	{
		long count = 0;
		Session session = ConfigDB.getSession();
		Transaction tx = session.beginTransaction();
		try
		{
			count=(Long) session.save(job);
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

}
