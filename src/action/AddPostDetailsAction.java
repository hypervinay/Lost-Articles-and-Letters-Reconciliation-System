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


import com.post.bean.PostTo;
import com.post.delegate.PostMgrDelegate;

import com.post.formbean.PostBean;
import com.post.util.UtilConstants;

public class AddPostDetailsAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2645721197894383948L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PostBean pb=new PostBean();
		
		HttpSession hs=request.getSession();
		hs.setAttribute("Postbean", pb);
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(pb, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
		
	}
        String path="";

	  try{
		  
		  PostTo pto=new PostTo(pb);
		  
		  boolean flag= new PostMgrDelegate().AddPostelInfo(pto);
		  
		  
		  if(flag==true)
		  {
			  request.setAttribute("status","U R PostelDetails r inserted Successfully" );
			  
			  path=UtilConstants._POST_DETAILS;
			 }
		  else {
			  
             request.setAttribute("status","Posting Of U R PostelDetails is Failed" );
			  
			  path=UtilConstants._POST_DETAILS;
			  
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		
		 request.setAttribute("status","Invalid Entries" );
		  
		  path=UtilConstants._POST_DETAILS;
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}

}
