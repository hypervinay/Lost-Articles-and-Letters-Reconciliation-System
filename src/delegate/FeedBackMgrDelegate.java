package com.post.delegate;

import java.util.Vector;

import com.post.bean.FeedbackTo;

import com.post.serviceI.FeedBackServiceI;
import com.post.serviceimpl.FeedBackServiceImpl;

public class FeedBackMgrDelegate {
	
	FeedBackServiceI fsi=new FeedBackServiceImpl();
	
	 public boolean insertFeedBack(FeedbackTo fb){
		 
		 return fsi.insertFeedBack(fb);
		 
	 }
	 
	 public Vector<FeedbackTo>  getFeedBack(){
		 
		 return fsi.getFeedBack();
	 }
	 
	 public Vector<FeedbackTo>  getAllFeedBack(int fid1){
		 
		 return fsi.getAllFeedBack(fid1);
		 
	 }
	 
	 public boolean cancelFeedBack(int fid){
		 
		 return fsi.cancelFeedBack(fid);
		 
	 }

}
