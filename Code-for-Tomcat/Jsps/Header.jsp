<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  
  <body>
   <table align="center">
			<tr>
				<td colspan="1" width="900" height="180" valign="top"><img src="<%=request.getContextPath()+"/images/header34.jpg" %>" align="top" height="170" width="900"/></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="30"><center><font color="seawaterblue" size="6"><b><i>Lost Articles and  </i></b></font><font color="paleblbrickred" size="6"><b><i> Letters Reconciliation System</i></b></font></center></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="1" ><img src="<%=request.getContextPath()+"/images/footer1.jpg"%>" height="12" width="900"/></td>
			</tr>
		</table>
		 <table width="1000">
		  
		 <c:if test="${sessionScope.role!='null'}">
		
   				<c:choose>
   				<c:when test="${sessionScope.role=='admin'}">
   				<jsp:include page="./adminmenu.jsp"/>
   				</c:when>
   		        
   				
   				<c:when test="${sessionScope.role=='master'}">
   				<jsp:include page="./Mastermenu.jsp"/>
   				</c:when>
   				
			    			
				
   				<c:when test="${sessionScope.role=='postman'}">
   				<jsp:include page="./PostmanMenu.jsp"/>
   				</c:when>
   				
   				<c:when test="${sessionScope.role=='user'}">
   				<jsp:include page="./Customeroptions.jsp"/>
   				</c:when>
   
								<c:otherwise>
						<jsp:include page="./menubeforelogin.jsp"/>
					</c:otherwise>
					</c:choose>
					</c:if>
		</table>
		
		  <center>
   <font color="red"><b>
		 <c:if test="${requestScope.status!='null'}">
					 
                          <c:out value="${requestScope.status}"></c:out> 
                          </c:if>
                          </b>
                          </font>
                         
                           </center>
  </body>
</html>
