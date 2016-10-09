package com.post.serviceI;

import java.util.Vector;

import com.post.bean.FeedbackTo;


public interface FeedBackServiceI {

  public boolean insertFeedBack(FeedbackTo fb);
	
	public Vector<FeedbackTo>  getFeedBack();
	
	public Vector<FeedbackTo>  getAllFeedBack(int fid1);
	
	public boolean cancelFeedBack(int fid);
	
	
	
}
