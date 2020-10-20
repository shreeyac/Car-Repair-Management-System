<div id="modal_start" class="modal_start" onclick="validate.hide()"></div>
	<div id="reg_div" class="show_div">
		<form id="reg" action="<%=request.getContextPath()%>/CarController" onsubmit="return validate.checkRegister()" method="post" > 
			<h1 class="regEmployee">Registration</h1>
			<label>First Name:</label><br>
			<input type="text"  name="fname" id="fname" placeholder="First Name" autocomplete="off"  maxlength="20" onkeypress="return validate.lettersOnly(event)" onblur="validate.checker(this.id,'lblFirstName')" oninput="this.value = this.value.replace(/[^a-z, ]/g, '').replace(/(\..*)\./g, '$1');"  ><br>
			<div id="lblFirstName" class="errormsg"></div>
			<label>Last Name:</label><br>
			<input  type="text"   name="lname" id="lname" placeholder="Last Name"  autocomplete="off" maxlength="20" onkeypress="return validate.lettersOnly(event)" onblur="validate.checker(this.id,'lblLastName')" oninput="this.value = this.value.replace(/[^a-z, ]/g, '').replace(/(\..*)\./g, '$1');"><br>
			<div id="lblLastName" class="errormsg"></div>
			
			<label>Email:</label><br>
			<input type="text"  name="email" id="email" placeholder="eg john@gmail.com"  autocomplete="off" maxlength="30"  onblur="validate.checker(this.id,'lblemail'); validate.checkemailPresent()"><br>
			<div id="lblemail" class="errormsg"></div>
			
			<label>Mobile No:</label><br>
			<input type="text"   name="mobileno" id="mobileno" placeholder="Mobile No" autocomplete="off" maxlength="10"   oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" onblur="validate.checker(this.id,'lblMobileNo')"><br>
			<div id="lblMobileNo" class="errormsg"></div>
			
			
			<label>Select City:</label><br>
			<select id="city" name ="city" onblur="validate.checker(this.id,'lblCity')">
			<option  value="">Please select a City</option>
			<option value="Mumbai">Mumbai</option>
			<option value="Thane">Thane</option>
			<option value="Pune">Pune</option>
			<option value="Nagpur">Nagpur</option>
			<option value="Satara">Satara</option>
			</select><br>
			<div id="lblCity" class="errormsg"></div>
			
			<label>Address:</label><br>
			<textarea   id="address" name="address" onblur="validate.checker(this.id,'lblAddress')"></textarea><br>
			<div id="lblAddress" class="errormsg"></div>
			
			<label>Password:</label><br>
			<input type="password"  name="pass" id="pass" placeholder="Password" autocomplete="off" maxlength="20" onblur="validate.checker(this.id,'lblPass');validate.checkpasswordPresent()" ><br>
			<div id="lblPass" class="errormsg"></div>
			<label>Confirm Password:</label><br>
			<input type="password"   name="confirmpass" id="confirmpass"  autocomplete="off" placeholder="Confirm Password" maxlength="20"  onblur="validate.checker(this.id,'lblConfirmPass')"><br>
			<div id="lblConfirmPass" class="errormsg"></div>
			<input type="hidden" name="action" id = "action" value="registerSubmit"> 
			<input type="hidden" name="<%=request.getContextPath()%>" value="<%=request.getContextPath()%>" id="contextPath">
			
		 <input type="submit" id="sub" value="Submit" onclick="return validate.checkRegister()">
			<input type="reset" id="reset" value="Reset">
		</form>
	</div>	
	
		<div id ="log_div" class="show_div">
		<form id="login" action="<%=request.getContextPath()%>/CarController" onsubmit="return validate.checkLogin();" method="post" >
			<h1 class="regEmployee">Login</h1>
			<label>Email:</label><br>
			<input type="text"  name="login_email" id="login_email" placeholder="eg john@gmail.com"  autocomplete="off" maxlength="30"  onblur="validate.checker(this.id,'lblLogin_email')" ><br>
			<div id="lblLogin_email" class="errormsg"></div>
			<label>Password:</label><br>
			<input type="password"  name="login_pass" id="login_pass" placeholder="Password" autocomplete="off" maxlength="20" onblur="validate.checker(this.id,'lblLogin_Pass')"><br>
			<div id="lblLogin_Pass" class="errormsg"></div>
			<input type="hidden" name="action" id = "action" value="loginSubmit"> 
			<input type="submit" id="sub" value="Login" >
			<input type="reset" id="reset" value="Reset">
			</form>
	
		
		
	</div>
	