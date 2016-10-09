<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">



                        

  <body bgcolor="">
  
  <jsp:include page="../jsps/Header.jsp"></jsp:include>
   <br/>
  
  
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>POSTEL INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Postel Info</i></tr>

   <tr><th><b>POSTID</b></th><th><b>POST ITEM</b></th><th><b>POSTLOCATION</b></th><th><b>POSTDATE</b></th><th><b>DELIVERYDATE</b></th><th><b>ADDRESS INFO</b></th><th><b>STATUS</b></th><th><b>SEND REPORT</b></th>
    </tr>
   <c:if test="${not empty PostmanPost}">
   
   <c:forEach var="PostmanPost" items="${PostmanPost}">

   <tr>
   
   
          <td>${PostmanPost.postid }</td>
          <td>${PostmanPost.pitem }</td>
          <td>${PostmanPost.plocation }</td>
          <td>${PostmanPost.pdate }</td>
           <td>${PostmanPost.ddate }</td>
      <td><a href="./PostmanSenderAction?postid=${PostmanPost.postid }">SenderAddress</a>
       <br/>
        <a href="./PostmanReceiverAction?postid=${PostmanPost.postid }">ReceiverAddress</a>
         </td> 
<td> ${PostmanPost.dstatus }</td>

<TD><a href="./jsps/Report.jsp?postid=${PostmanPost.postid }&pdate=${PostmanPost.pdate }&dstatus=${PostmanPost.dstatus }">Send Report</a></TD>
</tr>
</c:forEach>
</c:if>




    <br></table><br/>
    
               <jsp:include page="Footer.jsp"></jsp:include>

</body></html>