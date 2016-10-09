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
import com.post.util.UtilConstants;

public class CancelPostRecordAction extends HttpServlet {

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

		PostBean pb = new PostBean();

		HttpSession hs = request.getSession();
		hs.setAttribute("Postbean", pb);
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(pb, map);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
		String path = "";

		try {

			int pid = Integer.parseInt(request.getParameter("postid"));

			boolean flag = new PostMgrDelegate().cancelPostRecord(pid);

			if (flag == true) {
				request.setAttribute("status",
						UtilConstants._CANCEL_POST_SUCCESS);
				path = UtilConstants._VIEW_POST_INFO_ACTION;

			} else {

				request.setAttribute("status",
						UtilConstants._CANCEL_POST_FAILED);
				path = UtilConstants._VIEW_POST_INFO_ACTION;

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("status", UtilConstants._INVALID_ENTRIES);
			path = UtilConstants._VIEW_POST_INFO_ACTION;
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
