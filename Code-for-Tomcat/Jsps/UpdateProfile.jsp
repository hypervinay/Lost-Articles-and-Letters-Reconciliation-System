
<%@page import="com.post.daoimpl.ProfileDAOImpl"%>
<%@page import="com.post.formbean.Profile"%>

<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>


		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
.Title1 {font-family:Verdana;
font-weight:bold;
font-size:8pt
}
        </style>

<script type="text/javascript">
function onchangeAddress()
{
var form = document.register;
 var selectWidget = document.forms.register.elements["addressType"];
 
 var myValue = selectWidget.options[selectWidget.selectedIndex].value;
 if(myValue=="home")
 {
 document.register.houseNo.value=document.register.homehouseno.value
 document.register.street.value=document.register.homestreet.value
  
 document.register.country.value=document.register.homecountry.value
 document.register.pin.value=document.register.homepin.value
 document.register.state.value=document.register.homestate.value
 document.register.phoneNo.value=document.register.homephoneno.value
 document.register.city.value=document.register.homecity.value
//document.register.fax.value=document.register.homefax.value
return false;
	}
else if(myValue=="office")
{
  document.register.houseNo.value=document.register.officehouseno.value
 document.register.street.value=document.register.officestreet.value
  
 document.register.country.value=document.register.officecountry.value
 document.register.pin.value=document.register.officepin.value
 document.register.state.value=document.register.officestate.value
 document.register.phoneNo.value=document.register.officephoneno.value
 document.register.city.value=document.register.officecity.value
//document.register.fax.value=document.register.officefax.value
 return false;
 }
 else if(myValue=="personal")
{
 document.register.houseNo.value=document.register.personalhouseno.value
 document.register.street.value=document.register.personalstreet.value
 document.register.country.value=document.register.personalcountry.value
 document.register.pin.value=document.register.personalpin.value
 document.register.state.value=document.register.personalstate.value
 document.register.phoneNo.value=document.register.personalphoneno.value
 document.register.city.value=document.register.personalcity.value
//document.register.fax.value=document.register.personalfax.value
 return false;
  
}
return true;
}
</script>
	<body>
	
	
	<jsp:include page="Header.jsp"></jsp:include>
	
	

       <%
String name=(String)session.getAttribute("user");
String path=request.getRealPath("userimages");
		Profile aprofile=new ProfileDAOImpl().getProfile(name,path);

System.out.println(aprofile.getPhoto());


%>
     
      <p>&nbsp;</p>	    <table><tr><td></td></tr></table>
      <p>&nbsp;</p><%if(request.getParameter("status")!=null){ %>
      <%=request.getParameter("status") %><%} %>
      
      <table><tr><td border="1" bgcolor="white">
      <form action="<%=request.getContextPath()+"/updateAction"%>" name="register">
      <center><span class=subHead><h3>Update Profile</h3></span></center>
      <p align="center">
      
       <table width="405" border="0" align="left">
<th colspan=2><span class=Title>1.Personal Details</span></th>
<tr></tr><tr></tr>
  <tr>
    <td align="center"><span class=Title>First Name</span></td>
    <td width="255"><input type="text" name="firstName" value="<%=aprofile.getFirstname()%>" type="text" STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;" size="18" maxlength="30" readonly/></td>
  </tr>
<tr>
     <td align="center"><span class=Title>Last Name</span></td>
    <td width="273"><font size="3" face="Verdana">
      <input type="text" name="lastName" value="<%=aprofile.getLastname()%>" type="text" STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;" size="18" maxlength="30" readonly/>
    </font></td>
  </tr>
  <tr>
    <td align="center"><span class=Title> Birth Date</span></td>
    <td>
   <input type="text" name="dob" value="<%=aprofile.getBdate()%>" type="text" STYLE="color: #FFFFFF; font-family: Verdana; font-weight: bold; font-size: 12px; background-color: tan;" size="18" maxlength="30" readonly/><a href="javascript:show_calendar('document.register.dob', document.register.dob.value);"> 
    </td>
  </tr>
 
  <tr>
    <td align="center"><span class=Title>Browse Photo</span></td>
    <td><input type="file" name="photo" class="textfield" onChange="preview(this)"/></td>
  </tr>
  <tr>
    <td align="center"><span class=Title>Email</span></td>
    <td><input type="text" name="email" value="<%=aprofile.getEmail()%>"/></td>
  </tr>
  <tr>
    <td align="center"><span class=Title> Fax No</span></td>
    <td>
      <input type="text" name="fax" value="<%=aprofile.getFax()%>" size="20"/>
    </td>
  </tr>
<th colspan="2"><span class=Title>2.Contact Details</span></th>
<tr></tr><tr></tr>
<tr>
    <td align="center"><span class=Title> Address Type </span></td>
    <td width="255"><select name="addressType" onChange="onchangeAddress()">
    <option value="select" selected="true"><font size="3" face="Verdana">Select </font></option>
    <option value="home"><font size="3" face="Verdana">Home</font></option>
    <option value="office"><font size="3" face="Verdana">Office</font></option>
    <option value="personal"><font size="3" face="Verdana">Personal</font></option>
      </select></td>
</tr>
<tr>
    <td align="center"><span class=Title> House No</span></td>
    <td><input type="text" name="houseNo" value="" size="20" onChange="showStatus1()"/></td>
</tr>
<tr>
    <td align="center"><span class=Title>Street</span></td>
    <td><input type="text" name="street" value="" size="20" onChange="showStatus1()"/></td>
