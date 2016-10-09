
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script language="JavaScript1.2">
/*Number check script-
By JavaScript Kit (www.javascriptkit.com)
Over 200 free scripts here!
*/

function checknumber(){
var x=document.f.accno.value
var anum=/(^\d+$)|(^\d+\.\d+$)/
if (anum.test(x))
testresult=true
else{
alert("Please input a valid number!")
testresult=false
}
return (testresult)
}

</script>
<script>
function checkban(){
if(validateFields())
{
if (document.layers||document.all||document.getElementById)
return checknumber()
else
return true;
}
else
return false; 
}
</script>
<script type="text/javascript" src="scripts/project.js"></script>

<head>

    <style type="text/css">
<!--
.style1 {
	font-size: 50px
}
-->
    </style>
    </head><body onload="mainOnLoad();">
	<!-- providing keyboard shortcuts to important links -->
	
	
	
	<jsp:include page="Header.jsp"></jsp:include>
	
	
			<center><h2>All FeedBacks</h2></center>
		  <div class="hr"> </div>
          <p></p>                       <fieldset>
          
         
		     <table width="637" border="0" align="center" bordercolor="#8692E3">
         <tr bgcolor="#50cccc">
        <td width="233" height="16"><div align="center" class="style8">FeedBack ID</div></td>
        <td width="372"><div align="center" class="style8">Address</div></td>
        <td width="372"><div align="center" class="style8">MailID</div></td>
        <td width="372"><div align="center" class="style8">Content</div></td>
      </tr>
      
      
       <c:if test="${not empty AllFeedback}">
            <c:forEach var="Feedback" items="${AllFeedback}">
            
            
            <tr bgcolor="#CcC9cA">
              <td bgcolor="#C3D7BA"><div align="center"><span class="style7"> ${Feedback.fid }  </span></div></td>
        <td bgcolor="#C3D7BA"><div align="center" class="style7">${Feedback.address }</div></td>
        <td bgcolor="#C3D7BA"><div align="center"><span class="style7">${Feedback.email }</span></div></td>
        <td bgcolor="#C3D7BA"><div align="center" class="style3">
        <strong><a href="./ViewFeedbackAction?fid=${Feedback.fid }">READ</a></strong>
        
         <td bgcolor="#C3D7BA"><div align="center" class="style3">
              
        <strong><a href="<%=request.getContextPath()%>/DeleteFeedBackAction?fid=${Feedback.fid }">DELETE</a></strong>
      
        </div></td>
      </tr>  
            </c:forEach>
            
            
            </c:if>
       
         <c:if test="${ empty AllFeedback}">
            <c:forEach var="Feedback" items="${AllFeedback}">
     
     <tr><td height="24" colspan="6"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
         </c:forEach>
         </c:if>
     
       </table>
       </fieldset>
       
      <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>
                
        
</body></html>








