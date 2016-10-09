<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<html>
<head>


    <style type="text/css">
<!--
.style1 {
	font-size: 50px
}
-->
    </style>
    </head><body onload="mainOnLoad();">
    
    
    <jsp:include page="Header.jsp"></jsp:include>
	
			<center><h2><font color="Orange">Complaints Status</font></h2></center>
		  <div class="hr"> </div>
          <p></p> 
                    <form method="post" action="ViewSolution">
 
    <table width="637" border="0" align="center" bordercolor="#8692E3">
    
      <tr bgcolor="#509Ccc">
     
        <td width="18"><div align="center">
            
        </div></td>
        <td width="233"><div align="center" class="style8">Complaint Id</div></td>
        <td width="233"><div align="center" class="style8">Post Id</div></td>
        
        <td width="372"><div align="center" class="style8">Complaint Date</div></td>
        <td width="372"><div align="center" class="style8">Status</div></td>
        <td width="372"><div align="center" class="style8">Response</div></td>
      </tr>
      
      
      
      <c:if test="${not empty ComplaintStatus}">
      <c:forEach var="ComplaintStatus" items="${ComplaintStatus}">
         
      <tr bgcolor="areef">
      <td bgcolor=""><input name="ch" type="checkbox" id="checkbox2" onclick="check1()" value="${ComplaintStatus.sdate }"/></td> 
      <td bgcolor=""><div align="center"><span class="style7">${ComplaintStatus.compid }</span></div></td>
       <td bgcolor=""><div align="center"><span class="style7">${ComplaintStatus.postid }</span></div></td>
      <td bgcolor=""><div align="center"><span class="style7">${ComplaintStatus.cdate }</span></div></td>
      <td bgcolor=""><div align="center"><span class="style7">${ComplaintStatus.cstatus}</span></div></td>
       <c:choose>
        <c:when test="${ComplaintStatus.cstatus eq 'found'}">
        
        <td bgcolor="#C3D7BA"><div align="center"><span class="style7"><a href="./ViewResponseAction?compid=${ComplaintStatus.compid }">View</a></span></div></td>
      </c:when>
      </c:choose>
      <c:choose>
        <c:when test="${ComplaintStatus.cstatus eq 'notfound'}">
        
        <td bgcolor="#C3D7BA"><div align="center"><span class="style7">Sorry u complaint is not Solved</span></div></td>
      </c:when>
      </c:choose>
      </tr>
     </c:forEach>
     </c:if>
      
       <c:if test="${ empty ComplaintStatus}">
          <c:forEach var="ComplaintStatus" items="${ComplaintStatus}">
     
         <tr><td height="24" colspan="6"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
     </c:forEach>
     </c:if>
          
      
      
   
          <tr>
        <td colspan="6"><div align="center">
         
          <input type="submit" name="delete" value="Delete"/>
         
        </div></td>
      </tr>
     
    </table>
     <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
  </form>

</body></html>