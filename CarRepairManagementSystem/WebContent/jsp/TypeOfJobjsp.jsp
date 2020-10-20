<%@page import="com.CarRepairManagementSystem.beans.BrandModalBean"%>
<%@page import="com.CarRepairManagementSystem.beans.TypeofjobBean"%>
<%@page import="com.CarRepairManagementSystem.helper.TypeOfJobHelper"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
BrandModalBean brandModalBean = (BrandModalBean)session.getAttribute("carModal");
%>
<body>
<div class="typeOfJob-mainContainer">
	<%@ include file="header.jsp" %>
	<div class="typeOfJob">
	<h3 style ="text-align: center;"><%=brandModalBean.getBrandName() %> <%=brandModalBean.getModalName() %></h3>
			<%
				List list = new TypeOfJobHelper().getTypeOfJob();
			
			for(int i = 0; i < list.size(); i++)
			{
				TypeofjobBean typeofjobBean = (TypeofjobBean)list.get(i);
			%>
			<a href='jsp/JobDetail.jsp?id=<%=typeofjobBean.getPkTypeOfJobId()%>' class='styleAnchor'  >
			<div class="service">
			<div class="service-image">
			<img src="<%=request.getContextPath()%>/images/<%= typeofjobBean.getImgSrc() %> "></img>
			</div>
			<h4 style="text-align:center;"><%= typeofjobBean.getTypeOfJobName()%></h4>
			<p style="text-align:center;padding:10px;color:#a1a1a1;"><%=typeofjobBean.getDescription() %></p>
			<input type="hidden" id="typeOfJobId" name="typeOfJobId" value ="<%=typeofjobBean.getPkTypeOfJobId()%>">
			</div>
			</a>
			<% 
			}
			%>
	</div>
	
	</div>

</body>
</html>