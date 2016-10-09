
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html >
<script language="JavaScript1.2">


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
	
	
	
			<center><h2>FeedBack Details</h2></center>
		  <div class="hr"> </div>
          <p></p> 
                    <form  method="post" action="ViewFeedBack" >
                      <fieldset>
                    <table>
      
     
     <c:if test="${not empty FeedbackAt}">
     
     <c:forEach var="Feedback" items="${FeedbackAt}">
     
    
         <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
                  
        <tr><td><div>Message::${Feedback.feedback }</div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        
        <tr><td><div>From:${Feedback.name }</div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        
        <tr><td><div>Occupation:${Feedback.occupation }</div></td></tr>
        <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
    
        </c:forEach>
        </c:if>
        <tr><td><div align="center"><a href="./ViewFeedbackInfoAction">Check FeedBack</a></div></td></tr>
       <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        <tr><td><div align="center"></div></td></tr>
         <tr><td><div align="center"></div></td></tr>
        
       

       </table>
       </fieldset>
       
         <br/><br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
       </form>
         
</body></html>