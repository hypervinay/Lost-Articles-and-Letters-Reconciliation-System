package com.post.serviceI;

import java.util.Vector;

import com.post.bean.PostTo;
import com.post.formbean.PostBean;
import com.post.util.CoreHash;

public interface PostServiceI {
	
	

	
public boolean insertPost(PostTo pb);

public boolean insertLostPost(PostTo pb);

public Vector<PostTo> viewPost();

public Vector<PostTo> viewPostAt(int pid);

public Vector<PostTo> viewLostPost();

public Vector<PostTo> viewLostPostAt(int pid);

public boolean cencelPost(int pid);

public boolean updatePost(PostTo pb);

public boolean updatePostStatus(PostTo pb);

public Vector<PostTo> getPostMan(int postid);

public boolean insertShedulePost(int uid,int pid);

public CoreHash postman(int postid);

public Vector<PostTo>  viewPostShedule();

public boolean addDevilery(PostTo pb);

public Vector<PostTo> viewDelivery();

public boolean addComplaint(PostTo pb);

public Vector<PostTo> viewComplaint();

public boolean updateStatus(int postid, String status);

public Vector<PostTo> postmanPost(String login);

public boolean insertResponse(PostTo pb);

public Vector<PostTo> viewResponse(int compid,String login);

public Vector<PostTo> getComplaintStatus(String login);
	

}
