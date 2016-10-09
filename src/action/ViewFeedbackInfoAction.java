package com.post.action;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.bean.FeedbackTo;
import com.post.delegate.FeedBackMgrDelegate;

import com.post.util.UtilConstants;

public class ViewFeedbackInfoAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -320743747863933459L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
		
		
		
        FeedBackMgrDelegate fmd=new FeedBackMgrDelegate();
		
		try{
			
			Vector<FeedbackTo> vfb=fmd.getFeedBack();
			
			if(!vfb.isEmpty()){
				
				request.setAttribute("status", UtilConstants._VIEW_ALL_FEEDBACKS);
				request.setAttribute("AllFeedback", vfb);
				
				path=UtilConstants._VIEW_ALL_FEEDBACK;
				
				
			}
			else {
				
				
             request.setAttribute("status", UtilConstants._ALL_FEEDBACKS_FAILED);
				
				path=UtilConstants._VIEW_ALL_FEEDBACK;
				
			}
		
		}
		catch (NullPointerException e) {
			
			
			e.printStackTrace();
			
			request.setAttribute("status", UtilConstants._INVALID_ENTRIES);
			
			path=UtilConstants._VIEW_ALL_FEEDBACK;
			
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
		
		
	}

}
