<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()+"/js/ts_picker.js"%>"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="<%=request.getContextPath()+"/js/image.js"%>"> </script>
 <script type="text/javascript" src="<%=request.getContextPath()+"/js/general.js"%>"> </script>
 <script type="text/javascript" src="<%=request.getContextPath()+"/js/adi.js"%>"> </script>
 <script type="text/javascript" src="<%=request.getContextPath()+"/js/form_validation.js"%>"> </script>

		<script language="JavaScript" src="<%=request.getContextPath()+"/images/javascripts.js" %>"></script>
		<script language="JavaScript" src="<%=request.getContextPath()+"/images/pop-closeup.js"%>"></script>
</head>
 <script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>
<script>

//var x_win = window.self; 

function goOn() {
var port=document.register.port.value;
var host=document.register.host.value;
var userName=document.register.userName.value;
window.location.href='http://'+host+':'+port+'/Template/ChekUserAction?userName='+userName;

} 
</script>
  
  <body>
  <jsp:include page="Header.jsp"></jsp:include>
  
  
  <center>
    <form action="<%=request.getContextPath()+"/AddPostDetailsAction"%>"  name="post" method="post">
    <table border="1">
    <tr bgcolor="#FFOOCCFFDD"><i> postelDetails Table</i></tr>
    <tr>
    <br/>
     <tr>
                                <td width="128"><span class="style17"><font color="higblue"><b>PostItem</b></font> </span></td>
                                <td width="269"><label>
                               <select name="pitem">
                             <option>--SELECT--</option>
                                <option value="letter">Letter</option>
                                     <option value="parcel">Parcel</option>
                                    <option value="card">Card</option>
                                    
                                     </select>
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>PostType</b></font></span></td>
                                <td><label>
                                  <select name="ptype">
                             <option>--SELECT--</option>
                                <option value="ordinary">Ordinary</option>
                                     <option value="speedpost">SpeedPOst</option>
                                    <option value="registerpost">RegisterPost</option>
                                    
                                     </select>
                                </label></td>
                              </tr>
                              
                              <tr>
    <td><pre><span class=Title><font color="higblue"><b> Post Date</b></font></span></pre></td>
    <td>
   <input type="text" name="pdate" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.post.pdate', document.post.pdate.value);"> <img src="<%=request.getContextPath()+"/images/cal.gif"%>" alt="a" width="18" height="18" border="0"/></a>    </td>
  </tr>
                              
                              
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>PostLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="plocation">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderName </b></font></span></td>
                                <td><label>
                                  <input type="text" name="sname">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderHouseNo </b></font></span></td>
                                <td><label>
                                  <input type="text" name="shouseno">
                                </label></td>
                              </tr>
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="slocation">
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderCity</b></font></span></td>
                                <td><label>
                                  <input name="scity" type="text" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderState</b></font></span></td>
                                <td><label>
                                  <input name="sstate" type="text" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderCountry</b></font></span></td>
                                <td><label>
                                  <input name="scountry" type="text" id="password">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderPinCode</b></font></span></td>
                                <td><label>
                                  <input name="spin" type="text" id="password">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverName </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rname">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverHouseNo </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rhouseno">
                                </label></td>
                              </tr>
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rlocation">
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverCity</b></font></span></td>
                                <td><label>
                                  <input name="rcity" type="text" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverState</b></font></span></td>
                                <td><label>
                                  <input name="rstate" type="text" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverCountry</b></font></span></td>
                                <td><label>
                                  <input name="rcountry" type="text" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverPinCode</b></font></span></td>
                                <td><label>
                                  <input name="rpin" type="text" id="password">
                                </label></td>
                              </tr>
                              
                             <tr>
                             <td align="right">
                             <input type="submit" name="submit" value="SUBMIT">
                              </td></tr>
    
    
    
    
    
    </table>
    
    </form>
    
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("post");

  frmvalidator.addValidation("pitem","req","PostItem is required");
  frmvalidator.addValidation("ptype","req","PostType is required");
    frmvalidator.addValidation("plocation","alpha","plocation is Only Characters");
     frmvalidator.addValidation("plocation","req","plocation is required");
    frmvalidator.addValidation("pdate","req","Date  is required");
    
     frmvalidator.addValidation("sname","alpha","Sendername is Only Characters");
     frmvalidator.addValidation("sname","req","Sendername is required");
    
     frmvalidator.addValidation("shouseno","req","SenderHNo is required");
     frmvalidator.addValidation("slocation","alpha","SenderLocation is Only Characters");
     frmvalidator.addValidation("slocation","req","SenderLocation is required");
     
     frmvalidator.addValidation("scity","alpha","SenderCity is Only Characters");
     frmvalidator.addValidation("scity","req","SenderCity is required");
   frmvalidator.addValidation("sstate","alpha","SenderState is Only Characters");
     frmvalidator.addValidation("sstate","req","SenderState is required");
     frmvalidator.addValidation("scountry","alpha","SenderCountry is Only Characters");
     frmvalidator.addValidation("scountry","req","SenderCountry is required");
     
     frmvalidator.addValidation("spin","req","SenderPin is required");
      frmvalidator.addValidation("spin","numeric");
     frmvalidator.addValidation("rname","alpha","ReceiverName is Only Characters");
     frmvalidator.addValidation("rname","req","ReceiverName is required");
     frmvalidator.addValidation("rhouseno","req","ReceverHno is required");
     
   frmvalidator.addValidation("rlocation","alpha","Receiverlocation is Only Characters");
     frmvalidator.addValidation("rlocation","req","Receiverlocation is required");
     frmvalidator.addValidation("rcity","alpha","ReceiverCity is Only Characters");
     frmvalidator.addValidation("rcity","req","ReceiverCity is required");
     
     frmvalidator.addValidation("rstate","alpha","ReceiverState is Only Characters");
     frmvalidator.addValidation("rstate","req","ReceiverState is required");
     frmvalidator.addValidation("rcountry","alpha","ReceiverCountry is Only Characters");
     frmvalidator.addValidation("rcountry","req","ReceiverCountry is required");
       frmvalidator.addValidation("rpin","req","ReceverPin is required");
        frmvalidator.addValidation("rpin","numeric");

  </script>
    
    </center>
    
                  <jsp:include page="Footer.jsp"></jsp:include> 
    
    
  </body>
</html>
