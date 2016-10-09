package com.post.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.post.delegate.SecurityMgrDelegate;
import com.post.formbean.Profile;
import com.post.util.UtilConstants;

public class LoginAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3204372587436607934L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

             String target="";
		try
		{HttpSession session=request.getSession();
			Profile rb = new Profile();
			String username = request.getParameter(UtilConstants._USERNAME);
			System.out.println("in login action usernmae is.................."+username);
			rb.setLoginID(username);
			String pass=request.getParameter(UtilConstants._PASSWORD);
			System.out.println("in login action Password is.................."+pass);
			rb.setPassword(pass);
             
			String role = new SecurityMgrDelegate().loginCheck(rb);
			System.out.println("role"+role);

			if (role.equalsIgnoreCase(UtilConstants._ADMIN))
			{
				 request.setAttribute("status", "Welcome To"+username);
					
					target = UtilConstants._ADMIN_HOME;
				
				    session.setAttribute(UtilConstants._LOGIN_USER, username);
					session.setAttribute(UtilConstants._LOGIN__ROLE, role);
					session.setAttribute(UtilConstants._PASSWORD,pass);
					
			}
			else if (role.equalsIgnoreCase(UtilConstants._POSTMAN))
			{
				
				 request.setAttribute("status", "Welcome To"+username);
					
					target = UtilConstants._POSTMAN_HOME;
				
					session.setAttribute(UtilConstants._LOGIN_USER, username);
					session.setAttribute(UtilConstants._LOGIN__ROLE, role);
					session.setAttribute(UtilConstants._PASSWORD,pass);
			}
			else if (role.equalsIgnoreCase(UtilConstants._USER))
			{
				 request.setAttribute("status", "Welcome To"+username);
					
					target = UtilConstants._USER_HOME;
		
				session.setAttribute(UtilConstants._LOGIN_USER, username);
				session.setAttribute(UtilConstants._LOGIN__ROLE, role);
				session.setAttribute(UtilConstants._PASSWORD,pass);
			}
			else if (role.equalsIgnoreCase(UtilConstants._MASTER))
			{
				
				     request.setAttribute("status", "Welcome To"+username);
				
					target = UtilConstants._MASTER_HOME;
				
			
				session.setAttribute(UtilConstants._LOGIN_USER, username);
				session.setAttribute(UtilConstants._LOGIN__ROLE, role);
				session.setAttribute(UtilConstants._PASSWORD,pass);
			}
			else{
				request.setAttribute("status", UtilConstants._INVALID_USER);
				
				target=UtilConstants._LOGIN_HOME;
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
