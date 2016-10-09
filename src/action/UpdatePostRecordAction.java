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

public class UpdatePostRecordAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7711802991815152688L;


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
		  boolean flag= new PostMgrDelegate().updatePost(pto);
		  System.out.println("in update post action flag is.......... "+flag);
		  
		  if(flag==true)
		  {
			  
			  path="./ViewPostInfoAction";
			  request.setAttribute("status","U R PostelDetails r Updated Successfully");
			 }
		  else {
			  
			  path="./ViewPostInfoAction";
			  request.setAttribute("status","Updated Of U R PostelDetails is Failed");
			
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		path="./ViewPostInfoAction";
		request.setAttribute("status","Invalid Entries");
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}
		
		
		
		
		
		
		
		
	}


