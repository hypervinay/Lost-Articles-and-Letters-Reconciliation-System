package com.post.action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


import com.post.bean.FeedbackTo;
import com.post.delegate.FeedBackMgrDelegate;
import com.post.formbean.FeedBackFormBean;


public class PostFeedBackAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4499130956934643168L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		FeedBackFormBean fb=new FeedBackFormBean();
		
		HttpSession hs=request.getSession();
		hs.setAttribute("feedbackbean", fb);
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(fb, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
		
	}
        String path="";

	  try{
		  
		  FeedbackTo fto=new FeedbackTo(fb);
		  
		  boolean flag= new FeedBackMgrDelegate().insertFeedBack(fto);
		  
		  
		  if(flag==true)
		  {
			  request.setAttribute("status", "U R FeedBack is Posted Successfully");
			  path="./jsps/FeedBack.jsp";
			 }
		  else {
			  request.setAttribute("status", "Posting Of U R FeedBack is Failed");

			  path="./jsps/FeedBack.jsp";
			
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		path="./jsps/FeedBack.jsp?status=Invalid Entries";
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}
}
