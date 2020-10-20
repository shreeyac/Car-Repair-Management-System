package com.CarRepairManagementSystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.CarRepairManagementSystem.pojo.CarModal;
import com.CarRepairManagementSystem.pojo.VechicleBrand;
import com.CarRepairManagementSystem.utils.ConfigDB;



public class CarModalDao 
{
	public List getCarModal(long pkBrandId)
	{
		
		Session session = ConfigDB.getSession();
		
		String queryString = "SELECT pkCarModalId, carModalName "
							+ " FROM CarModal "
							+ " WHERE vechicleBrand.id=:pkBrandId";
		
		Query query = session.createQuery(queryString);
		query.setParameter("pkBrandId", (Long)pkBrandId);
		List list = query.list();
		return list;
	}

	public List getCarBrandModal(long brandId, long modald)
	{
		Session session = ConfigDB.getSession();
		
		String queryString = "SELECT brand.pkVechicleBrandId, brand.brandName, c.pkCarModalId, c.carModalName"
							+ " FROM CarModal c "
							+ " JOIN c.vechicleBrand brand"
							+ " WHERE brand.pkVechicleBrandId=:pkBrandId"
							+ " AND c.pkCarModalId=:pkCarModalId";
		
		Query query = session.createQuery(queryString);
		query.setParameter("pkBrandId", (Long)brandId);
		query.setParameter("pkCarModalId", (Long)modald);
		List list = query.list();
		return list;
	}
	
	public CarModal getCarModalById(long modalId)
	{
		Session session = ConfigDB.getSession();
		CarModal carModal = (CarModal) session.get(CarModal.class, modalId);
		return carModal;
		
	}

	public long saveModal(CarModal carModal) 
	{
		long count = 0;
		Session session = ConfigDB.getSession();
		Transaction tx = session.beginTransaction();
		try
		{
			count=(Long) session.save(carModal);
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
