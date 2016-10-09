package com.post.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.bean.PostTo;
import com.post.delegate.PostMgrDelegate;
import com.post.util.UtilConstants;

public class ViewPostInfoAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		String path="";

		  try{
			  
			 
			 Vector<PostTo> vpto= new PostMgrDelegate().viewPost();
			 
			  System.out.println("in update post action flag is.......... "+vpto);
			  
			  if(!vpto.isEmpty())
			  {
				  
				  request.setAttribute("status",UtilConstants._POSTAL_INFO );
				  
				  request.setAttribute("PostalInfo", vpto);
				  
				  path=UtilConstants._VIEW_POST_INFO;
				 }
			  else {
				  
                   request.setAttribute("status",UtilConstants._NO_POSTAL_INFO );
				  
				  path=UtilConstants._VIEW_POST_INFO; 
				
			}
			  
	   }
		  catch (NullPointerException e) {
			  
			e.printStackTrace();
			
			
			 request.setAttribute("status",UtilConstants._INVALID_ENTRIES );
			  
			  path=UtilConstants._VIEW_POST_INFO; 
		}
		
		
		  RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
		
		}

}
