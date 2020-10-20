package com.CarRepairManagementSystem.helper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.CarRepairManagementSystem.beans.BrandModalBean;
import com.CarRepairManagementSystem.beans.StatusBean;
import com.CarRepairManagementSystem.dao.CarModalDao;
import com.CarRepairManagementSystem.dao.VechicleBrandDao;
import com.CarRepairManagementSystem.pojo.CarModal;
import com.CarRepairManagementSystem.pojo.VechicleBrand;

public class CarModalHelper 
{
	public List getCarModal(long pkBrandId)
	{
		List list=null;
		try
		{
		 list  = new CarModalDao().getCarModal(pkBrandId);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public BrandModalBean getCarBrandModal(long brandId, long modald) 
	{
		
		List list  = new CarModalDao().getCarBrandModal(brandId,modald);
		BrandModalBean brandModalBean = new BrandModalBean();
		if(list != null && list.size() > 0)
		{
			
			for(int i=0; i < list.size() ; i++ )
			{
				Object[] obj = (Object[]) list.get(i);
				
				brandModalBean.setPkbrandid((Long) obj[0]);
				brandModalBean.setBrandName(obj[1].toString());
				brandModalBean.setPkmodalid((Long) obj[2]);
				brandModalBean.setModalName(obj[3].toString());
				
				
			}
		}
	return brandModalBean ;
	}

	public StatusBean saveModal(String modalName, long id, long brandId) 
	{
		StatusBean statusBean = new StatusBean();
		VechicleBrand brand = new VechicleBrandDao().getVechiclerandById(brandId);
		CarModal carModal = new CarModal();
		carModal.setCarModalName(modalName);
		carModal.setVechicleBrand(brand);
		carModal.setIsActive("y");
		carModal.setCreatedDate(new Date());
		carModal.setCreatedBy(String.valueOf(id));
	
		
		long status = new CarModalDao().saveModal(carModal);
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
