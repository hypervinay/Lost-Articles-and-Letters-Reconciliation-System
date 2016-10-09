<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  
  <jsp:include page="Header.jsp"></jsp:include>
  
  
		 <br/> <br/>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>SHEDULE INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>PostShedule Info</i></tr>
   <br/> 
   <tr><th><b>SheduleId</b></th><th><b>PostId</b></th><th><b>ReceiverLocation</b></th><th><b>PostManId</b></th><th><b>PostManLocation</b></th><th><b>SheduledDate</b></th><th><b>Status</b></th><th><b>Actions</b></th>
    </tr>
    <c:if test="${not empty Allpost}">
<c:forEach var="post" items="${Allpost}">
  <tr>



<td>${post.sheduleid }</td>
<td>${post.postid }</td>
<td>${post.rlocation }</td>
<td>${post.userid }</td>
<td>${post.ulocation }</td>
<td>${post.sdate }</td>
<td>${post.sstate }</td>



<c:choose>
        <c:when test="${post.sstate eq 'deliveried'}">
        
        <td bgcolor="#C3D7BA"><div align="center"><span class="style7">Already Deliveried</span></div></td>
      </c:when>
      </c:choose>
      <c:choose>
        <c:when test="${post.sstate eq 'notdelivered'}">
        
        <td><a href="./jsps/Delevery.jsp?postid=${post.postid }&rlocation=${post.rlocation }">Delivery</a>
      </c:when>
      </c:choose>



</tr>
</c:forEach>
</c:if>




    <br></table>
    
    <br/><br/>
 
   
   <br/><br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
   
  </body>
</html>
