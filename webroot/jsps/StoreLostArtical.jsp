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
    <form action="./AddLostArticalAction" name="post" method="post">
    <table border="1">
    <tr bgcolor="#FFOOCCFFDD"><i> LostArticel Info</i></tr>
    <tr>
    <br/><br/>
     <tr> 
     
     
     <c:if test="${not empty LostPost}">
     <c:forEach var="LostPost" items="${LostPost}">
     
     
<tr>
<td width="128"><span class="style17"><font color="higblue"><b>PostId</b></font> </span></td>
                                <td width="269"><label>
                               
                                 <input type="text" name="postid" value="${LostPost.postid }">
                                     
                                </label></td></tr>
                                <tr>
                                <td width="128"><span class="style17"><font color="higblue"><b>PostItem</b></font> </span></td>
                                <td width="269"><label>
                               
                                    <input type="text" name="pitem" value="${LostPost.pitem}">
                                     
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>PostType</b></font></span></td>
                                <td><label>
                                 <input type="text" name="ptype" value="${LostPost.ptype }">
                                </label></td>
                              </tr>
                              
                              <tr>
    <td><pre><span class=Title><font color="higblue"><b> Post Date</b></font></span></pre></td>
    <td>
   <input type="text" name="pdate" value="${LostPost.pdate }">
  </tr>
                              
                              
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>PostLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="plocation" value="${LostPost.plocation }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderName </b></font></span></td>
                                <td><label>
                                  <input type="text" name="sname" value="${LostPost.sname }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderHouseNo </b></font></span></td>
                                <td><label>
                                  <input type="text" name="shouseno" value="${LostPost.shouseno }">
                                </label></td>
                              </tr>
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="slocation" value="${LostPost.slocation }">
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderCity</b></font></span></td>
                                <td><label>
                                  <input name="scity" type="text" value="${LostPost.scity }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderState</b></font></span></td>
                                <td><label>
                                  <input name="sstate" type="text" value="${LostPost.sstate }" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderCountry</b></font></span></td>
                                <td><label>
                                  <input name="scountry" type="text" id="password" value="${LostPost.scountry }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>SenderPinCode</b></font></span></td>
                                <td><label>
                                  <input name="spin" type="text" id="password" value="${LostPost.spin }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverName </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rname"  value="${LostPost.rname }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverHouseNo </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rhouseno" value="${LostPost.rhouseno }">
                                </label></td>
                              </tr>
                               <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverLocation </b></font></span></td>
                                <td><label>
                                  <input type="text" name="rlocation" value="${LostPost.rlocation }">
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverCity</b></font></span></td>
                                <td><label>
                                  <input name="rcity" type="text" value="${LostPost.rcity }" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverState</b></font></span></td>
                                <td><label>
                                  <input name="rstate" type="text" value="${LostPost.rstate }">
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverCountry</b></font></span></td>
                                <td><label>
                                  <input name="rcountry" type="text" value="${LostPost.rcountry }" >
                                </label></td>
                              </tr>
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ReciverPinCode</b></font></span></td>
                                <td><label>
                                  <input name="rpin" type="text" id="password" value="${LostPost.rpin }">
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
    
    <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
    
  </body>
</html>
