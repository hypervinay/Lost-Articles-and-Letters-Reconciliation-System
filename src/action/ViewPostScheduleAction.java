package com.post.action;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.bean.PostTo;
import com.post.delegate.PostMgrDelegate;

import com.post.util.UtilConstants;

public class ViewPostScheduleAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8509083788104051548L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
           String path="";
          
           String page="";
		
		PostMgrDelegate pmd=new PostMgrDelegate();
		
		try{
			
			Vector<PostTo> vpb=pmd.viewPostShedule();
			System.out.println("in Action class vpto i8s............"+vpb);
			page=request.getParameter("page");
			
			
			if(!vpb.isEmpty()){
				request.setAttribute("status", UtilConstants._SCHEDULE_POST_INFO);
				request.setAttribute("Allpost", vpb);
		        path=page;			
			}
			else {
				request.setAttribute("status", UtilConstants._NO_SCHEDULE_POST_INFO);
				path=page;
				}
			}
		catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("status", UtilConstants._INVALID_ENTRIES);
			path=page;
			}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		}
	}
