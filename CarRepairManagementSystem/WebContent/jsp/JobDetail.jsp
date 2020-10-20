<%@page import="java.util.ListIterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.CarRepairManagementSystem.beans.JobBean"%>
<%@page import="com.CarRepairManagementSystem.beans.BrandModalBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.CarRepairManagementSystem.helper.JobHelper"%>
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
<%

String contextPath = request.getContextPath();
BigDecimal jobId = new BigDecimal(request.getParameter("id")); 
BrandModalBean brandModalBean = (BrandModalBean)session.getAttribute("carModal");
%>
<body>
<div class="typeOfJob-mainContainer">
	<%@ include file="header.jsp" %>
	<div class="jobMainContainer">
	<h3 style ="text-align: center;"><%=brandModalBean.getBrandName() %> <%=brandModalBean.getModalName() %></h3>
		
	<div class="leftSection">
	<%
				List list = new JobHelper().getJob(jobId);
			
			for(int i = 0; i < list.size(); i++)
			{
				JobBean jobBean = (JobBean)list.get(i);
				
	%>
	
	<div class ="jobDesc">
	<div class="jobImage">
	<img alt="job image" src="<%=request.getContextPath()%>/images/<%=jobBean.getJobImage() %>  ">
	</div>
	<div class="jobName">
	<h6><%=jobBean.getJobName() %></h6>
	</div>
	<div class="jobPrice">
	<h6>CC Price :Rs <%=jobBean.getPrice() %></h6>
	</div>
	<div class="jobBook">
	<button class="bookButton" onclick="validate.addToCart('<%=jobBean.getPkJobId()%>','<%=contextPath%>')">BOOK</button></div>
	<br style="clear: left;" />
	</div>
	<%} %>
	</div>
	
	<div class="stikyItem" onclick="window.location.href='<%=request.getContextPath()%>/jsp/cartItems.jsp'">
	<%if(session.getAttribute("cart")!=null)
		{
			out.print(((List)session.getAttribute("cart")).size()+" Items");
		}%></div>
	<br style="clear: left;" />
	
	
	
	
	</div>
	</div>

</body>
</html>