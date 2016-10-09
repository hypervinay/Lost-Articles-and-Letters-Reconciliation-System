<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.post.formbean.PostBean"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  
  <body>
  
 <jsp:include page="Header.jsp"></jsp:include>
		 <br/> <br/>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>CHANGE STATUS INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Change Status Info</i></tr>
   <br/> 
   <tr><th><b>PostId</b></th><th><b>SenderName</b></th><th><b>SenderLocation</b></th><th><b>ReceiverName</b></th><th><b>ReceiverLocation</b></th><th><b>Status</b></th><th><b>ChangeStatus</b></th>
    </tr>
   <%
   
  
  Vector<PostBean> vpb=(Vector<PostBean>) session.getAttribute("lostvector");
 Iterator it=vpb.listIterator();

 while(it.hasNext())
 {%><tr>
 <%PostBean rb=(PostBean)it.next();
session.setAttribute(""+rb.getPostid(),rb);

%>
<td><%=rb.getPostid()%></td>
<td><%=rb.getSname()%></td>
<td><%=rb.getSlocation()%></td>
<td><%=rb.getRname()%></td>
<td><%=rb.getRlocation()%></td>
<td><%=rb.getAstatus() %></td> 
<td><a href="./Status.jsp?postid=<%=rb.getPostid()%>">ChangeStatus</a> </td>
</tr>

<% }
%>

    <br></table>
    
    <br/><br/>
 
   
   <br/><br/> 
                  <jsp:include page="Footer.jsp"></jsp:include>
   
  </body>
</html>
