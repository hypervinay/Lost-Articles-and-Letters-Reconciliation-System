package com.post.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.post.daoimpl.SecurityDAOImpl;
import com.post.delegate.SecurityMgrDelegate;
import com.post.formbean.Profile;

public class ChekUserAction extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String page=request.getParameter("page");
		System.out.println("in Check action class------------page=====>"+page);
		
		String target = "./jsps/Registerform.jsp?status1=Invalid username and password";
		try
		{
			
			 
			boolean user = new SecurityDAOImpl().checkAvailability(username);

			if (user==false)
			{
				
				request.setAttribute("status1","_/Available");
				target =page;
			}
			
			else
				
			request.setAttribute("status1","Alreadyexist&userName="+username);
			target = page;
		}
		catch (Exception e)
		{
			target = page;
			request .setAttribute("status1","<font color=green>_/<b>Available</b></font>&userName="+username);
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
