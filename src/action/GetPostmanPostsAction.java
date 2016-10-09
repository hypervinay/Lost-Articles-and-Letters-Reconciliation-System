package com.post.action;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.post.bean.PostTo;
import com.post.delegate.PostMgrDelegate;
import com.post.util.UtilConstants;

public class GetPostmanPostsAction extends HttpServlet {

	
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

		
		HttpSession hs=request.getSession();
		
		
		
		String path="";
		String page="";

		  try{
			  
			  String login=(String)hs.getAttribute("user");
			  
			  System.out.println("in Action class login is------------->"+login);
			   page=request.getParameter("page");
			 
			 Vector<PostTo> vpto= new PostMgrDelegate().postmanPost(login);
			 
			  System.out.println("in update post action flag is.......... "+vpto);
			  
			  if(!vpto.isEmpty())
			  {
				  
				  request.setAttribute("status",UtilConstants._POSTAL_INFO );
				  
				  request.setAttribute("PostmanPost", vpto);
				  
				  path=page;
				 }
			  else {
				  
                 request.setAttribute("status",UtilConstants._NO_POSTAL_INFO );
				  
				  path=page; 
				
			}
			  
	   }
		  catch (NullPointerException e) {
			  
			e.printStackTrace();
			
			
			 request.setAttribute("status",UtilConstants._INVALID_ENTRIES );
			  
			  path=page; 
		}
		
		
		  RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);	
		
	}

}
