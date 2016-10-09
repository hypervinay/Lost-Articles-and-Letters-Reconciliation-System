<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Services.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
<table align="center">
			<tr>
				<td colspan="1" width="900" height="180" valign="top"><img src="images/header34.jpg" align="top" height="170" width="900"/></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="30"><center><font color="seawaterblue" size="6"><b><i>Lost Articles and  </i></b></font><font color="paleblbrickred" size="6"><b><i> Letters Reconciliation System</i></b></font></center></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="1" ><img src="images/footer1.jpg" height="12" width="900"/></td>
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
					
					<jsp:include page="PostmanMenu.jsp"/>			
					<%}
					else if (session.getAttribute("role").equals("master"))
					{%>
					
					<jsp:include page="Mastermenu.jsp"/>			
					<%}
					else if (session.getAttribute("role").equals("user"))
					{%>
					
					<jsp:include page="Customeroptions.jsp"/>			
					<%}
				else {%>
						<jsp:include page="menubeforelogin.jsp"/>
					<%}
			}		
				else {%>
						<jsp:include page="menubeforelogin.jsp"/>
					<%}%>
		</table>
		
		
		<h3><font color="#1274c9"> Contact Details Of       <font color="seawaterblue" size=""><b><i>Lost Articles and  </i></b></font><font color="paleblbrickred" size=""><b><i> Letters Reconciliation System</i></b></font>  </font>
		</h3>
		<br/><br/><br/><br/><br/><br/>
                  <table>
                  
                  <tr>
				<td colspan="2" width="900" height="20"><img src="images/footer1.jpg" height="18" width="900"/><br></td>
			</tr>
		</table>