</tr>
<tr>
    <td align="center"><span class=Title>Phone No</span></td>
    <td>
      <input type="text" name="phoneNo" value="" size="20" onBlur="ValidateForm()"  onchange="abc(),showStatus1()"/>
    
     </td>
</tr>
<tr>
    <td></td>
    <td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="createAccount" class="ygbtem" value="Update"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="cancel" value="Cancel"/></td>
</tr>
</table>
<br/><br><table width="403" border="0" align="center" height="167">
  <tr rowspan="7"></tr>
  <tr></tr><tr></tr>
	  
    <tr colspan="3">
    <td>SeePhoto Here<img alt="See Photo Here" id="previewField" src="<%=path%>\<%=aprofile.getPhoto()%>" height="150" width="120"></td>
  </tr>
  
</table>
<table width="403" border="0" align="center" height="126">
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
  <tr rowspan="2"></tr>
  <tr>
    <td width="120"><span class=Title>City</span></td>
    <td width="273">
      <input type="text" name="city" value="" size="20" onChange="showStatus1()"/>
    </td>
  </tr>
  <tr>
    <td><span class=Title> State</span></td>
    <td>
      <input type="text" name="state" value="" size="20" onChange="showStatus1()"/>
    </td>
  </tr>
  <tr>
    <td><span class=Title> Country</span></td>
    <td>
      <input type="text" name="country" value="" size="20" onChange="showStatus1()"/>
    </td>
  </tr>
  <tr>
    <td><span class=Title> Pin</span></td>
    <td>
      <input type="text" name="pin" value="" size="20" onChange="showStatus1(),showStatus()"/>
    </td>
  </tr>
  
  </table>
  </td></tr></table>
  <input type="hidden" name="homeaddresstype" value="home"/>
<input type="hidden" name="homehouseno" value="<%=aprofile.getHno()%>"/>
<input type="hidden" name="homestreet" value="<%=aprofile.getStreet()%>"/>
<input type="hidden" name="homephoneType" value="home"/>
<input type="hidden" name="homecountry" value="<%=aprofile.getCountry()%>"/>
<input type="hidden" name="homepin" value="<%=aprofile.getPin()%>"/>
<input type="hidden" name="homestate" value="<%=aprofile.getState()%>"/>
<input type="hidden" name="homephoneno" value="<%=aprofile.getPhone()%>"/>
<input type="hidden" name="homecity" value="<%=aprofile.getCity()%>"/>




<input type="hidden" name="officeaddresstype" value="office"/>
<input type="hidden" name="officehouseno" value="<%=aprofile.getOhno()%>"/>
<input type="hidden" name="officestreet" value="<%=aprofile.getOstreet()%>"/>
<input type="hidden" name="officephonetype" value="office"/>
<input type="hidden" name="officecountry" value="<%=aprofile.getOcountry()%>"/>
<input type="hidden" name="officepin" value="<%=aprofile.getOpin()%>"/>
<input type="hidden" name="officestate" value="<%=aprofile.getOstate()%>"/>
<input type="hidden" name="officephoneno" value="<%=aprofile.getOphone()%>"/>
<input type="hidden" name="officecity" value="<%=aprofile.getOcity()%>"/>



<input type="hidden" name="personaladdresstype" value="personal"/>
<input type="hidden" name="personalhouseno" value="<%=aprofile.getChno() %>"/>
<input type="hidden" name="personalstreet" value="<%=aprofile.getCstreet() %>"/>
<input type="hidden" name="personalphonetype" value="mobile"/>
<input type="hidden" name="personalcountry" value="<%=aprofile.getCcountry() %>"/>
<input type="hidden" name="personalpin" value="<%=aprofile.getCpin() %>"/>
<input type="hidden" name="personalstate" value="<%=aprofile.getCstate() %>"/>
<input type="hidden" name="personalphoneno" value="<%=aprofile.getCphone() %>"/>
<input type="hidden" name="personalcity" value="<%=aprofile.getCcity() %>"/>


  


  <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
 
  frmvalidator.addValidation("firstName","req","Please enter your First Name");
  frmvalidator.addValidation("firstName","maxlen=20",	"Max length for FirstName is 20");
  frmvalidator.addValidation("firstName","alpha"," First Name Alphabetic chars only");
  
  frmvalidator.addValidation("lastName","req","Please enter your Last Name");
  frmvalidator.addValidation("lastName","maxlen=20","Max length is 20");
  frmvalidator.addValidation("lastName","alpha"," Last Name Alphabetic chars only");
  
  
   frmvalidator.addValidation("dob","req","Please enter your DOB"); 
  
   frmvalidator.addValidation("photo","req","Please Load Your Photo"); 
  
  frmvalidator.addValidation("email","maxlen=50");
  frmvalidator.addValidation("email","req");
  frmvalidator.addValidation("email","email");
   
  
   frmvalidator.addValidation("addressType","dontselect=0");
   
   frmvalidator.addValidation("houseNo","req","Please enter your House Number");
   
   frmvalidator.addValidation("street","req","Please enter your Street Number");
     
   frmvalidator.addValidation("phoneNo","req");
  
  frmvalidator.addValidation("phoneNo","maxlen=50");
  frmvalidator.addValidation("phoneNo","numeric");
 frmvalidator.addValidation("phoneNo","Phone");
   
   frmvalidator.addValidation("city","req","Please enter your city Name");
   frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("country","req","Please enter your Country Name");
   frmvalidator.addValidation("pin","req","Please enter your pin Number");
   
   frmvalidator.addValidation("fax","req","Please enter Fax Number");
  
   frmvalidator.addValidation("fax","age");
    
 </script>
 <br/><br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
