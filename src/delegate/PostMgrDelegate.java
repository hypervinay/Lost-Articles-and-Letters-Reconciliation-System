package com.post.delegate;

import java.util.Vector;

import com.post.bean.PostTo;


import com.post.serviceI.PostServiceI;

import com.post.serviceimpl.PostalServiceImpl;
import com.post.util.CoreHash;

public class PostMgrDelegate {
	
	
	boolean flag=false;
	
	PostServiceI psi=new PostalServiceImpl();
	
	public boolean AddPostelInfo(PostTo pb){
     return psi.insertPost(pb);
		
	}
	public boolean AddLostArticel(PostTo pb){

	return psi.insertLostPost(pb);
		
	}
	
  public boolean cancelPostRecord(int pid){
		
		return psi.cencelPost(pid);
		
	}
	
	public boolean changeStatus(int pid,String status){
		
		return psi.updateStatus(pid, status);
	}
	
  public boolean addDelivery(PostTo pb){
		return psi.addDevilery(pb);
		
	}
	
  
  public Vector<PostTo> viewPost(){
	  
	  return psi.viewPost();
	  
  }
	
  public Vector<PostTo> viewPostAt(int pid){
	  
	  return psi.viewPostAt(pid);
	  
  }
  
  
  public Vector<PostTo> viewLostPost(){
	  
	  return psi.viewLostPost();
	  
	  
  }
  
  public Vector<PostTo> viewLostPostAt(int pid){
	  
	  
	  return psi.viewLostPostAt(pid);
  }
  
  public boolean updatePost(PostTo pb){
	  
	  return psi.updatePost(pb);
	  
  }

  public boolean updatePostStatus(PostTo pb){
	  
	  return psi.updatePostStatus(pb);
	  
	  
  }
  public Vector<PostTo> getPostMan(int postid){
	  
	  
	  return psi.getPostMan(postid);
	  
  }
  
  public boolean insertShedulePost(int uid,int pid){
	  
	  return psi.insertShedulePost(uid, pid);
	  
  }
  
  public CoreHash postman(int postid){
	  
	  return psi.postman(postid);
	  
	  
  }
  public Vector<PostTo>  viewPostShedule(){
	  
	  return psi.viewPostShedule();
  }
  
  public boolean addDevilery(PostTo pb){
	  
	  return psi.addDevilery(pb);
	  
  }
  
  public Vector<PostTo> viewDelivery(){
	  
	  return psi.viewDelivery();
  }
  
  
  public boolean addComplaint(PostTo pb){
	  
	  
	  return psi.addComplaint(pb);
	  
  }
  
  public Vector<PostTo> viewComplaint(){
	  
	  
	  return psi.viewComplaint();
	  
  }
  
  public boolean updateStatus(int postid, String status){
	  
	  
	  return psi.updateStatus(postid, status);
  }
  
  
  public Vector<PostTo> postmanPost(String login){
	  
	  return psi.postmanPost(login);
  }
  
  
  
  public boolean insertResponse(PostTo pb){
	  
	  return psi.insertResponse(pb);
	  
  }
  
  
  public Vector<PostTo> viewResponse(int compid,String login){
	  
	  return psi.viewResponse(compid, login);
	  
  }
  
  public Vector<PostTo> getComplaintStatus(String login){
	  
	  
	  return psi.getComplaintStatus(login);
	  
  }
  
  
  
}
