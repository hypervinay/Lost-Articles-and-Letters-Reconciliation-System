package com.post.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.post.bean.PostTo;
import com.post.delegate.PostMgrDelegate;
import com.post.formbean.PostBean;
import com.post.util.UtilConstants;

public class ViewLostArticelInfoAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
		
		String path="";
		
		PostMgrDelegate pmd=new PostMgrDelegate();
		
		try{
			
			Vector<PostTo> vpb=pmd.viewLostPost();
			
			
			if(!vpb.isEmpty()){
				
				request.setAttribute("status", UtilConstants._LOST_ARTICEL_INFO);
				
				request.setAttribute("lostPost", vpb);
				
				path=UtilConstants._VIEW_LOST_ARTICEL;			
			}
			else {
				
				request.setAttribute("status", UtilConstants._NO_LOST_ARTICEL_INFO);
				path=UtilConstants._VIEW_LOST_ARTICEL;
				
			}
			
		}
		catch (NullPointerException e) {
			
			e.printStackTrace();
			
			request.setAttribute("status", UtilConstants._INVALID_ENTRIES);
			path=UtilConstants._VIEW_LOST_ARTICEL;
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
		
		
	}

}
