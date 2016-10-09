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


import com.post.bean.SolutionTo;
import com.post.delegate.SolutionMgrDelegate;

import com.post.formbean.SolutionFormBean;
import com.post.util.UtilConstants;

public class PostSolutionAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8518030673148133713L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SolutionFormBean sfb=new SolutionFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(sfb, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
		
	}
        String path="";

	  try{
		  
		  
		  SolutionTo sto=new SolutionTo(sfb);
		   boolean flag= new SolutionMgrDelegate().insertSolution(sto);
		  if(flag==true)
		  {
			  request.setAttribute("status",UtilConstants._REPLAY_SUCCESS );
			  path=UtilConstants._REPLAY_QUERY;
		 }
		  else {
			  
			  request.setAttribute("status",UtilConstants._REPLAY_FAILURE );
			  path=UtilConstants._REPLAY_QUERY;
			  }
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("status",UtilConstants._INVALID_ENTRIES );
		  path=UtilConstants._REPLAY_QUERY;
	}
	RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}

}
