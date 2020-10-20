package com.CarRepairManagementSystem.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.CarRepairManagementSystem.beans.JobBean;
import com.CarRepairManagementSystem.beans.StatusBean;
import com.CarRepairManagementSystem.beans.TypeofjobBean;
import com.CarRepairManagementSystem.dao.CarModalDao;
import com.CarRepairManagementSystem.dao.JobDao;
import com.CarRepairManagementSystem.dao.TypeOfJobDao;
import com.CarRepairManagementSystem.pojo.Job;
import com.CarRepairManagementSystem.pojo.TypeOfJob;


public class JobHelper 
{
	public List getJob(BigDecimal jobId)
	{
		List list = new JobDao().getJob(jobId);
		List jobList = null;
		
		if(list != null && list.size() > 0)
		{
			jobList = new ArrayList();
			for(int i=0; i < list.size() ; i++ )
			{
				Object[] obj = (Object[]) list.get(i);
				JobBean jobBean = new JobBean();
				jobBean.setPkJobId((Long)obj[0]);
				jobBean.setJobName(obj[1].toString());
				jobBean.setTimeRequired((Integer) obj[2]);
				jobBean.setPrice((BigDecimal)obj[3]);
				jobBean.setJobImage(obj[4].toString());
				
				jobList.add(jobBean);
			}
		}
	return jobList ;
	}
	public JobBean getJoblist(BigDecimal jobId)
	{
		List list = new JobDao().getJobList(jobId);
	
		JobBean jobBean = new JobBean();
		if(list != null && list.size() > 0)
		{
			
			for(int i=0; i < list.size() ; i++ )
			{
				Object[] obj = (Object[]) list.get(i);
				
				jobBean.setPkJobId((Long)obj[0]);
				jobBean.setJobName(obj[1].toString());
				jobBean.setTimeRequired((Integer) obj[2]);
				jobBean.setPrice((BigDecimal)obj[3]);
				jobBean.setJobImage(obj[4].toString());
				
				
			}
		}
	return jobBean ;
	}
	public StatusBean saveJob(long id, long typejobId, String jobName, int timeRequired, BigDecimal price,
			String jobImage) 
	{
		StatusBean statusBean = new StatusBean();
		TypeOfJob typeOfJob = new TypeOfJobDao().getTypeOfJobPojo(typejobId);
		Job job = new Job();
		job.setJobName(jobName);
		job.setTimeRequired(timeRequired);
		job.setPrice(price);
		job.setJobImage(jobImage);
		job.setTypeOfJob(typeOfJob);
		job.setIsActive("y");
		job.setCreatedBy(String.valueOf(id));
		job.setCreatedDate(new Date());
		long status = new JobDao().savejob(job);
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
