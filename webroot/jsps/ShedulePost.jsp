<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.post.bean.PostTo"%>

<%@page import="com.post.delegate.PostMgrDelegate"%>
<html>
 <head>
 <script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
 <script language="javascript" type="text/javascript">
 function PostMan()
			{
			var postid = document.getElementById('select').value;
			alert(postid);
			
			window.location.href="<%=request.getContextPath()%>/GetPostManAction?postid="+postid;
			}
			
			</script>
			</head>
 
  <body>
  <jsp:include page="Header.jsp"></jsp:include>
  
   <center>
		<form action="<%=request.getContextPath()+"/ShedulePostAction"%>" name="postshedule">
		
    <table border="1">
    <tr bgcolor="#FFOOCCFFDD"><i> ShedulePost Table</i></tr>
    <tr>
    <br/><br/>
     <tr>
     
   
                                <td width="128"><span class="style17"><font color="higblue"><b>PostId</b></font> </span></td>
                                <td width="269"><label>
                              
                            <select name="postid"  id="select" onchange="javascript:PostMan();">
                           
                           <c:choose>
				 <c:when test="${requestScope.postid ne null}">
				   <option value="${requestScope.postid}">${requestScope.postid}</option>
				 </c:when>
				                     
                        <c:otherwise>
				   <option value="">--SELECT--</option>
				   <c:if test="${not empty PostInfo}">
				<c:forEach var="PostInfo" items="${PostInfo}">
				<option value="${PostInfo.postid}">								
				${PostInfo.postid}:${PostInfo.rlocation}
				</option>
				</c:forEach>
				</c:if>
				 </c:otherwise>
				 </c:choose>
                           </select>
                                </label></td>
                              </tr>
                              
                              <c:if test="${not empty PostManVector}">
                                  <c:forEach var="PostManVector" items="${PostManVector}">
                                  
                                  <tr>
                                <td><span class="style17"><font color="higblue"><b>Userid</b></font></span></td>
                                <td><label>
                                 
                         
                                <input type="text"  name="userid"   value="${PostManVector.userid }${PostManVector.fname }${PostManVector.lname }" >
                                    
                                    <input type="hidden" name="post" value="${PostManVector.userid }"> 
                                    </c:forEach>
                                    </c:if>
                               
                            
   
    
    <tr>
    <br/>
                             <td align="right">
                             <input type="submit" name="submit" value="SUBMIT">
                              </td></tr>
    </table>
    </form>
    
    	<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("postshedule");

  frmvalidator.addValidation("postid","req","QueryId is required");

    frmvalidator.addValidation("userid","req","Sender is required");
    </script>
    </center>
    
     <br/><br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
  </body>
</html>
