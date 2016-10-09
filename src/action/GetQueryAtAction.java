package com.post.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.bean.QueryTo;
import com.post.delegate.QueryMgrDelegate;
import com.post.util.UtilConstants;


public class GetQueryAtAction extends HttpServlet {

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
		Vector<QueryTo> getqueries=null;
		
		try{
			
			int qid=Integer.parseInt(request.getParameter("qid"));
			
			getqueries=new QueryMgrDelegate().getQueriesAt(qid);
			if(!getqueries.isEmpty()){
				
				request.setAttribute("status",UtilConstants._POST_QUERY_INFO);
				request.setAttribute("QueryAtInfo", getqueries);
				path=UtilConstants._REPLAY_QUERY;
			}
			else{
				request.setAttribute("status",UtilConstants._NO_QUERY);
				path=UtilConstants._REPLAY_QUERY;
			}
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			request.setAttribute("status",UtilConstants._INVALID_ENTRIES);
			path=UtilConstants._REPLAY_QUERY;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		
		rd.forward(request, response);
	}

}
