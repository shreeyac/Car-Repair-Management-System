<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<%=request.getContextPath()%>/js/jquery.js" ></script>
<script src="<%=request.getContextPath()%>/js/script.js" ></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<title>carcrew</title>
</head>
<body>
<div class="box-area">
	<header>
	
	<div class="logo">
	<a href ="#"><img src="<%=request.getContextPath()%>/images/logo.PNG" ></img></a>
	</div>
	<nav>
	<ul>
	
	<li><a onclick="validate.showreg()">REGISTER</a><li>
	<li><a  onclick="validate.showlogin()">LOGIN</a><li>
	</ul>
	</nav>
	<div class="clr"></div>
	</header>
<p>Please login!</p>	
<%@ include file="loginRegisterForm.jsp" %>
	</div>
</body>
</html>