<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>

<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>

</head>
  
  <body>
   
    <jsp:include page="Header.jsp"></jsp:include>
    
    <center>
   
                 <form action="<%=request.getContextPath()+"/ModifyPostStatusAction"%>" name="post">
               <table border="1">
           <tr bgcolor="#FFOOCCFFDD"><i> Delivery Information</i></tr>
               <tr>
              <br/><br/>
          <tr>
<%--     <%--%>
<%--     int postid=Integer.parseInt(request.getParameter("postid"));--%>
<%--     --%>
<%--     String ddate=request.getParameter("ddate");--%>
<%--     String dstatus=request.getParameter("dstatus");--%>
<%--     --%>
<%--     %>--%>
     
     
     
                                <td width="128"><span class="style17"><font color="higblue"><b>PostId</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="postid" value="<%=request.getParameter("postid") %>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            <tr>
                            
                            <td width="128"><span class="style17"><font color="higblue"><b>DeliveryDate</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="ddate" value="<%=request.getParameter("ddate") %>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            
                            <tr>
                            
                            <td width="128"><span class="style17"><font color="higblue"><b>DeliveryStatus</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="dstatus" value="<%=request.getParameter("dstatus") %>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            
                             <tr>
                             <td align="right">
                             <input type="submit" name="submit" value="MODIFYSTATUS">
                              </td></tr>
                            
               </table>
               </form>
               <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("post");

  frmvalidator.addValidation("postid","req","postid is required");
 
    frmvalidator.addValidation("dstatus","alpha","Status is Only Characters");
     frmvalidator.addValidation("ddate","req","DeliveryDate is required");
    frmvalidator.addValidation("dstatus","req","Status is required");
    </script>
               </center>          
               
               
               <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
