package com.CarRepairManagementSystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRepairManagementSystem.pojo.CarModal;
import com.CarRepairManagementSystem.pojo.VechicleBrand;
import com.CarRepairManagementSystem.utils.ConfigDB;

public class VechicleBrandDao 
{
	public List getVechicleBrand()
	{
		List list = null;
		Session session = ConfigDB.getSession();
		
		String queryString = "SELECT pkVechicleBrandId, brandName"
							+ " FROM VechicleBrand";
		
		Query query = session.createQuery(queryString);
		
		list = query.list();
		
		
		return list;
	}

	public long saveBrand(VechicleBrand brand)
	{
		long count = 0;
		Session session = ConfigDB.getSession();
		Transaction tx = session.beginTransaction();
		try
		{
			count=(Long) session.save(brand);
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
	
	public VechicleBrand getVechiclerandById(long modalId)
	{
		Session session = ConfigDB.getSession();
		VechicleBrand vechicleBrand = (VechicleBrand) session.get(VechicleBrand.class, modalId);
		return vechicleBrand;
		
	}
}
