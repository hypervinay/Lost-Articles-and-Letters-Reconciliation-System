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
import com.post.daoimpl.PostDAOImpl;
import com.post.delegate.PostMgrDelegate;
import com.post.util.UtilConstants;

public class PostManScheduleAction extends HttpServlet {

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


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


	HttpSession hs=request.getSession();
   String path="";
  
   String page="";

PostMgrDelegate pmd=new PostMgrDelegate();

try{
	String login=(String)hs.getAttribute("user");
	  
	  System.out.println("in Action class login is------------->"+login);
	
	Vector<PostTo> vpb=new PostDAOImpl().viewPostSheduleAt(login);
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
