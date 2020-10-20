<%@page import="com.CarRepairManagementSystem.helper.TypeOfJobHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.CarRepairManagementSystem.helper.VechileBrandHelper"%>
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
<%response.setHeader("Cache-Control", "no-cache,no-store,must-validate"); %>
</head>

<body>
<div class="typeOfJob-mainContainer">
	<header>
	
	<div class="logo">
	<a href ="#"><img src="<%=request.getContextPath()%>/images/logo.PNG" ></img></a>
	</div>
	<nav>
	<ul>
	<li><a href = "<%=request.getContextPath()%>/jsp/index.jsp">Home</a><li>
	<li><a href="<%=request.getContextPath()%>/jsp/logout.jsp" >Logout</a></li>
	</ul>
	</nav>
	<div class="clr"></div>
	</header>
	<div style="width:400px;margin:auto;">
	<div style="padding:20px;border:1px solid black">
	<form action="<%=request.getContextPath()%>/CarController">
	<center><h1>Add Brand</h1></center>
	<label>Brand  Name:</label>
	<input type="text" name ="brandName" id= "brandName">
	<input type="hidden" name="action" id = "action" value="addBrand"> 
	<br>
	<center><input type="submit" value="Submit"></center>
	</form>
	</div>
	<br>
	<div style="padding:20px;border:1px solid black">
	<form action="<%=request.getContextPath()%>/CarController" method="post">
	<center><h1>Add Modal</h1></center>
	<label>Select Brand  Name:</label>
	<%
				List list = new VechileBrandHelper().getVechicleBrand();
	%>
	<select id="brandId" name="brandId">
	<%
					for(int i=0; i < list.size(); i++)
					{
						Object[] obj = (Object[])list.get(i);
				%>
						<option value="<%=obj[0].toString()%>"><%=obj[1].toString()%></option>	
				<%
					}
				%>
				</select>
				<br>
	<label>Modal  Name:</label>
	<input type="text" id="modalName" name="modalName">
	<br>
	<input type="hidden" name="action" id = "action" value="addModal"> 
	<center><input type="submit" value="Submit"></center>
	<br>
	</form >
	</div>
	<br>
	<div style="padding:20px;border:1px solid black">
	<form action="<%=request.getContextPath()%>/CarController" method="post">
	<center><h1>Add Service</h1></center>
	<label>Service Name</label>
	<input type="text" name="serviceName" id="serviceName"><br>
	<label>Service Description</label>
	<input type="text" name="serviceDesc" id="serviceDesc"><br>
	<label>Service image</label>
	<input type="text" name="serviceImg" id="serviceImg"><br>
	
	<input type="hidden" name="action" id = "action" value="addTypeOfService"> 
	<center><input type="submit" value="Submit"></center><br>
	</form>
	</div>
	<br>
	<div style="padding:20px;border:1px solid black">
	<form action="<%=request.getContextPath()%>/CarController" method="post">
	<center><h1>Add Job</h1></center>
	<label>Select Service</label>
	<%
				List list3 = new TypeOfJobHelper().getTypeOfJobList();
	%>
	<select id="TypejobId" name="TypejobId">
	<%
					for(int i=0; i < list3.size(); i++)
					{
						Object[] obj = (Object[])list3.get(i);
				%>
						<option value="<%=obj[0].toString()%>"><%=obj[1].toString()%></option>	
				<%
					}
				%>
				</select><br>
	<label>Job Name</label>
	<input type="text" name="jobName" id="jobName"><br>
	<label>Time Required</label>
	<input type="text" name="timeRequired" id="timeRequired"><br>
	<label>Price</label>
	<input type="text" name="price" id="price"><br>
	<label>jobImage</label>
	<input type="text" name="jobImage" id="jobImage"><br>
	<input type="hidden" name="action" id = "action" value="addJob"> 
	<center><input type="submit" value="Submit"><br></center>
	
	</form>
	</div>
	</div>
	</div>
</body>
</html>