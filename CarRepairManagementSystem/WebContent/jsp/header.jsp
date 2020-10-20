<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.CarRepairManagementSystem.beans.StatusBean"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<%=request.getContextPath()%>/js/jquery.js" ></script>
<script src="<%=request.getContextPath()%>/js/script.js" ></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>carcrew</title>
<% 
		
%>
</head>
<body>
	<div class="box-area">
	<header>
	
	<div class="logo">
	<a href ="#"><img src="<%=request.getContextPath()%>/images/logo.PNG" ></img></a>
	</div>
	<nav>
	<ul>
	<%
					StatusBean statusBean=(StatusBean)session.getAttribute("user");
					if(statusBean==null)
					{
	%>
					<li><a onclick="validate.showreg()">REGISTER</a><li>
					<li><a  onclick="validate.showlogin()">LOGIN</a><li>
	<%
					}
					else if(statusBean.getCustomerBean().getIsAdmin().equalsIgnoreCase("n"))
					{
				%>
	<li><span style="padding: 10px 10px;">Welcome <%=statusBean.getCustomerBean().getFirstName() %> </span></li>			
	<li><a href = "<%=request.getContextPath()%>/jsp/index.jsp">Home</a><li>
	<li><a href="<%=request.getContextPath()%>/jsp/BookingInfo.jsp" >Booking Info</a></li>
	<li><a href="<%=request.getContextPath()%>/jsp/logout.jsp" >Logout</a></li>
	<%
					}
					else
					{
				%>
				<li><span style="padding: 10px 10px;">Welcome <%=statusBean.getCustomerBean().getFirstName() %> </span></li>
				<li><a href="<%=request.getContextPath()%>/jsp/logout.jsp" >Logout</a></li>
				<%
					}
				%>
	</ul>
	</nav>
	<div class="clr"></div>
	</header>

</body>
</html>