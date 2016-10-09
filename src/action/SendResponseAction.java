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

public class SendResponseAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 721670593341762195L;

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
		  boolean flag= new PostMgrDelegate().insertResponse(pto);
		  
		  
		  if(flag==true)
		  {
			  
			  path="./jsps/adminhome.jsp";
			  request.setAttribute("status","U R Response is Posted Successfully");
			 }
		  else {
			  
			  path="./jsps/adminhome.jsp";
			  request.setAttribute("status","Posting Of U R Response is Failed");
			
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		path="./jsps/adminhome.jsp";
		request.setAttribute("status","Invalid Entries");
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
		
		
		
		
	}

}
