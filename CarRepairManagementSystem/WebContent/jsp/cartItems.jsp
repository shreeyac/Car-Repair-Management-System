<%@page import="com.CarRepairManagementSystem.beans.StatusBean"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.ListIterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.CarRepairManagementSystem.helper.JobHelper"%>
<%@page import="com.CarRepairManagementSystem.beans.JobBean"%>
 <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<%=request.getContextPath()%>/js/jquery.js" ></script>
<script src="<%=request.getContextPath()%>/js/script.js" ></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>carcrew</title>

</head>

<body>
<div class="typeOfJob-mainContainer">
	<%@ include file="header.jsp" %>
	<%if(session.getAttribute("cart")!= null) 
	{%>
	<div class="jobMainContainer">
	
	<div >
	<table style="margin:auto;background-color: #fff" border="1px solid black">
	<thead>
	<tr>
	<th>Sr No</th>
	<th>Image</th>
	<th>Name</th>
	<th>Cost</th>
	<th>Action</th>
	</tr>
	</thead>
	<%
		if(session.getAttribute("cart")!= null)
		{
			int i =0;
			BigDecimal total =new BigDecimal(0);
			ListIterator list = ((List)session.getAttribute("cart")).listIterator();
			while(list.hasNext())
			{
				i++;
				BigDecimal  id = new BigDecimal((String)list.next());
				System.out.println(id);
				JobBean jobBean = new JobHelper().getJoblist(id);
				total= total.add(jobBean.getPrice());
				%>
				<tr>
				<td><%=i %></td>
				<td><img alt="job image" src="<%=request.getContextPath()%>/images/<%=jobBean.getJobImage() %>  "></td>
				
				<td><%=jobBean.getJobName() %></td>
				<td><%=jobBean.getPrice() %></td>
				 <td><button onclick="validate.deleteJob('<%=jobBean.getPkJobId()%>','<%=request.getContextPath()%>')">Remove</button></td>
				</tr>
				
	
	<% 
				}
	%>
	<tr>
	<td colspan="5"><b>Total :<%=total %>Rs</b></td>
	</tr>
	 <tr>
	<td colspan="5"><form><label style="font-size:15px;font-style: normal;font-weight: bold;">Please select Appointment date</label>  <input type="date" id="selectDate" name="selectDate">&nbsp; 
	<label style="font-size:15px;font-style: normal;font-weight: bold;">Time</label>
	<select id="bookingTime" name="bookingTime">
	<option value="10:00 AM - 2:00 PM">10:00 AM - 2:00 PM </option>
	<option value="2:00 PM - 5:00 PM">2:00 PM - 5:00 PM</option>
	<option value="6:00 PM - 9:00 PM">6:00 PM - 9:00 PM</option>
	</select></form></td>
	</tr>
	
	<tr>
	<td colspan="5" ><button style="background-color: red;color:#fff;padding:10px;" onclick="validate.bookJob('<%=total %>','<%=request.getContextPath()%>')">Get Your Quote</button></td>
	</tr>	
	<%		
			
		}
		%>
</table>

</div>
<%} 
else{%>
<h1>Please Select Your Quote!</h1>
<%} %>
	</div>
</div>
</body>
</html>
