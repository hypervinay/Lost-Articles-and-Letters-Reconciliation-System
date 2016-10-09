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

import com.post.bean.PostTo;
import com.post.delegate.PostMgrDelegate;
import com.post.formbean.PostBean;
import com.post.util.UtilConstants;

public class DeliveryAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


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
		  
		  PostTo pto=new PostTo(pb);
		  
		  int pid=Integer.parseInt(request.getParameter("postid"));
		  
		  System.out.println("in action class posytid is............."+pid);
		  
		  boolean flag= new PostMgrDelegate().addDelivery(pto);
		  
		  System.out.println("in action vector isd.................."+flag);
		  

		  
		  
		  
		  if(flag)
		  {
			  
			  request.setAttribute("status",UtilConstants._DELEVERY_INFO);
			  
			  path=UtilConstants._DELEVERY_HOME;
			 }
		  else {
			  
           request.setAttribute("status",UtilConstants._NO_DELEVERY_INFO);
			  
			  path=UtilConstants._DELEVERY_HOME;
		}
		  
   }
	  catch (Exception e) {
		e.printStackTrace();
		
		request.setAttribute("status",UtilConstants._INVALID_ENTRIES);
		  
		  path=UtilConstants._DELEVERY_HOME;
	}
	
	
	  RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	
	
	}
		
}

