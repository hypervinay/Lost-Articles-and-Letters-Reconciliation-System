<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
 <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
			</head>
  
  <body>
  
  
<jsp:include page="Header.jsp"></jsp:include>
   
   <form action="<%=request.getContextPath()+"/DeliveryAction"%>" name="delivery">
   <table border="1">
    <tr bgcolor="#FFOOCCFFDD"><i> Delivery Information</i></tr>
    <tr>
    <br/><br/>
     <tr>
     <%
     int postid=Integer.parseInt(request.getParameter("postid"));
     
     String dlocation=request.getParameter("rlocation");
     
     %>
     
     
     
                                <td width="128"><span class="style17"><font color="higblue"><b>PostId</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="postid" value="<%=postid %>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            <tr>
                            
                            <td width="128"><span class="style17"><font color="higblue"><b>DeliveryLocation</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="dlocation" value="<%=dlocation%>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            
                            <tr>
                            
                            <td width="128"><span class="style17"><font color="higblue"><b>PostMan</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="login" value="<%=(String)session.getAttribute("user")%>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            
                             <tr>
                             <td align="right">
                             <input type="submit" name="submit" value="DELIVERY">
                              </td></tr>
                            
               </table>
               </form>
         
         <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("delivery");

    frmvalidator.addValidation("login","req","Postman Name is required");
    frmvalidator.addValidation("login","alpha","Postman Name is Only Characters");
    frmvalidator.addValidation("dlocation","req","DeliveryLocation is required");
    frmvalidator.addValidation("dlocation","alpha","DeliveryLocation is Only Characters");
    frmvalidator.addValidation("postid","req","postid is required");
   

  </script>
            
               
               <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>      
  </body>
</html>
