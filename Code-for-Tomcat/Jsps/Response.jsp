<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<html>
 <head>
 <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
 
			</head>
 
  <body>
   
<jsp:include page="../jsps/Header.jsp"></jsp:include>
   <br/>


		<form action="<%=request.getContextPath()+"/SendResponseAction"%>" name="postshedule">
		
    <table border="1">
    <tr bgcolor="#FFOOCCFFDD"><i> Response Info</i></tr>
    <tr>
    <br/><br/>
    
                             
 <%
 
 int compid=Integer.parseInt(request.getParameter("compid"));
 
  %>
 

                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ComplaintId</b></font></span></td>
                                <td><label>
                                 
                         
                                <input type="text"  name="compid" value=<%= compid%> readonly="readonly">
                                     
                                    
                                    
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ResponseDescription</b></font></span></td>
                                <td><label>
                              <textarea rows="5" cols="35" name="description"></textarea>
                              </label>
                              </td>
                              </tr>
                              
                              
    
    
    <tr>
    <br/>
                             <td align="right">
                             <input type="submit" name="submit" value="POST RESPONSE">
                              </td></tr>
    </table>
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
    var frmvalidator  = new Validator("postshedule");

  frmvalidator.addValidation("compid","req","ComplaintId is required");
   
    frmvalidator.addValidation("description","req","Description is required");
   
    </script>
    <br/><br/>
               <jsp:include page="Fotter.jsp"></jsp:include>
    
  </body>
</html>
