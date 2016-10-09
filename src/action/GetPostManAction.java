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
import com.post.delegate.PostMgrDelegate;
import com.post.formbean.PostBean;

public class GetPostManAction extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2921042315354490523L;


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
				  
				  int pid=Integer.parseInt(request.getParameter("postid"));
				  System.out.println("in action class posytid is............."+pid);
				  
				  Vector<PostTo> vpb= new PostMgrDelegate().getPostMan(pid);
				  
				  System.out.println("in action vector isd.................."+vpb);
				  
				
				  
				  
				  
				  if(vpb!=null)
				  {
					  
					  path="./jsps/ShedulePost.jsp?status=Get Postmans Details";
					  
					  request.setAttribute("postid", pid);
					  request.setAttribute("PostManVector", vpb);
					  
					 }
				  else {
					  
					  path="./jsps/ShedulePost.jsp?status=No Postmans R Available";
					
				}
				  
		   }
			  catch (Exception e) {
				e.printStackTrace();
				path="./jsps/ShedulePost.jsp?status=Invalid Entries";
			}
			
			
			  RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
			
			
			
			}
		
		
		
		
	}


