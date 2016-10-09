
  
<jsp:include page="Header.jsp"></jsp:include>
   
   <form action="PostReport.jsp">
   <table border="1">
    <tr bgcolor="#FFOOCCFFDD"><i> Report Information</i></tr>
    <tr>
    <br/><br/>
     <tr>
     <%
     int postid=Integer.parseInt(request.getParameter("postid"));
     
     String pdate=request.getParameter("pdate");
     String dstatus=request.getParameter("dstatus");
     
     %>
     
     
     
                                <td width="128"><span class="style17"><font color="higblue"><b>PostId</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="postid" value="<%=postid %>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            <tr>
                            
                            <td width="128"><span class="style17"><font color="higblue"><b>PostDate</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="postid" value="<%=pdate%>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            
                            
                            <tr>
                            
                            <td width="128"><span class="style17"><font color="higblue"><b>PostMan</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="login" value="<%=(String)session.getAttribute("user")%>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                             <tr>
                            
                            <td width="128"><span class="style17"><font color="higblue"><b>PostStatus</b></font> </span></td>
                                <td width="269"><label>
                            <input type="text" name="postid" value="<%=dstatus%>" readonly="readonly">
                            </label>
                            </td>
                            </tr>
                            
                             <tr>
                             <td align="right">
                             <input type="submit" name="submit" value="SendReport">
                              </td></tr>
                            
               </table>
               </form>
         
         
               
               
               <br/><br/>
                  <jsp:include page="Footer.jsp"></jsp:include>       
  