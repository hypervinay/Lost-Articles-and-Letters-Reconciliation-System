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

import com.post.delegate.FeedBackMgrDelegate;

import com.post.formbean.FeedBackFormBean;

public class DeleteFeedBackAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4673163120726514980L;


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
		  
		  int fid=Integer.parseInt(request.getParameter("fid"));
		  
		  boolean flag= new FeedBackMgrDelegate().cancelFeedBack(fid);
		  
		  
		  if(flag==true)
		  {
			  
			  path="./ViewFeedbackInfoAction";
			  request.setAttribute("status","U R FeedBack is Cancled Successfully");
			 }
		  else {
			  
			  path="./ViewFeedbackInfoAction?status=Cancilation Of U R FeedBack is Failed";
			
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		path="./jsps/ViewAllFeedBacks.jsp?status=Invalid Entries";
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}
}
