<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.post.formbean.SolutionFormBean"%>
<%@page import="com.post.bean.SolutionTo"%>
<%@page import="com.post.delegate.SolutionMgrDelegate"%>

<html>
<head>

  <script type="text/javascript" src="scripts/general.js"> </script>
   <script type="text/javascript" src="scripts/ts_picker.js"> </script>

	<!-- JavaScript variable to set the active Menu -->
	<script type="text/javascript" src="cbanks_files/standard.js"></script>
	<script type="text/javascript">
	<!--
		var primaryMenu = "Central bank hub";
		var secondaryMenu = "Central bank websites";
	// -->
	</script>
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
	
	
			<center><h2>Reply from Admin</h2></center>
		  <div class="hr"> </div>
		  
					  <table width="381" border="1" align="center">
					  
                      <c:if test="${not empty solution}">
                       <c:forEach var="solution" items="${solution}">
                       
                        <tr>
                       
                        <td width="85"><span class="">From</span></td>
              <td width="286"><label>
                            <input type="text" name="from"  size="48" value="${solution.from }" readonly="readonly" />
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class="">To</span></td>
                          <td><label>
                            <input type="text" name="to"  size="48"  value="Administrator" readonly="readonly"/>
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class="">Query</span></td>
                          <td><label>
                            <textarea name="query" cols="45" rows="5" readonly="readonly" >${solution.query }</textarea>
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class="">Send Date</span></td>
                          <td><input type="text" name="sdate" value="${solution.sdate }" readonly="readonly" /></td>
                        </tr>
                        <tr>
                          <td><span class="">Reply Date</span></td>
                          <td><input type="text"  name="rdate" size="48" readonly="readonly" value="${solution.rdate }"/></td>
                        </tr>
                        <tr>
                          <td><span class="">Solution</span></td>
                          <td><textarea name="query2"  cols="45" rows="5"    readonly="readonly"> ${solution.solution }</textarea></td>
                        </tr>
                        <tr>
                          <td colspan="2"><label>
                            <div align="center">
                              <input type="submit"  name="back"  value="back" onclick="javascript:history.back(-1)"/>
                              </div>
                          </label></td>
                        </tr>
                        </c:forEach>
                        </c:if>
                      </table>
                      <c:if test="${ empty solution}">
                       <c:forEach var="solution" items="${solution}">
                       
                       NO Data Found
                       </c:forEach>
                       </c:if>
                     
          
				 <br/><br/>
                   <jsp:include page="Footer.jsp"></jsp:include>
</body></html>
