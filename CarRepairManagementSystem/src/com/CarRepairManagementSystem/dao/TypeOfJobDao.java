package com.CarRepairManagementSystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRepairManagementSystem.pojo.TypeOfJob;
import com.CarRepairManagementSystem.pojo.VechicleBrand;
import com.CarRepairManagementSystem.utils.ConfigDB;

public class TypeOfJobDao 
{
	public List getTypeOfJob()
	{
		List list = null;
		Session session = ConfigDB.getSession();
		
		String queryString = "SELECT pkTypeOfJobId, typeOfJobName, typeOfJobDesc, typeOfJobImage"
							+ " FROM TypeOfJob";
		
		Query query = session.createQuery(queryString);
		
		list = query.list();
		
		
		return list;
	}

	public long saveTypeOfJob(TypeOfJob typeOfJob) 
	{
		long count = 0;
		Session session = ConfigDB.getSession();
		Transaction tx = session.beginTransaction();
		try
		{
			count=(Long) session.save(typeOfJob);
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
	
	public List getTypeOfJobList()
	{
		List list = null;
		Session session = ConfigDB.getSession();
		
		String queryString = "SELECT pkTypeOfJobId, typeOfJobName"
							+ " FROM TypeOfJob";
		
		Query query = session.createQuery(queryString);
		
		list = query.list();
		
		
		return list;
	}

	public TypeOfJob getTypeOfJobPojo(long typejobId) 
	{
		
		Session session = ConfigDB.getSession();
		TypeOfJob typeOfJob = (TypeOfJob) session.get(TypeOfJob.class, typejobId);
		return typeOfJob;
	}
}
