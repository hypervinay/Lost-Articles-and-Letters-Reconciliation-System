<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html xmlns="http://www.w3.org/1999/xhtml"><head id="ctl00_header">                   

  <body bgcolor="">
  
   <jsp:include page="../jsps/Header.jsp"></jsp:include>

		<br/>
  
   <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>POSTEL INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Postel Info</i></tr>

   <tr><th bgcolor="lightblue"><b>POSTID</b></th><th bgcolor="lightblue"><b>POST ITEM</b></th><th bgcolor="lightblue"><b>POST TYPE</b></th><th bgcolor="lightblue"><b>POSTDATE</b></th><th bgcolor="lightblue"><b>POSTLOCATION</b></th><th bgcolor="lightblue"><b>ADDRESS INFO</b></th><th bgcolor="lightblue"><b>ACTIONS</b></th>
    </tr>
   
   <c:if test="${not empty PostalInfo}">
   <c:forEach var="PostalInfo" items="${PostalInfo}">
   <tr>
  <td><a href="./ViewPostAtAction?postid=${PostalInfo.postid }">${PostalInfo.postid }</td>
                  <td>${PostalInfo.pitem }</td>
                 <td>${PostalInfo.ptype }</td>
                 <td>${PostalInfo.pdate }</td>
                 <td>${PostalInfo.plocation }</td>
          <td><a href="./GetSenderInfoAction?postid=${PostalInfo.postid }">SenderAddress</a>
       <br/>
<a href="./GetReceiverInfoAction?postid=${PostalInfo.postid }">ReceiverAddress</a>
</td> 
<td><a href="./CancelPostRecordAction?postid=${PostalInfo.postid }">Cancel</a></td>
</tr>
</c:forEach>
</c:if>


    <br></table>
   
    <center>
    <a href="./jsps/PostDetails.jsp">Add New Postel Info</a>
    </center>
   
<br/><br/>
Note:Click on Postid to Update


 
                  <jsp:include page="Footer.jsp"></jsp:include> 
</body></html>