package com.CarRepairManagementSystem.helper;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.CarRepairManagementSystem.beans.StatusBean;
import com.CarRepairManagementSystem.dao.CustomerDao;
import com.CarRepairManagementSystem.dao.VechicleBrandDao;
import com.CarRepairManagementSystem.pojo.VechicleBrand;

public class VechileBrandHelper 
{
	public List getVechicleBrand()
	{
		return new VechicleBrandDao().getVechicleBrand();
	}
	
	public StatusBean saveBrand(String brandName,long id)
	{
		StatusBean statusBean = new StatusBean();
		VechicleBrand brand = new VechicleBrand();
		brand.setBrandName(brandName);
		brand.setCreateDate(new Date());
		brand.setCreatedBy(String.valueOf(id));
		brand.setIsActive("y");
		long status = new VechicleBrandDao().saveBrand(brand);
		  if (status > 0) 
		  {
			   statusBean.setMessage("added successfully");
			   statusBean.setStatus(true);
		  }
		  else
		  {
			   statusBean.setMessage("added unsuccessfully");
			   statusBean.setStatus(false);
		  }
		  
		return statusBean;
		
		
		
	}
}
