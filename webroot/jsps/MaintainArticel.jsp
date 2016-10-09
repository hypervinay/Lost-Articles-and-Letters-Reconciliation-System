<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">



                        

  <body bgcolor="">
  
  <jsp:include page="Header.jsp"></jsp:include>
  
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>MAINTAIN LOST ARTICEL INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Maintain Lost Articel Info</i></tr>

   <tr><th><b>POSTID</b></th><th><b>POST ITEM</b></th><th><b>POST TYPE</b></th><th><b>POSTDATE</b></th><th><b>POSTLOCATION</b></th><th><b>ADDRESS INFO</b></th><th><b>POST STATUS</b></th><th><b>ACTIONS</b></th>
    </tr>
    <c:if test="${not empty MaintainPost}">
  <c:forEach var="MaintainPost" items="${MaintainPost}"> 
  
  <tr>
  
        <td>${MaintainPost.postid }</td>
         <td>${MaintainPost.pitem }</td>
         <td>${MaintainPost.ptype }</td>
         <td>${MaintainPost.pdate }</td>
         <td>${MaintainPost.plocation }</td>
     <td><a href="./MaintainSenderInfoAction?postid=${MaintainPost.postid }">SenderAddress</a>
    <br/>
    <a href="./MaintainReceiverAction?postid=${MaintainPost.postid }">ReceiverAddress</a>
  </td> 
   <td> ${MaintainPost.dstatus }</td>
   <td><a  href="./GetStoreAction?postid=${MaintainPost.postid }"> MaintainThisInfo</a>   </td>

</tr>

   </c:forEach>
</c:if>
    <br></table>
    <br/><br/><br/>
    

 <br/><br/>
                 <jsp:include page="Footer.jsp"></jsp:include> 

</body></html>