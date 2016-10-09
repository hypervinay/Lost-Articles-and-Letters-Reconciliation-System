<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.post.bean.PostTo"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  
  <jsp:include page="Header.jsp"></jsp:include>
  
  
		 <br/> <br/>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>LOSTARTICEL INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>LostArticel Info</i></tr>
   <br/> 
   <tr><th><b>PostId</b></th><th><b>SenderName</b></th><th><b>SenderLocation</b></th><th><b>ReceiverName</b></th><th><b>ReceiverLocation</b></th><th><b>Status</b></th><th><b>ChangeStatus</b></th>
    </tr>
    
    <c:if test="${not empty lostvector}">
    <c:forEach var="lostvector" items="${lostvector}">
    
  <tr>
<td>${lostvector.postid }</td>
<td>${lostvector.sname }</td>
<td>${lostvector.slocation }</td>
<td>${lostvector.rname }</td>
<td>${lostvector.rlocation }</td>
<td>${lostvector.astatus }</td> 
<td><a href="./jsps/Status.jsp?postid=${lostvector.postid }">ChangeStatus</a> </td>

</tr>

</c:forEach>
</c:if>

    <br></table>
    
    <br/><br/>
 
   
   <br/><br/> 
                 <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
