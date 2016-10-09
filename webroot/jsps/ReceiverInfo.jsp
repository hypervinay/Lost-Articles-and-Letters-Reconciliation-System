<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  
 <jsp:include page="../jsps/Header.jsp"></jsp:include>
   <br/>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>RECEIVER INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Receiver Info</i></tr>
   <br/>
   <tr><th><b>Receiver Name</b></th><th><b>ReceiverHouseNo</b></th><th><b>ReceiverLocation</b></th><th><b>ReceiverCity</b></th><th><b>ReceiverState</b></th><th><b>ReceiverPin</b></th>
    </tr>
   
   <tr>
   
   <c:if test="${not empty ReceiverInfo}">
   
   <c:forEach var="ReceiverInfo" items="${ReceiverInfo}">
   
   
          <td>${ReceiverInfo.rname }</td>
          <td>${ReceiverInfo.rhouseno }</td>
          <td>${ReceiverInfo.rlocation }</td>
          <td>${ReceiverInfo.rcity }</td>
          <td>${ReceiverInfo.rstate }</td>
           <td>${ReceiverInfo.rpin }</td> 
           
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

  <a href="./ViewLostArticelInfoAction">Back</a>
  <%
  } else if(session.getAttribute("role").equals("postman"))
  {
  %>

  <a href="./GetPostmanPostsAction?page=/jsps/PostManPosts.jsp"">Back</a>
  <%
  }
   %>
 <c:if test="${empty ReceiverInfo}">
   
   <c:forEach var="ReceiverInfo" items="${ReceiverInfo}">
  
  System.out.println("No Records Found");
 
 
   </c:forEach>
   </c:if>
   </center>
   
   <br/><br/>
               <jsp:include page="../jsps/Fotter.jsp"></jsp:include>
  </body>
</html>
