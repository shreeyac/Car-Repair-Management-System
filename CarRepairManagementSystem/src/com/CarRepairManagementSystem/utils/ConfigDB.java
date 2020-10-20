package com.CarRepairManagementSystem.utils;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConfigDB 
{
	private static SessionFactory sessionFactory;
	
	private ConfigDB()
	{
		
	}
	
	static
	{
		try
		{
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Session getSession()
	{
		return sessionFactory.openSession();
	}
	
	public static void closeSession(Session session)
	{
		if(session!=null)
		{
			session.close();
		}
	}
	
	public static void closeSessionFactory()
	{
		if(sessionFactory != null)
		{
			sessionFactory.close();
		}
	}
	 public static String toJSON(Object obj)
		{
		 Gson gson= new GsonBuilder().setPrettyPrinting().create();
			return gson.toJson(obj);
			
		}
}
