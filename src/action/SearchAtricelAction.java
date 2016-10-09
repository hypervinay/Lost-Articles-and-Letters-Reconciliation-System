package com.post.action;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


import com.post.bean.PostTo;
import com.post.daoimpl.PostDAOImpl;
import com.post.delegate.PostMgrDelegate;
import com.post.formbean.PostBean;

public class SearchAtricelAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5408286043259831452L;


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
				  
				  int postid=Integer.parseInt(request.getParameter("postid"));
				  
				  System.out.println("in action class postid is........."+postid);
				   
				  Vector<PostTo> vpb=new PostDAOImpl().searchLostPostAt(postid);
				  
			    System.out.println("in action class vpb from database is............."+vpb);
				  
				  
				  
				  
				  if(!vpb.isEmpty())
				  {
					  request.setAttribute("lostvector", vpb);
					  path="./jsps/MasterHome.jsp";
					  request.setAttribute("status","Lost Articel is Found");
					 }
				  else {
					  
					  path="./jsps/MasterHome.jsp";
					  request.setAttribute("status","No Lost Articel is Found ");
					
				}
				  
		   }
			  catch (Exception e) {
				e.printStackTrace();
				path="./jsps/MasterHome.jsp?status=Invalid Entries";
			}
			
			
			  RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
		
		
		
	}

}
