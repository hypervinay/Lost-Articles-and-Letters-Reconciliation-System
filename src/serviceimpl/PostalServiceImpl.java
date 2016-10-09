package com.post.serviceimpl;


import java.util.Vector;


import com.post.bean.PostTo;
import com.post.daoI.PostDAOI;
import com.post.daoimpl.PostDAOImpl;
import com.post.formbean.PostBean;
import com.post.serviceI.PostServiceI;
import com.post.util.CoreHash;


public class PostalServiceImpl implements PostServiceI{
	
	
	PostDAOI pdao=new PostDAOImpl();
	
	
	
	public boolean insertPost(PostTo pb)
	{
		
		return pdao.insertPost(pb);
}
	
	
	
	public boolean insertLostPost(PostTo pb)
	{
		return pdao.insertLostPost(pb);
   }
	
   public Vector<PostTo> viewPost()
	{
		return pdao.viewPost();
		
   }
	
  public Vector<PostTo> viewPostAt(int pid)
	{
		
		
		return pdao.viewPostAt(pid);
		
   }
	
	
	
	
	public Vector<PostTo> viewLostPost()
	{
		
		return pdao.viewLostPost();
}
	
	
	
	
	public Vector<PostTo> viewLostPostAt(int pid)
	{
		
		return pdao.viewLostPostAt(pid);
	}
	
	
	public boolean cencelPost(int pid)
	{
		
		return pdao.cencelPost(pid);
	}
	
	
	public boolean updatePost(PostTo pb)
	{
		
		return pdao.updatePost(pb);
	}
	
	
	
	public boolean updatePostStatus(PostTo pb)
	{
		
		return pdao.updatePostStatus(pb);
		
		}	
		
		
		public boolean insertShedulePost(int uid,int pid)
		{
			
			return pdao.insertShedulePost(uid, pid);
			
		}
		
		public CoreHash postman(int postid)
		{
			return pdao.postman(postid);
	
		}
		
		
		public Vector<PostTo>  viewPostShedule()
		{
			return pdao.viewPostShedule();
			
		}
		
		
	public boolean addDevilery(PostTo pb)
	{
		return pdao.addDevilery(pb);
		
	}
		
	
	
	public Vector<PostTo> viewDelivery()
	{
		return pdao.viewDelivery();
    }
	

	
	public boolean addComplaint(PostTo pb)
	{
		
		return pdao.addComplaint(pb);
	}
	
	
	
	
	public Vector<PostTo> viewComplaint()
	{
		
		return pdao.viewComplaint();
	}
	
	
	
	public boolean updateStatus(int postid, String status)
	{
		
		return pdao.updateStatus(postid, status);
		
	}
		
	
	public Vector<PostTo> postmanPost(String login)
	{
		return pdao.postmanPost(login);
    }
	
	
	
	
	
	public boolean insertResponse(PostTo pb)
	{
		
		return pdao.insertResponse(pb);
		
	}

	public Vector<PostTo> viewResponse(int compid,String login)
	
	{
		
	   return pdao.viewResponse(compid, login);
	}
	
	public Vector<PostTo> getComplaintStatus(String login)
	{
		
	return pdao.getComplaintStatus(login);	
		
	}



	public Vector<PostTo> getPostMan(int postid) {
		
		
		return pdao.getPostMan(postid);
		
	}



	

}
