package com.post.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.bean.PostTo;
import com.post.delegate.PostMgrDelegate;
import com.post.util.UtilConstants;

public class MaintainLostPostAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        String path="";
		
		PostMgrDelegate pmd=new PostMgrDelegate();
		
		try{
			
			Vector<PostTo> lostPost=pmd.viewLostPost();
			
			
			if(!lostPost.isEmpty()){
				
				request.setAttribute("status", UtilConstants._LOST_ARTICEL_INFO);
				
				request.setAttribute("MaintainPost", lostPost);
				
				path=UtilConstants._MAINTAIN_LOST_ARTICEL;			
			}
			else {
				
				request.setAttribute("status", UtilConstants._NO_LOST_ARTICEL_INFO);
				path=UtilConstants._MAINTAIN_LOST_ARTICEL;
				
			}
			
		}
		catch (NullPointerException e) {
			
			e.printStackTrace();
			
			request.setAttribute("status", UtilConstants._INVALID_ENTRIES);
			path=UtilConstants._MAINTAIN_LOST_ARTICEL;
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
	}

}
