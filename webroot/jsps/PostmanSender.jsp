<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  <jsp:include page="Header.jsp"></jsp:include>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>SENDER INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Sender Info</i></tr>
   <br/>
   <tr><th><b>SenderName</b></th><th><b>SenderHouseNo</b></th><th><b>SenderLocation</b></th><th><b>SenderCity</b></th><th><b>SenderState</b></th><th><b>SenderPin</b></th>
    </tr>
 <tr>
       <c:if test="${not empty PostSender}">
       <c:forEach var="SenderInfo" items="${PostSender}">
    
        <td>${SenderInfo.sname }</td>
        <td>${SenderInfo.shouseno }</td>
         <td>${SenderInfo.slocation }</td>
         <td>${SenderInfo.scity }</td>
        <td>${SenderInfo.sstate }</td>
       <td>${SenderInfo.spin }</td> 
       </c:forEach>
       </c:if>
</tr>



    <br></table>
    
    <br/><br/>
  <center>
 
  <% 
 String login =(String)session.getAttribute("user");
  System.out.println("In jsp logintype is......"+login);
 
 if(session.getAttribute("role").equals("admin"))
 {
  
 %>
  
  <a href="<%=request.getContextPath()+"/ViewPostInfoAction"%>">Back</a>
  
  <%
  }
  else if(session.getAttribute("role").equals("master"))
  {
  %>

  <a href="<%=request.getContextPath()+"/ViewLostArticelInfoAction"%>">Back</a>
  <%
  } else if(session.getAttribute("role").equals("postman"))
  {
  %>

  <a href="<%=request.getContextPath()+"/GetPostmanPostsAction?page=/jsps/SendReport.jsp"%>">Back</a>
  <%
  }
 %>
  
  <c:if test="${ empty PostSender}">
  <c:forEach var="SenderInfo" items="${PostSender}">
  System.out.println("No Records Found");
 
 
   </c:forEach>
   </c:if>
   </center>
   
    <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
   
  </body>
</html>
