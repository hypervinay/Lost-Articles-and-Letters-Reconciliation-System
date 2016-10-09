package com.post.delegate;

import java.util.Vector;

import com.post.bean.SolutionTo;

import com.post.serviceI.SolutionServiceI;
import com.post.serviceimpl.SolutionServiceImpl;

public class SolutionMgrDelegate {

	
	SolutionServiceI ssi=new SolutionServiceImpl();
	
	
	public boolean insertSolution(SolutionTo sf){
		
		return ssi.insertSolution(sf);
		
	}
	
	public Vector<SolutionTo> getQueryStatus(String login){
		
		return ssi.getQueryStatus(login);
		
	}
	
	public Vector<SolutionTo> getSolution(int qid,String login){
		
		return ssi.getSolution(qid, login);
	}
	
}
