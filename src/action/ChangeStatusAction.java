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

public class ChangeStatusAction extends HttpServlet {

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
		  
		  int postid=Integer.parseInt(request.getParameter("postid"));
		  
		  String astatus=request.getParameter("astatus");
		  
		  boolean flag= new PostMgrDelegate().changeStatus(postid,astatus);
		  
		  
		  if(flag==true)
		  {
			  
			  path="ViewAllArticels.jsp?status=Status Changed Successfully";
			 }
		  else {
			  
			  path="ViewAllArticels.jsp?status=Changing of Status is Failed ";
			
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		path="ViewAllArticels.jsp?status=Invalid Entries";
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
		
		
		
		
		
		
		
		
	}

}
