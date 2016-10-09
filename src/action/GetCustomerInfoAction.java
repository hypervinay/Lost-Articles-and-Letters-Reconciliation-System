package com.post.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.delegate.ProfileMgrDelegate;
import com.post.util.CoreList;
import com.post.util.UtilConstants;

public class GetCustomerInfoAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		String path="";

		  try{
			  
			  String target=request.getRealPath("/userimages");
			  
			  CoreList cl= new ProfileMgrDelegate().getCustomerDetails(target);
			  
			  System.out.println("in action vector isd.................."+cl);
			  
	
			  
			  
			  
			  if(cl!=null)
			  { 
				  request.setAttribute("status", UtilConstants._CUSTOMER_INFO);
				  
				  request.setAttribute("CustomerInfo", cl);
				  
				  path=UtilConstants._VIEW__CUSTOMER__INFO;
				  
				 }
			  else {
				  
                request.setAttribute("status", UtilConstants._NO__CUSTOMER_INFO);
				  
				  path=UtilConstants._VIEW__CUSTOMER__INFO;
				
			}
			  
	   }
		  catch (Exception e) {
			  
			e.printStackTrace();
			
			request.setAttribute("status", UtilConstants._INVALID_ENTRIES);
			  
			  path=UtilConstants._VIEW__CUSTOMER__INFO;
		}
		
		
		  RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
