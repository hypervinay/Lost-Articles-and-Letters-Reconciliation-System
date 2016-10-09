<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  
  <jsp:include page="Header.jsp"></jsp:include>
  
  
  
		 <br/> <br/>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>COMPLAINT INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Complaint Info</i></tr>
   <br/> 
   <tr><th><b>ComplaintId</b></th><th><b>PostId</b></th><th><b>UserId</b></th><th><b>UserName</b></th><th><b>Description</b></th><th><b>ComplaintDate</b></th><th><b>Status</b></th>
    </tr>
  <c:if test="${not empty ComplaintInfo}">
  
  <c:forEach var="ComplaintInfo" items="${ComplaintInfo}">
  <tr>
  
  
         <td>${ComplaintInfo.compid }</td>
       <td>${ComplaintInfo.postid }</td>
        <td>${ComplaintInfo.userid }</td>
      <td>${ComplaintInfo.fname} ${ComplaintInfo.lname }</td>
        <td>${ComplaintInfo.description }</td>
         <td>${ComplaintInfo.cdate }</td> 
       <td>${ComplaintInfo.cstatus }</td>
       </tr>
      </c:forEach>
        </c:if>



    <br></table>
    
    <br/><br/>
 
   
   <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
   
  </body>
</html>
