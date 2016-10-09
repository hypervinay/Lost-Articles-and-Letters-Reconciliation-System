 
<body>
    
    <table align="center">
			<tr>
				<td colspan="1" width="900" height="180" valign="top"><img src="<%=request.getContextPath()+"/images/header34.jpg" %>" align="top" height="170" width="900"/></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="30"><center><font color="seawaterblue" size="6"><b><i>Lost Articles and  </i></b></font><font color="paleblbrickred" size="6"><b><i> Letters Reconciliation System</i></b></font></center></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="1" ><img src="<%=request.getContextPath()+"/images/footer1.jpg" %>" height="12" width="900"/></td>
			</tr>
		</table>
		<table width="1000">
		
		<%if(session.getAttribute("role")!=null){
   				if (session.getAttribute("role").equals("admin"))
		
					{%>
					<jsp:include page="adminmenu.jsp"/>
					<% }
				else if (session.getAttribute("role").equals("postman"))
					{%>
					
					<jsp:include page="PostmanMenu.jsp.jsp"/>			
					<%}
					else if (session.getAttribute("role").equals("master"))
					{%>
					
					<jsp:include page="Mastermenu.jsp"/>			
					<%}
					else if (session.getAttribute("role").equals("user"))
					{%>
					
					<jsp:include page="Customeroptions.jsp.jsp"/>			
					<%}
				else {%>
						<jsp:include page="menubeforelogin.jsp"/>
					<%}
			}		
				else {%>
						<jsp:include page="menubeforelogin.jsp"/>
					<%}%>
		</table>
		<br/><br/><br/>
		
		
		
		<table align="center">
			<tr>
				<td colspan="1" width="900" height="180" valign="top"><img src="<%=request.getContextPath()+"/images/misty.jpg"%>" align="top" height="170" width="900"/></td>
			</tr>
			</table>
		
		
		
		
		
		 
    
			 <br/><br/>
			
                  <table>
                  
                  <tr>
				<td colspan="2" width="900" height="20"><img src="<%=request.getContextPath()+"/images/footer1.jpg"%>" height="18" width="900"/><br></td>
			</tr>
		</table>
		</body>