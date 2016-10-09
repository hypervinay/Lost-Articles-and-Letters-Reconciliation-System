<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<html>
 <head>
 
 <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
			</head>
 
  <body>
<jsp:include page="Header.jsp"></jsp:include>

		<form action="<%=request.getContextPath()+"/PostComplaintAction"%>" name="complaint">
		
    <table border="1">
    <tr bgcolor="#FFOOCCFFDD"><i> Complaint Info</i></tr>
    <tr>
    <br/><br/>
     <tr>
     
   
                                <td width="128"><span class="style17"><font color="higblue"><b>UserName</b></font> </span></td>
                                <td width="269"><label>
                              <input type="text" name="login" value="<%=(String)session.getAttribute("user")%>" readonly="readonly">
                                </label></td>
                              </tr>
                              
                             
 
 

                              <tr>
                                <td><span class="style17"><font color="higblue"><b>PostId</b></font></span></td>
                                <td><label>
                                 
                         
                                <input type="text"  name="postid">
                                     
                                    
                                    
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>ComplaintDescription</b></font></span></td>
                                <td><label>
                              <textarea rows="5" cols="35" name="description"></textarea>
                              </label>
                              </td>
                              </tr>
                              
                              
    
    
    <tr>
    <br/>
                             <td align="right">
                             <input type="submit" name="submit" value="POSTCOMPLAINT">
                              </td></tr>
    </table>
    </form>
    
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("complaint");

  frmvalidator.addValidation("login","req","User Name is required");
    frmvalidator.addValidation("login","alpha","User Name is Only Characters");
    frmvalidator.addValidation("description","req","Description is required");

    frmvalidator.addValidation("postid","req","postid is required");
   

  </script>
    <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
   
  </body>
</html>
