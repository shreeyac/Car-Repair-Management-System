var validate = new validation();

function validation()
{
	this.getModalList=getModalList;
	this.addToCart=addToCart;
	this.checkLogin=checkLogin;
	this.showreg=showreg;
	this.showlogin=showlogin;
	this.hide=hide;
	this.checker=checker;
	this.regex=regex;
	this.checkEmptyRegister=checkEmptyRegister;
	this.nameReg=nameReg;
	this.emailRegex=emailRegex;
	this.mobileReg=mobileReg;
	this.alphanumericReg=alphanumericReg;
	this.addressReg=addressReg;
	this.passwordReg=passwordReg;
	this.confirmPasswordValidate=confirmPasswordValidate;
	this.lettersOnly=lettersOnly;
	this.letters_space=letters_space;
	this.checkRegister=checkRegister;
	this.checkLogin=checkLogin;
	this.bookJob=bookJob;
	this.deleteJob=deleteJob;
	
	function showreg()
	 {
		 $("#modal_start").show();
		 $("#reg_div").show();
	}
	function showlogin()
	{
		$("#modal_start").show();
		$("#log_div").show();
	}
	function hide()
	{
		$("#modal_start").hide();
		$(".show_div").hide();
	}
	
	function getModalList()
	{
		var brand = $('#brand').val();
		var contextPath = $('#contextPath').val();
		$.post(contextPath+"/ajaxController/AjaxController.jsp",
			    {performAction:"modalList",brand:brand},
			    function(data)
			    {
			    	//alert(data);
			    	var parseData = JSON.parse(data);
			    	
			    	var html="<select id='modal' name='modal' class='form-field' required > <option value=''>Select Model</option>";
					for(var i=0;i<parseData.length;i++)
					{
						html+="<option value='"+parseData[i][0]+"'>"+parseData[i][1]+"</option>";
					}
					html+="</select>";
					$("#container").html(html);
			    });
			 
	}
	function addToCart(id,contextPath)
	{
		
		$.post(contextPath+"/ajaxController/AjaxController.jsp",
			    {performAction:"addToCart",id:id},
			    function(data)
			    {
			    	$(".stikyItem").text(data+" Items");
			    
			    });
		
	}
	
	function bookJob(total,contextPath)
	{
		var Appdate = $('#selectDate').val();
		var bookingTime = $('#bookingTime').val();
		$.post(contextPath+"/ajaxController/AjaxController.jsp",
			    {performAction:"bookJob",total:total,Appdate:Appdate,bookingTime:bookingTime},
			    function(data)
			    {
			    	
			    	var parseData = $.trim(data);
			    	
			    	if(parseData=="true")
			    	{
			    		window.location.href = 'success.jsp';
			    	}
			    	else if(parseData=="false")
			        {
			        	window.location.href = 'error.jsp' ;
			        }
			    	
			    
			    });
		
		
	}
	
	function deleteJob(jobid,contextPath)
	{
		$.post(contextPath+"/ajaxController/AjaxController.jsp",
			    {performAction:"deleteJob",jobid:jobid},
			    function(data)
			    {
			    	
			    	var parseData = $.trim(data);
			    	
			    	
			    	if(parseData >= "0")
			    	{
			    		location.reload();
			    	}
			    
			    });
		
		
	}
	function checkLogin(contextPath)
	{
		
		$.post(contextPath+"/ajaxController/AjaxController.jsp",
			    {performAction:"checkLogin"},
			    function(data)
			    {
			    	
			    
			    });
		
	}
	
	function checker(obj,msgLabel)
	{
		checkEmptyRegister(obj,msgLabel);
		regex(obj,msgLabel);
	}
	function regex(obj,msgLabel)
	{
		if(msgLabel == 'lblFirstName' || msgLabel == 'lblLastName')
		{nameReg(obj,msgLabel);
		}
		else if(msgLabel == 'lblemail')
		{
			emailRegex(obj,msgLabel);
		}
		else if(msgLabel == 'lblDob')
		{
			ValidateDOB(obj,msgLabel);
		}
		else if(msgLabel == 'lblPass')
		{
			passwordReg(obj,msgLabel);
		}
		else if(msgLabel=='lblMobileNo')
		{
			mobileReg(obj,msgLabel);
		}
		else if(msgLabel == 'lblAddress')
		{
			addressReg(obj,msgLabel);
		}
		else if(msgLabel == 'lblBookName')
		{
			alphanumericReg(obj,msgLabel);
		}
		
		
	}
	
	function checkEmptyRegister(obj,msgLabel)
	{
		var empty = document.getElementById(obj).value;
		if(empty === null || empty == '' )
		{
			document.getElementById(msgLabel).innerText ="* this field is required";
			return false;
		}
			else
		{
			document.getElementById(msgLabel).innerText = "";
			return true; 
		}
	}
	
	function nameReg(obj,msgLabel)
	{
		var letters = /^([A-z])+$/;
		
		if(letters.test(obj.value))
		{
			document.getElementById(msgLabel).innerText += "";
			return true;
		}
		else
		{
			document.getElementById(msgLabel).innerText ='*Username must have alphabet characters only';
			return false;
		} 
		
	}
	
	function emailRegex(obj,msgLabel)
	{
		var email_val =  document.getElementById(obj).value;
		var emailReg = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		if(emailReg.test(email_val))
		{
			document.getElementById(msgLabel).innerText += "";
			return true;
		}
		else
		{
			document.getElementById(msgLabel).innerText ='*Email not valid';
			return false;
		} 
		
	}
	
	
	
	
	
	function mobileReg(obj,msgLabel)
	{
		var mobilereg = /[7-9][1-9]{9}/;
		var mobile = document.getElementById(obj).value;
		var lblError = document.getElementById(msgLabel);
		if(mobilereg.test(mobile))
		{
			lblError.innerHTML = "";
			return true;
		}
		else
		{
			lblError.innerHTML ='*Invalid mobile no';
			return false;
		}
				
	}
			
	function alphanumericReg(obj,msgLabel)
	{	
		var alphanumericReg = /^[0-9a-zA-Z]+$/;
		var bname = document.getElementById(obj).value;
		var lblError = document.getElementById(msgLabel);
		if(alphanumericReg.test(bname))
		{
			lblError.innerHTML = "";
			return true;
		}
		else
		{
			lblError.innerHTML ='*Invalid allowed letters and no only';
			return false;
		}
				
	}
			
	function addressReg(obj,msgLabel)
	{
		var addressReg = /^[0-9a-zA-Z]+$/;
		var address = document.getElementById(obj).value;
		var lblError = document.getElementById(msgLabel);
		if(addressReg.test(address))
		{
			lblError.innerHTML = "";
			return true;
		}
		else
		{
			lblError.innerHTML ='*User address must have alphanumeric characters only';
			return false;
		}
	}
			
	function passwordReg(obj,msgLabel)
	{
		var reg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
		var pass = document.getElementById(obj).value;
		var lblError = document.getElementById(msgLabel);
		if(reg.test(pass))
		{
			lblError.innerHTML ="";
			return true;
		}
		else
		{
			lblError.innerHTML ='* password invalid please try again';
			return false;
		}
	}
			
	function confirmPasswordValidate()
	{
		var pass =  document.getElementById('pass').value;
		var confirmpass= document.getElementById('confirmpass').value;
		if(pass != confirmpass) 
		{
			document.getElementById('lblConfirmPass').innerHTML="*Passwords do not match.";
			return false;
		}
		else
		{
			document.getElementById('lblConfirmPass').innerHTML="";
			return true;
		}
	}
			
	function lettersOnly() 
	{
        var charCode = event.keyCode;

        if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) || charCode == 8)

            return true;
        else
            return false;
	}
			
	function letters_space() 
	{
        var charCode = event.keyCode;

        if(!(charCode >= 65 && charCode <= 120) && (charCode != 32 && charCode != 0))

			return false;
        else
            return true;
	}
			
	function checkRegister()
	{
		var fname = document.getElementById('fname').value;
		var lname = document.getElementById('lname').value;
		var email = document.getElementById('email').value;
		var mobileno = document.getElementById('mobileno').value;
		var city = document.getElementById('city').value;
		var address = document.getElementById('address').value;
		var pass = document.getElementById('pass').value;
				
		if(checkEmptyRegister('fname','lblFirstName') && nameReg('fname','lblFirstName'))
		{
			 if(checkEmptyRegister('lname','lblLastName') && nameReg('lname','lblLastName'))
		{
			 if(checkEmptyRegister('email','lblemail') && emailRegex('email','lblemail'))
			{
			 if(checkEmptyRegister('mobileno','lblMobileNo') && mobileReg('mobileno','lblMobileNo'))
			{
			 if(checkEmptyRegister('city','lblCity') )
			{
			 if(checkEmptyRegister('address','lblAddress') && addressReg('address','lblAddress'))
			{
			 if(checkEmptyRegister('pass','lblPass') && passwordReg('pass','lblPass'))
			{	
			 if(checkEmptyRegister('confirmpass','lblConfirmPass') &&  confirmPasswordValidate())
			{	
											return true;
				
			}
			}
			}
			}
						
			}
			}
			}
		}
	}
			
	function checkLogin()
	{
		var email=document.getElementById("login_email").value;
		var pass = document.getElementById("login_pass").value;
		if(checkEmptyRegister('login_email','lblLogin_email') && emailRegex('login_email','lblLogin_email'))
		{
			if(checkEmptyRegister('login_pass','lblLogin_Pass') && passwordReg('login_pass','lblLogin_Pass'))
			{
				return true;
			}	
		}
			
	}
			
}