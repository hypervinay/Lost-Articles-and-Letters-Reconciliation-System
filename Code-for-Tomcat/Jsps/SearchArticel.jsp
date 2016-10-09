<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
 <head>
 
      <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
			</head>
 
  <body>
  
<jsp:include page="Header.jsp"></jsp:include>

 <center>

		<form action="<%=request.getContextPath()+"/SearchAtricelAction"%>" name="postshedule">
		
    <table border="1" width="785" height="173">
    <tr bgcolor="#FFOOCCFFDD"><i> Search Articel Info</i></tr>
    <tr>
    <br/><br/>
     <tr>
     <%
     
     int compid=Integer.parseInt(request.getParameter("compid"));
     int postid=Integer.parseInt(request.getParameter("postid"));
     String ddate=request.getParameter("cdate");
     
     
      %>
     
   
                                <td width="128"><span class="style17"><font color="higblue"><b>ComplaintId</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="compid" value="<%=request.getParameter("compid") %>" readonly="readonly">
                                </label></td>
                              </tr>
                              
                             
 
 

                              <tr>
                                <td><span class="style17"><font color="higblue"><b>PostId</b></font></span></td>
                                <td><label>
                                 
                         
                                <input type="text"  name="postid" value="<%=request.getParameter("postid") %>" readonly="readonly">
                                     
                                    
                                    
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ComplaintDate</b></font></span></td>
                                <td><label>
                         <input type="text" name="cdate" value="<%=request.getParameter("cdate") %>" readonly="readonly">
                              </label>
                              </td>
                              </tr>
                              
                              
    
    
    <tr>
    <br/>
                             <td align="right">
                             <input type="submit" name="submit" value="SEARCH">
                              </td></tr>
    </table>
    </form>
    <br/><br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
    </center>
  </body>
</html>
