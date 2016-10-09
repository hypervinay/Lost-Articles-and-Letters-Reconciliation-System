
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	 
	
	
			<center><h2><font color="#share">Response from WareHouseMaster</font></h2></center>
		  <div class="hr"> </div>
		  
					  <table width="381" border="1" align="center">
					  
					  <c:if test="${not empty ResponseInfo}">
                       <c:forEach var="ResponseInfo" items="${ResponseInfo}">
                        <tr>
                       
                       
                       
                       
                       
                    <td width="85"><span class=""><font color="#orange">From</font></span></td>
              <td width="286"><label>
                            <input type="text" name="from"  size="48" value="${ResponseInfo.from }" readonly="readonly" />
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class=""> <font color="#orange">To</font></span></td>
                          <td><label>
                            <input type="text" name="to"  size="48"  value="Master" readonly="readonly"/>
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class=""><font color="#orange">Query</font></span></td>
                          <td><label>
                            <textarea name="query" cols="45" rows="5" readonly="readonly" >${ResponseInfo.description }</textarea>
                          </label></td>
                        </tr>
                        <tr>
                          <td><span class=""><font color="#orange">Complaint Date</font></span></td>
                          <td><input type="text" name="sdate" value="${ResponseInfo.cdate }" readonly="readonly" /></td>
                        </tr>
                        <tr>
                          <td><span class=""><font color="#orange">Reply Date</font></span></td>
                          <td><input type="text"  name="rdate" size="48" readonly="readonly" value="${ResponseInfo.rdate }"/></td>
                        </tr>
                        <tr>
                          <td><span class=""><font color="#orange">Response</font></span></td>
                          <td><textarea name="query2"  cols="45" rows="5"    readonly="readonly">${ResponseInfo.rdescription }</textarea></td>
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
                      
                    
                   <c:if test="${ empty ResponseInfo}">
                       <c:forEach var="ResponseInfo" items="${ResponseInfo}">
                       
                       
                    <center>   <td>NO RECORDS FOUND</td></center>
                       
                       </c:forEach>
                       </c:if>
          
				 <br/><br/>
                 <jsp:include page="Footer.jsp"></jsp:include>
</body></html>
