package com.post.action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


import com.post.delegate.PostMgrDelegate;
import com.post.formbean.PostBean;

public class ShedulePostAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5256837267204103722L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		PostBean pb=new PostBean();
		
		HttpSession hs=request.getSession();
		hs.setAttribute("Postbean", pb);
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(pb, map);
	} catch (IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
		
	}
        String path="";

	  try{
		  
		
		  
		  
		  
		  int uid=Integer.parseInt(request.getParameter("post"));
		  
		  System.out.println("in ACtion class Postman Id is...................>"+uid);
		  
		  int pid=Integer.parseInt(request.getParameter("postid"));
		  System.out.println("in action class posytid is............."+pid);
		  
		  boolean flag= new PostMgrDelegate().insertShedulePost(uid,pid);
		  System.out.println("in action vector isd.................."+flag);
		  

		  
		  
		  
		  if(flag)
		  {
			  
			  path="./jsps/ShedulePost.jsp";
			  request.setAttribute("status","Posts R Sheduled Successfully");
			 }
		  else {
			  
			  path="./jsps/ShedulePost.jsp";
			  request.setAttribute("status","Sheduling of Posts is failed");
			
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		path="./jsps/ShedulePost.jsp";
		request.setAttribute("status","Invalid Entries");
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}

		
		
		
		
		
	}

