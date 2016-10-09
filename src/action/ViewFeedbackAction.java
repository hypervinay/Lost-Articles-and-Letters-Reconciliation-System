package com.post.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.bean.FeedbackTo;
import com.post.delegate.FeedBackMgrDelegate;
import com.post.formbean.FeedBackFormBean;
import com.post.util.UtilConstants;

public class ViewFeedbackAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		

		String path="";
		
		
		int fid=Integer.parseInt(request.getParameter("fid"));
		FeedBackMgrDelegate fmd=new FeedBackMgrDelegate();
		
		try{
			
			
			
			Vector<FeedbackTo> vfb=fmd.getAllFeedBack(fid);
			
			if(!vfb.isEmpty()){
				
				request.setAttribute("status", "Here Is U R Feedback Info");
				request.setAttribute("FeedbackAt", vfb);
				
				path=UtilConstants._VIEW_FEEDBACK;
				
				
			}
			else {
				
				
             request.setAttribute("status", "There  Is No Feedbacks ");
				
				path=UtilConstants._VIEW_FEEDBACK;
				
			}
		
		}
		catch (NullPointerException e) {
			
			
			e.printStackTrace();
			
			request.setAttribute("status", "Invalid Entries ");
			
			path=UtilConstants._VIEW_FEEDBACK;
			
			
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
		
	}
		
		
		
	}


