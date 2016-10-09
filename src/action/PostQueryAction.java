package com.post.action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import com.post.bean.QueryTo;
import com.post.delegate.QueryMgrDelegate;
import com.post.formbean.QueryFormBean;

public class PostQueryAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1775437872813712744L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QueryFormBean qb=new QueryFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(qb, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
		
	}
        String path="";

	  try{
		  
		  QueryTo qto=new QueryTo(qb);
		  
		  boolean flag= new QueryMgrDelegate().insertQuery(qto);
		  
		  
		  if(flag==true)
		  {
			  
			  path="./jsps/Queries.jsp";
			  request.setAttribute("status","U R Query is Posted Successfully");
			 }
		  else {
			  
			  path="./jsps/Queries.jsp";
			  request.setAttribute("status","Posting Of U R Query is Failed");
			
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		path="./jsps/Queries.jsp";
		request.setAttribute("status","Invalid Entries");
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}
}
