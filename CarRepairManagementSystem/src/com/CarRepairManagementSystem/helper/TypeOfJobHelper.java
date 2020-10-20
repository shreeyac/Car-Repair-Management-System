package com.CarRepairManagementSystem.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.CarRepairManagementSystem.beans.StatusBean;
import com.CarRepairManagementSystem.beans.TypeofjobBean;
import com.CarRepairManagementSystem.dao.CarModalDao;
import com.CarRepairManagementSystem.dao.TypeOfJobDao;
import com.CarRepairManagementSystem.dao.VechicleBrandDao;
import com.CarRepairManagementSystem.pojo.TypeOfJob;

public class TypeOfJobHelper 
{
	public List getTypeOfJob()
	{
		List list = new TypeOfJobDao().getTypeOfJob();
		List typeOfJobList = null;
		
		if(list != null && list.size() > 0)
		{
			typeOfJobList = new ArrayList();
			for(int i=0; i < list.size() ; i++ )
			{
				Object[] obj = (Object[]) list.get(i);
				TypeofjobBean typeofjobBean = new TypeofjobBean();
				typeofjobBean.setPkTypeOfJobId((Long)obj[0]);
				typeofjobBean.setTypeOfJobName(obj[1].toString());
				typeofjobBean.setDescription(obj[2].toString());
				typeofjobBean.setImgSrc(obj[3].toString());
				
				typeOfJobList.add(typeofjobBean);
			}
		}
	return typeOfJobList ;
	}

	public StatusBean saveTypeOfJob(long id, String serviceName, String serviceDesc, String serviceImg)
	{
		StatusBean statusBean= new StatusBean();
		TypeOfJob typeOfJob = new TypeOfJob();
		typeOfJob.setTypeOfJobName(serviceName);
		typeOfJob.setTypeOfJobDesc(serviceDesc);
		typeOfJob.setTypeOfJobImage(serviceImg);
		typeOfJob.setIsActive("y");
		typeOfJob.setCreatedBy(String.valueOf(id));
		typeOfJob.setCreatedDate(new Date());
		long status = new TypeOfJobDao().saveTypeOfJob(typeOfJob);
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
	
	public List getTypeOfJobList()
	{
		return new TypeOfJobDao().getTypeOfJobList();
	}
}
