<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>

</head>
  
  <body>
  <jsp:include page="Header.jsp"></jsp:include>
  
                      
                     
  <center>
    <form action="./UpdatePostRecordAction" name="post" method="post">
    <table border="1">
    <tr bgcolor="#FFOOCCFFDD"><i> postelDetails Table</i></tr>
    <tr>
    <br/><br/>
     <tr> 
     
    
    <c:if test="${not empty PostInfo}">
    <c:forEach var="PostInfo" items="${PostInfo}">
    
    
    
<tr>
<td width="128"><span class="style17"><font color="higblue"><b>PostId</b></font> </span></td>
                                <td width="269"><label>
                               
                                    <input type="text" name="postid" value="${PostInfo.postid }" readonly="readonly">
                                     
                                </label></td></tr>
                                <tr>
                                <td width="128"><span class="style17"><font color="higblue"><b>PostItem</b></font> </span></td>
                                <td width="269"><label>
                               
                                    <input type="text" name="pitem" value="${PostInfo.pitem }">
                                     
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>PostType</b></font></span></td>
                                <td><label>
                                 <input type="text" name="ptype" value="${PostInfo.ptype }">
                                </label></td>
                              </tr>
                              
                              <tr>
    <td><pre><span class=Title><font color="higblue"><b> Post Date</b></font></span></pre></td>
    <td>
   <input type="text" name="pdate" value="${PostInfo.pdate }">
  </tr>
                              
                              
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>PostLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="plocation" value="${PostInfo.plocation }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderName </b></font></span></td>
                                <td><label>
                                  <input type="text" name="sname" value="${PostInfo.sname }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderHouseNo </b></font></span></td>
                                <td><label>
                                  <input type="text" name="shouseno" value="${PostInfo.shouseno }">
                                </label></td>
                              </tr>
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="slocation" value="${PostInfo.slocation }">
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderCity</b></font></span></td>
                                <td><label>
                                  <input name="scity" type="text" value="${PostInfo.scity }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderState</b></font></span></td>
                                <td><label>
                                  <input name="sstate" type="text" value="${PostInfo.sstate }" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderCountry</b></font></span></td>
                                <td><label>
                                  <input name="scountry" type="text" id="password" value="${PostInfo.scountry }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderPinCode</b></font></span></td>
                                <td><label>
                                  <input name="spin" type="text" id="password" value="${PostInfo.spin }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverName </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rname"  value="${PostInfo.rname }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverHouseNo </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rhouseno" value="${PostInfo.rhouseno }">
                                </label></td>
                              </tr>
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rlocation" value="${PostInfo.rlocation }">
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverCity</b></font></span></td>
                                <td><label>
                                  <input name="rcity" type="text" value="${PostInfo.rcity }" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverState</b></font></span></td>
                                <td><label>
                                  <input name="rstate" type="text" value="${PostInfo.rstate }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverCountry</b></font></span></td>
                                <td><label>
                                  <input name="rcountry" type="text" value="${PostInfo.rcountry }" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverPinCode</b></font></span></td>
                                <td><label>
                                  <input name="rpin" type="text" id="password" value="${PostInfo.rpin }">
                                </label></td>
                              </tr>
                         </c:forEach>
                         </c:if>
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
    frmvalidator.addValidation("pdate","req","Description is required");
    
     frmvalidator.addValidation("sname","alpha","Sendername is Only Characters");
     frmvalidator.addValidation("sname","req","Sendername is required");
    
     frmvalidator.addValidation("shouseno","req","SenderHNo is required");
     frmvalidator.addValidation("slocation","alpha","SenderLocation is Only Characters");
     frmvalidator.addValidation("slocation","req","SenderLocation is required");
     
     frmvalidator.addValidation("scity","alpha","SenderCity is Only Characters");
     frmvalidator.addValidation("scity","req","SenderCity is required");
   frmvalidator.addValidation("sstate","alpha","SenderState is Only Characters");
     frmvalidator.addValidation("sstate","req","SenderState is required");
     
     frmvalidator.addValidation("spin","req","SenderPin is required");
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

  </script>
    
    </center>
    
    <br/><br/>
               
     <jsp:include page="../jsps/Fotter.jsp"></jsp:include>
    
  </body>
</html>
