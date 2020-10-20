package com.CarRepairManagementSystem.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.CarRepairManagementSystem.beans.BrandModalBean;
import com.CarRepairManagementSystem.beans.CustomerBean;
import com.CarRepairManagementSystem.beans.StatusBean;
import com.CarRepairManagementSystem.helper.CarModalHelper;
import com.CarRepairManagementSystem.helper.CustomerHelper;
import com.CarRepairManagementSystem.helper.JobHelper;
import com.CarRepairManagementSystem.helper.TypeOfJobHelper;
import com.CarRepairManagementSystem.helper.VechileBrandHelper;

import net.sf.hibernate.id.IncrementGenerator;


public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CarController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String actionName=request.getParameter("action");
		if(actionName !=null && !"".equals(actionName))
		{
			if(actionName.equals("registerSubmit"))
			{
				CustomerBean bean = new CustomerBean();
				bean.setFirstName(request.getParameter("fname"));
				bean.setLastName(request.getParameter("lname"));
				bean.setEmail(request.getParameter("email"));
				bean.setMobileNo(request.getParameter("mobileno"));
				bean.setCity(request.getParameter("city"));
				bean.setAddress(request.getParameter("address"));
				bean.setPassword(request.getParameter("pass"));
				
				try {
					StatusBean statusBean = new CustomerHelper().registerCustomer(bean);
					if(statusBean.getStatus())
					{
						request.getRequestDispatcher("jsp/success1.jsp").forward(request, response);
					}
					else
					{
						request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			
			if(actionName.equals("loginSubmit"))
			{
				String email = request.getParameter("login_email");
				String password = request.getParameter("login_pass");
				 HttpSession session = request.getSession();
				StatusBean statusBean;
				try {
					statusBean = new CustomerHelper().loginCustomer(email,password);
				
				if(statusBean.getStatus())
				   {
					   if(statusBean.getCustomerBean().getIsAdmin().equalsIgnoreCase("y"))
					   {
						 
						   session.setAttribute("customerId", statusBean.getCustomerBean().getPkCustomerId());
						   session.setAttribute("user",statusBean);
						   request.getRequestDispatcher("jsp/adminPanel.jsp").forward(request, response);
						 
					   }
					   else
					   {
						  
						   session.setAttribute("customerId", statusBean.getCustomerBean().getPkCustomerId());
						   session.setAttribute("user",statusBean);
						   request.getRequestDispatcher("jsp/index.jsp").include(request, response);
						  
					   }
				   }
				   else
				   {
					   request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
				   }
				} catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			if(actionName.equals("addBrand"))
			{
				HttpSession httpSession = request.getSession();
				StatusBean statusBean = (StatusBean)httpSession.getAttribute("user");
				
				long id = statusBean.getCustomerBean().getPkCustomerId();
				String barndName= request.getParameter("brandName");
				StatusBean statusBean2 = new VechileBrandHelper().saveBrand(barndName,id);
				if(statusBean2.getStatus())
				{
					request.getRequestDispatcher("jsp/success1.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
				}
			}
			if(actionName.equals("addModal"))
			{
				HttpSession httpSession = request.getSession();
				StatusBean statusBean = (StatusBean)httpSession.getAttribute("user");
				
				long id = statusBean.getCustomerBean().getPkCustomerId();
				String modalName= request.getParameter("modalName");
				long brandId = Long.valueOf(request.getParameter("brandId"));
				StatusBean statusBean2 = new  CarModalHelper().saveModal(modalName,id,brandId);
				if(statusBean2.getStatus())
				{
					request.getRequestDispatcher("jsp/success1.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
				}
			}
			if(actionName.equals("addTypeOfService"))
			{
				HttpSession httpSession = request.getSession();
				StatusBean statusBean = (StatusBean)httpSession.getAttribute("user");
				
				long id = statusBean.getCustomerBean().getPkCustomerId();
				String serviceName= request.getParameter("serviceName");
				String serviceDesc= request.getParameter("serviceDesc");
				String serviceImg= request.getParameter("serviceImg");
				
				StatusBean statusBean2 = new  TypeOfJobHelper().saveTypeOfJob(id,serviceName,serviceDesc,serviceImg);
				if(statusBean2.getStatus())
				{
					request.getRequestDispatcher("jsp/success1.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
				}
			}
			if(actionName.equals("addJob"))
			{
				HttpSession httpSession = request.getSession();
				StatusBean statusBean = (StatusBean)httpSession.getAttribute("user");
				
				long id = statusBean.getCustomerBean().getPkCustomerId();
				long TypejobId = Long.parseLong(request.getParameter("TypejobId"));
				String jobName= request.getParameter("jobName");
				int timeRequired= Integer.parseInt( request.getParameter("timeRequired"));
				BigDecimal price = new BigDecimal((String)request.getParameter("price"));
				String jobImage= request.getParameter("jobImage");
				StatusBean bean4 = new JobHelper().saveJob(id,TypejobId,jobName,timeRequired,price,jobImage);
				if(bean4.getStatus())
				{
					request.getRequestDispatcher("jsp/success1.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
				}
			}
			
			HttpSession httpSession =request.getSession(); 
			StatusBean statusBean = (StatusBean)httpSession.getAttribute("user");
			if(statusBean != null)
			{
				if(actionName.equals("submitCarModal"))
				{
				long brandId = Long.valueOf(request.getParameter("brand"));
				long modald = Long.valueOf(request.getParameter("modal"));
				BrandModalBean brandModalBean = new CarModalHelper().getCarBrandModal(brandId,modald);
				 HttpSession session = request.getSession();
				 session.setAttribute("carModal", brandModalBean);
				request.getRequestDispatcher("jsp/TypeOfJobjsp.jsp").forward(request, response);
				
				}
			}
			else
			{
				
				request.getRequestDispatcher("jsp/index.jsp").include(request, response);
			}
			
		
		}
	}

}
