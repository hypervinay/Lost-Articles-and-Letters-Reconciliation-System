 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<body>

<jsp:include page="../jsps/Header.jsp"></jsp:include>

		<br/>
<center><h3><font color="teal"><b><i>View All Employee Details</b></font></h3></center>
   
  
      
      <input type="hidden" name="type" value="projcode"/>
      <input type="hidden" name="value" value="<%=request.getParameter("projcode")%>"          />
    <table width="" border="0" align="center" bordercolor="#F4F5F7">
    
      <tr bgcolor="#asHblue">
       
        
        
        <td width="110"><div align="center" class="style8"><b>Designation</b></div></td>
        <td width="110"><div align="center" class="style8"><b>FirstName</b></div></td>
        <td width="87"><div align="center" class="style8"><b>LastName</b></div></td>
        <td width="64"><div align="center" class="style8"><b>Dob</b></div></td>
      <td width="110"><div align="center" class="style8"><b>Email</b></div></td>
        <td width="87"><div align="center" class="style8"><b>Fax</b></div></td>
        
        <td width="64"><div align="center" class="style8"><b>EmpPicture</b></div></td>
        
      </tr>
           <c:if test="${not empty EmpInfo}">
    <c:forEach var="EmpInfo" items="${EmpInfo}">
    
    
      <tr bgcolor="#CEC9FA" >
    
    
   
        
        <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${EmpInfo.logintype }</div></td> 
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${EmpInfo.firstname }</div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${EmpInfo.lastname }</span></div></td>
        <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${EmpInfo.bdate }</div></td> 
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${EmpInfo.email }</div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${EmpInfo.fax }</span></div></td>
        <td bgcolor="#F4F5F7"> <p><img alt="See Photo Here" id="previewField" src="userimages/${EmpInfo.photo }" height="50" width="90"></p></td>
        </tr>
      </c:forEach>
      </c:if>
        
 
      
      
      <c:if test="${empty EmpInfo}">
    <c:forEach var="EmpInfo" items="${EmpInfo}">
    
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
     </c:forEach>
     </c:if>
         
 </table>
 
 
 
 <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
</body>