<%@page import="com.CarRepairManagementSystem.dao.BookingItemDao"%>
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
<%
StatusBean bean=(StatusBean)session.getAttribute("user");
long userId = bean.getCustomerBean().getPkCustomerId();
%>
<body>
<div class="typeOfJob-mainContainer">
	<%@ include file="header.jsp" %>
	<%
		List list = new BookingItemDao().getBookings(userId);
	%>
	
				
			<table style="margin:auto;background-color: #fff" border="1px solid black">
	<thead>
	<tr>
	<th>Date</th>
	<th>Time</th>
	<th>Service</th>
	<th>Price</th>
	
	</tr>
	</thead>
		<%
					for(int i=0; i < list.size(); i++)
					{
						Object[] obj = (Object[])list.get(i);
				%>
						<tr><td><%=obj[0].toString()%></td><td> <%=obj[1].toString()%></td>
						<td><%=obj[2].toString()%></td><td> <%=obj[3].toString()%></td>
						 </tr>	
				<%
					}
				%>
</table>	
</div>
</body>
</html>