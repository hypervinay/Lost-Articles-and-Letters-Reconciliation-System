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
   <tr><th bgcolor="lightblue"><b>SheduleId</b></th><th bgcolor="lightblue"><b>PostId</b></th><th bgcolor="lightblue"><b>ReceiverLocation</b></th><th bgcolor="lightblue"><b>PostManId</b></th><th bgcolor="lightblue"><b>PostManLocation</b></th><th bgcolor="lightblue"><b>SheduledDate</b></th>
    </tr>
    <c:if test="${not empty Allpost}">
   <c:forEach var="Allpost" items="${Allpost}">
   <tr>
   
   
   
<td>${Allpost.sheduleid }</td>
<td>${Allpost.postid }</td>
<td>${Allpost.rlocation }</td>
<td>${Allpost.userid }</td>
<td>${Allpost.ulocation }</td>
<td>${Allpost.sdate }</td> 

</tr>

</c:forEach>
</c:if>

    <br></table>
    
    <br/><br/>
  
   
   <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
