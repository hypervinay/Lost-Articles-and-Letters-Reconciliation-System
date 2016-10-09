package com.post.serviceimpl;

import java.util.Vector;

import com.post.bean.FeedbackTo;
import com.post.daoI.FeedBackDAOI;
import com.post.daoimpl.FeedBackDAOImpl;

import com.post.serviceI.FeedBackServiceI;

public class FeedBackServiceImpl implements FeedBackServiceI{
	
	
	FeedBackDAOI fdaoi=new FeedBackDAOImpl();
	
  public boolean insertFeedBack(FeedbackTo fb){
	
		return fdaoi.insertFeedBack(fb);
	
}
	
	public Vector<FeedbackTo>  getFeedBack(){
		
		
		return fdaoi.getFeedBack();
	}
	
	
	
	public Vector<FeedbackTo>  getAllFeedBack(int fid1){
		
		
		return fdaoi.getAllFeedBack(fid1);
		
	}
	
	public boolean cancelFeedBack(int fid){
		
		return fdaoi.cancelFeedBack(fid);
		
	}

}
