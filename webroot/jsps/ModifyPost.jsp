<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  
  
  <jsp:include page="Header.jsp"></jsp:include>
		 <br/> <br/>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>MODIFY INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>ModifiedPost Info</i></tr>
   <br/> 
  <tr><th><b>PostId</b></th><th><b>ReceiverLocation</b></th><th><b>PostManId</b></th><th><b>PostManLocation</b></th><th><b>DeliveryDate</b></th><th><b>Status</b></th><th><b>Action</b></th>
    </tr>
   
   
   <c:if test="${not empty DeliveryInfo}">
   <c:forEach var="DeliveryInfo" items="${DeliveryInfo}">
        <tr>

   
            <td>${DeliveryInfo.postid }</td>
           <td>${DeliveryInfo.rlocation }</td>
          <td>${DeliveryInfo.userid }</td>
          <td>${DeliveryInfo.ulocation }</td>
          <td>${DeliveryInfo.ddate }</td> 
          <td>${DeliveryInfo.dstatus }</td>
          
<td><a href="./jsps/UpdatePostStatus.jsp?postid=${DeliveryInfo.postid }&ddate=${DeliveryInfo.ddate }&dstatus=${DeliveryInfo.dstatus }">ModifyPostStatus</a> </td>
</tr>
</c:forEach>
</c:if>




    <br></table>
    
    <br/><br/>
 
   
   <br/>
                  <jsp:include page="Footer.jsp"></jsp:include> 
   
  </body>
</html>
