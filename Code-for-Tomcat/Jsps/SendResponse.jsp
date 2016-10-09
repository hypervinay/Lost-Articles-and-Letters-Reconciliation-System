<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  
  <jsp:include page="Header.jsp"></jsp:include>
  
  
		 <br/> <br/>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>RESPONSE INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Send Response Info</i></tr>
   <br/> 
   <tr><th><b>ComplaintId</b></th><th><b>PostId</b></th><th><b>UserId</b></th><th><b>UserName</b></th><th><b>Description</b></th><th><b>ComplaintDate</b></th><th><b>Status</b></th><th><b>Send Response</b></th>
    </tr>
   
   
   
   
<c:if test="${not empty ResponseComplaint}">
  
  <c:forEach var="ResponseComplaint" items="${ResponseComplaint}">
  <tr>
         <td>${ResponseComplaint.compid }</td>
       <td>${ResponseComplaint.postid }</td>
        <td>${ResponseComplaint.userid }</td>
      <td>${ResponseComplaint.fname} ${ComplaintInfo.lname }</td>
        <td>${ResponseComplaint.description }</td>
         <td>${ResponseComplaint.cdate }</td> 
       <td>${ResponseComplaint.cstatus }</td>
      



<td>

     <c:choose>
        <c:when test="${ResponseComplaint.cstatus eq 'notfound'}">
        
        <a href="./jsps/Response.jsp?compid=${ResponseComplaint.compid }">Send Response</a>
        </c:when>
        </c:choose>
        
        <c:choose>
        <c:when test="${ResponseComplaint.cstatus eq 'found'}">
        <a href="./jsps/Response.jsp?compid=${ResponseComplaint.compid }">Send Response</a>
      </c:when>
      </c:choose>
</td>
</tr>

</c:forEach>
</c:if>

    <br></table>
    
    <br/><br/>
 
   
   <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
   
  </body>
</html>
