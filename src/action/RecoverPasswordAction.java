package com.post.action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.post.delegate.SecurityMgrDelegate;
import com.post.formbean.Profile;
import com.post.util.LoggerManager;

public class RecoverPasswordAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3226022017953185591L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "./jsps/Recoverpasswordfprm.jsp";
		
		request.setAttribute("status","Entries not Matched... Try Again");
	      try{
	          Profile rb=new Profile();
	          String loginid=request.getParameter("username");
	          String sanswer=request.getParameter("sanswer");
	          rb.setLoginID(loginid);
	          rb.setSecretAnswer(sanswer);
	          String squestid="";
	          String password="";
	          squestid=request.getParameter("squest");
	           if(request.getParameter("ch")!=null)
	          {
	          
	        	   squestid=request.getParameter("ownquest");
	            
	          }
	             
	          
	          rb.setSecretQuestionID(squestid);    
	              password=new SecurityMgrDelegate().recoverPasswordByQuestion(rb);
	          if(password.equals("") || password==null){
	                  target="./jsps/Recoverpassword.jsp";
	              		request.setAttribute("status","Entries not Matched... Try Again");
	          }
	          else{
	             target="./jsps/LoginForm.jsp";
	             request.setAttribute("status","Password is==========>"+password);
	          }
	        }
	        catch(Exception e)
	        {
	           LoggerManager.writeLogSevere(e);
	        }
	        RequestDispatcher rd = request.getRequestDispatcher(target);
	        rd.forward(request,response);
	  
	}

}
