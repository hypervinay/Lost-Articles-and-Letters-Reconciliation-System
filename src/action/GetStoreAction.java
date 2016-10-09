package com.post.action;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.bean.PostTo;
import com.post.daoimpl.PostDAOImpl;
import com.post.delegate.PostMgrDelegate;
import com.post.util.UtilConstants;

public class GetStoreAction extends HttpServlet {

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

		  try{
			  int pid=Integer.parseInt(request.getParameter("postid"));
			  System.out.println("in Get Post Info Pid is................>"+pid);
			  Vector<PostTo> PostInfo= new PostDAOImpl().getLostPostAt(pid);
			  System.out.println("in update post action flag is.......... "+PostInfo);
			  if(!PostInfo.isEmpty())
			  {
				  request.setAttribute("status",UtilConstants._POSTAL_INFO );
				  request.setAttribute("LostPost", PostInfo);
				  path=UtilConstants._STORE_POSTAL_INFO;
				 }
			  else {
				  request.setAttribute("status",UtilConstants._NO_POSTAL_INFO );
				  path=UtilConstants._STORE_POSTAL_INFO;
				  }
			  }
		  catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status",UtilConstants._INVALID_ENTRIES );
			path=UtilConstants._STORE_POSTAL_INFO;
		}
		  RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);
	}
	}
