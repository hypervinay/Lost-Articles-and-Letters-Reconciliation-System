<html>
<head>

<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>

</head>

<body>
  
<jsp:include page="Header.jsp"></jsp:include>

<center>
		<form action="ChangeStatus" name="postshedule">
		
    <table border="1" width="785" height="173">
    <tr bgcolor="#FFOOCCFFDD"><i> Search Articel Info</i></tr>
    <tr>
    <br/><br/>
     <tr>
     <%
     
    
     int postid=Integer.parseInt(request.getParameter("postid"));

     
     
      %>
     
   
                                
                              
                             
 
 

                              <tr>
                                <td><span class="style17"><font color="higblue"><b>PostId</b></font></span></td>
                                <td><label>
                                 
                         
                                <input type="text"  name="postid" value="<%=postid %>">
                                     
                                    
                                    
                                </label></td>
                              </tr>
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>Status</b></font></span></td>
                                <td><label>
                         <input type="text" name="astatus" >
                              </label>
                              </td>
                              </tr>
                              
                              
    
    
    <tr>
    <br/>
                             <td align="right">
                             <input type="submit" name="submit" value="ChangeStatus">
                              </td></tr>
    </table>
    </form>
    <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("postshedule");

  frmvalidator.addValidation("postid","req","PostId is required");

    frmvalidator.addValidation("astatus","req","Status is required");
    frmvalidator.addValidation("astatus","alpha","Status is Only Characters");
    </script>
    <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
    </center>
    </body>
    </html>
  