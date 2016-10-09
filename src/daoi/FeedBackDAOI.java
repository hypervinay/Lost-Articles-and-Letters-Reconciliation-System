package com.post.daoI;

import java.util.Vector;

import com.post.bean.FeedbackTo;



public interface FeedBackDAOI {
	
	public boolean insertFeedBack(FeedbackTo fb);
	
	public Vector<FeedbackTo>  getFeedBack();
	
	public Vector<FeedbackTo>  getAllFeedBack(int fid1);
	
	public boolean cancelFeedBack(int fid);
	
 }
