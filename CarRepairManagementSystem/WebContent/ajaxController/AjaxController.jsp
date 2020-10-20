<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.CarRepairManagementSystem.pojo.CarModal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.CarRepairManagementSystem.helper.CarModalHelper"%>
<%@page import="com.CarRepairManagementSystem.helper.CustomerHelper"%>
<%@page import="com.CarRepairManagementSystem.utils.ConfigDB"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.CarRepairManagementSystem.helper.JobHelper"%>
<%@page import="com.CarRepairManagementSystem.beans.JobBean"%>
<%@page import="com.CarRepairManagementSystem.beans.StatusBean"%>
<%@page import="com.CarRepairManagementSystem.beans.BrandModalBean"%>
<%!public String execute(HttpServletRequest request, HttpServletResponse response)
{
	String actionName=request.getParameter("performAction");
	if(actionName !=null && !"".equals(actionName))
	{
		if("modalList".equals(actionName))
		{
			try
			{
			long pkBrandId = Long.parseLong(request.getParameter("brand"));
			List list = new CarModalHelper().getCarModal(pkBrandId);
			return ConfigDB.toJSON(list);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if("addToCart".equals(actionName))
		{
			
			String id = request.getParameter("id");
			List li;
			HttpSession session = request.getSession();
			if(session.getAttribute("cart") == null)
			{
				li= new ArrayList();
				li.add(id);
				session.setAttribute("cart", li);
			}
			else
			{
				li = (List)session.getAttribute("cart");
				if(!li.contains(id))
				{
					li.add(id);
					session.setAttribute("cart", li);
					
				}
			}	
			String size = (String.valueOf(li.size()));
			return size;
			}
		else if("bookJob".equals(actionName))
		{
			try
			{
			String appDate = request.getParameter("Appdate");
			String bookingTime = request.getParameter("bookingTime");
			
			BigDecimal price = new BigDecimal((String)request.getParameter("total"));
			long Totalprice;
			Totalprice = price.longValue();
			HttpSession session = request.getSession();
			BrandModalBean brandModalBean = (BrandModalBean)session.getAttribute("carModal");
			long modalId = brandModalBean.getPkmodalid();
			StatusBean status = (StatusBean) session.getAttribute("user");
			long customerId = status.getCustomerBean().getPkCustomerId();
			
			List list = (List)session.getAttribute("cart");
			StatusBean statusBean = new CustomerHelper().bookJob(Totalprice,modalId,customerId,list,appDate,bookingTime);
			return ConfigDB.toJSON(statusBean.getStatus());
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if("deleteJob".equals(actionName))
		{
			List li = new ArrayList();
			HttpSession session = request.getSession();
			String jobid = request.getParameter("jobid");
			if(session.getAttribute("cart") != null)
			{
				 li = (List)session.getAttribute("cart");
				li.remove(jobid);
			}
			String size = (String.valueOf(li.size()));
			return size;
		}
		
	}
	
	return null;
}
%>
<%= execute(request, response)%>