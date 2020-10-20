<%@page import="com.CarRepairManagementSystem.helper.VechileBrandHelper"%>
<%@page import="com.CarRepairManagementSystem.helper.CarModalHelper"%>
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
<body>
	<div class="box-area">
	<%@ include file="header.jsp" %>
	<div class="container-fluid">
		<div class="overlap">
			<div class="row-container-fluid">
				<div class="container-fluid-column-left">
					<h1 class="hero-text">Car Care</h1>
					<h1 class="hero-text">Made Easy</h1>
					<h4>ONE STOP SHOP &nbsp; <i class="fa fa-circle" aria-hidden="true"></i>&nbsp; DOORSTEP SERVICE &nbsp;<i class="fa fa-circle" aria-hidden="true"></i>  INSTANT COST ESTIMATE</h4>
				</div>
			<div class="container-fluid-column-right">
				<h3 style="font-size:25px;letter-spacing: 0px;line-height: 32px;font-family: 'San Francisco'"><b>&nbsp;&nbsp;&nbsp;Car Selection</b></h3>
				<form action="<%=request.getContextPath()%>/CarController" method="post">
				<%
				List list = new VechileBrandHelper().getVechicleBrand();
				%>
			<select id="brand" name ="brand" class="form-field" onchange="validate.getModalList()" required>
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
			<input type="hidden" name="<%=request.getContextPath()%>" value="<%=request.getContextPath()%>" id="contextPath">
			<input type="hidden" name="performAction" value="submitModal">	
			
			<div id="container"></div>
			<div id="lblCity" class="errormsg"></div>
			<input type="hidden" name="action" id = "action" value="submitCarModal"> 
			<input type="submit" class="sub" value="Get A QUOTE" onclick="validate.checkLogin()">
			
				</form>
			</div>
			<br style="clear: left;" />
		</div>
	</div>
	<div class="overlap-two" id="brand">
		<div class="overlap-two-left">
			<h2 style="color:white">BRANDS THAT TRUST US</h2>
		</div>
		<div class="overlap-two-right">
		<div class="brand"><img src="<%=request.getContextPath()%>/images/ola.PNG" ></img></div>
		<div class="brand"><img src="<%=request.getContextPath()%>/images/spinny.PNG" ></img></div>
		<div class="brand"><img src="<%=request.getContextPath()%>/images/uber.PNG" ></img></div>
		<div class="brand"><img src="<%=request.getContextPath()%>/images/zoomcar.PNG" ></img></div>
		<br style="clear: left;" />
		</div>
	<br style="clear: left;" />
	</div>
	</div>
	<div><hr></div>
	<div class="carcrew-advantage" id="carcrewAdvantage">
	<h2 style="text-align:left;padding:20px;">CARCREW ADVANTAGE</h2><br>
	<div class="container-advantage">
	<div class="advantage-section">
	<img src="<%=request.getContextPath()%>/images/iconLocation.PNG" ></img>
	<p style="font-size: 13px;font-weight: bold;padding-top:10px">WE MAKE IT EASY</p>
	<p style="padding-top:10px;color:#a4a4a4;">Get a quote and book a service online 24/7. Our mechanics will come to your home or office, even on evenings and weekends</p></div>
	<div class="advantage-section">
	<img src="<%=request.getContextPath()%>/images/iconPrice.PNG" ></img>
	<p style="font-size: 13px;font-weight: bold;padding-top:10px">FAIR AND TRANSPARENT PRICING</p>
	<p style="padding-top:10px;color:#a4a4a4;">We offer fair and transparent pricing and savings up to 40% compared to other workshops.Book with confidence.</p></div>
	<div class="advantage-section">
	<img src="<%=request.getContextPath()%>/images/iconRating.PNG" ></img>
	<p style="font-size: 13px;font-weight: bold;padding-top:10px">HAPPINESS GUARANTEED</p>
	<p style="padding-top:10px;color:#a4a4a4;">We only work with highly rated mechanics.All services are backed by our 2-month / 2,000-km warranty.</p></div>
	<div class="advantage-section">
	<img src="<%=request.getContextPath()%>/images/iconPament.PNG" ></img>
	<p style="font-size: 13px;font-weight: bold;padding-top:10px">MULTIPLE PAYMENT OPTIONS</p>
	<p style="padding-top:10px;color:#a4a4a4;">We offer choice b/w Online, Card or Cash Mode payment of payment is never a problem.</p></div>
	<div class="advantage-section">
	<img src="<%=request.getContextPath()%>/images/iconSpare.PNG" ></img>
	<p style="font-size: 13px;font-weight: bold;padding-top:10px">GENUINE SPARES</p>
	<p style="padding-top:10px;color:#a4a4a4;">All our workshops use genuine OES/OEM parts.Quality is of utmost importance to us</p></div>
	<br style="clear: left;" />
	</div>
	</div>
	<hr>
	<div class="carcrew-advantage" id="testimonial">
	<h2 style="text-align:left;padding:20px;">OUR CUSTOMERS SAY THE NICEST THINGS</h2><br>
	<div class="container-advantage">
	<div class="advantage-section1">
	<img src="<%=request.getContextPath()%>/images/testimonial1.png" ></img>
	<p style="padding-top:10px"><i class="fa fa-quote-left"></i>&nbsp;"Workshop at my doorstep"; </p><p>Amazing experience.</p><p> Highly Recommended</p> <p style="font-size: 20px;font-weight: bold">Prem</p>
	<p>Bajaj Pulsar</p>
	</div>
	<div class="advantage-section1">
	<img src="<%=request.getContextPath()%>/images/testimonial2.png" ></img>
	<p style="padding-top:10px"><i class="fa fa-quote-left"></i>&nbsp;"Great service, great model, fast turnaround time." </p><p style="font-size: 20px;font-weight: bold">Nakul</p>
	<p>Hyundai Verna</p></div>
	<div class="advantage-section1">
	<img src="<%=request.getContextPath()%>/images/testimonial3.png" ></img>
	<p style="padding-top:10px"><i class="fa fa-quote-left"></i>&nbsp;Workshop at my doorstep; </p><p>Amazing experience.</p><p> Highly Recommended <p style="font-size: 20px;font-weight: bold">Nikhil</p>
	<p>Bajaj Pulsar</p></div>
	<br style="clear: left;" />
	</div>
	</div>
	<hr>
	<div class="aboutUs" id="aboutUs">
	<h2 style="text-align:left;padding:20px 20px 0px 20px;">ABOUT US</h2>
	<div style="padding:30px; font-size:15px;color:#a4a4a4">
	<p>Carcrew is India's first standardized network of workshops to provide car services. We provide affordable, transparent and convenient on-demand car services at the comfort of your home or your office. With expert mechanics, state-of-the-art machinery, top quality spares, standardized processes & pricing, Carcrew provides a uniform service experience to all its customers, across its workshops. 
	Everything under one-roof : servicing, repairs, inspections, denting/painting, roadside assistance and car care.</p>
	<br>
	<p>Carcrew provides best online car service in India making car maintenance easy, affordable and completely transparent. We also provide you with the best car service deals. 
		Full car service is faciliated at one of the Carcrew car service centre. So book car service now!</p>
		</div>
	<h2 style="text-align:left;padding:20px 20px 0px 20px;">WE SERVICE ALL MAKES AND MODELS</h2>	
	<div style="padding:20px;text-align: center;">
	<img src="<%=request.getContextPath()%>/images/brands.PNG" ></img>
	</div>
	</div>
	</div>
	<%@ include file="loginRegisterForm.jsp" %>
</body> 
</html>