<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  
  <jsp:include page="Header.jsp"></jsp:include>
  
  
		 <br/> <br/>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>SEARCHING INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>SearchAtricelInfo</i></tr>
   <br/> 
   <tr><th><b>ComplaintId</b></th><th><b>PostId</b></th><th><b>UserId</b></th><th><b>UserName</b></th><th><b>Description</b></th><th><b>ComplaintDate</b></th><th><b>Status</b></th><th><b>SearchAction</b></th>
    </tr>
    
   <c:if test="${not empty SearchComplaint}">
  
  <c:forEach var="SearchComplaint" items="${SearchComplaint}">
  <tr>
         <td>${SearchComplaint.compid }</td>
       <td>${SearchComplaint.postid }</td>
        <td>${SearchComplaint.userid }</td>
      <td>${SearchComplaint.fname} ${ComplaintInfo.lname }</td>
        <td>${SearchComplaint.description }</td>
         <td>${SearchComplaint.cdate }</td> 
       <td>${SearchComplaint.cstatus }</td>
     


     <c:choose>
        <c:when test="${SearchComplaint.cstatus eq 'notfound'}">
        
        <td><a href="./jsps/SearchArticel.jsp?compid=${SearchComplaint.compid }&postid=${SearchComplaint.postid }&cdate=${SearchComplaint.cdate }">SearchArticel</a></td>
        </c:when>
        </c:choose>
        
        <c:choose>
        <c:when test="${SearchComplaint.cstatus eq 'found'}">
        
        <td> Already Found</td>
       
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
