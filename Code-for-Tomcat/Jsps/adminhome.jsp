<body>

<jsp:include page="../jsps/Header.jsp"></jsp:include>
  
  <br/>

		
          <h2>PostMasterHome</h2>
                      
                  <h2>    <center>Welcome To The PostMaster <%=(String)session.getAttribute("user") %> </center></h2>
                   <center>
                   <table>
                  
                  <tr>
				<td colspan="2" width="" height="100"><img src="<%=request.getContextPath()+"/images/header.gif"%>" align="top" height="150" width="450"/></td>
			</tr>
		</table>
		</center>
                  
                 <br/>
                   <jsp:include page="../jsps/Fotter.jsp"></jsp:include>

