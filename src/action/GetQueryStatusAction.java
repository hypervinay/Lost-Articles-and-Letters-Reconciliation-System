package com.post.action;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.post.bean.SolutionTo;

import com.post.delegate.SolutionMgrDelegate;
import com.post.util.UtilConstants;

public class GetQueryStatusAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		Vector<SolutionTo> queriesStatus=null;
		
		try{
			
			HttpSession hs=request.getSession();
			  
			  String login=(String)hs.getAttribute("user");
			 queriesStatus=new SolutionMgrDelegate().getQueryStatus(login);
			if(!queriesStatus.isEmpty()){
				
				request.setAttribute("status",UtilConstants._QUERY_STATUS);
				request.setAttribute("QueryStatus", queriesStatus);
				path=UtilConstants._DISPLAY_QUERY_STATUS;
				
			}
			else{
				request.setAttribute("status","No Queries From u Or U R Query is Not Solved");
				path=UtilConstants._DISPLAY_QUERY_STATUS;
			}
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("status","No Queries From u Or U R Query is Not Solved");
			path=UtilConstants._DISPLAY_QUERY_STATUS;
		}
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
	          rd.forward(request, response);
		
		
		
	}

}
