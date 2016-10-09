package com.post.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.post.delegate.ProfileMgrDelegate;
import com.post.util.CoreList;
import com.post.util.UtilConstants;

public class GetEmpdetailsAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		String path="";

		  try{
			  
			  String target=request.getRealPath("/userimages");
			  
			  System.out.println("In action  ...................."+target);
			  
			  CoreList cl= new ProfileMgrDelegate().getEmpDetails(target);
			  
			  System.out.println("in action vector isd.................."+cl);
			  
	
			  
			  
			  
			  if(cl!=null)
			  { 
				  request.setAttribute("status", UtilConstants._EMP_INFO);
				  
				  request.setAttribute("EmpInfo", cl);
				  
				  path=UtilConstants._VIEW__EMP_INFO;
				  
				 }
			  else {
				  
                  request.setAttribute("status", UtilConstants._NO__EMP_INFO);
				  
				  path=UtilConstants._VIEW__EMP_INFO;
				
			}
			  
	   }
		  catch (NullPointerException e) {
			  
			e.printStackTrace();
			
			request.setAttribute("status", UtilConstants._INVALID_ENTRIES);
			  
			  path=UtilConstants._VIEW__EMP_INFO;
		}
		
		
		  RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		}

}
