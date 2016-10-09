package com.post.serviceimpl;

import java.util.Vector;

import com.post.bean.SolutionTo;
import com.post.daoI.SolutionDAOI;
import com.post.daoimpl.SolutionDAOImpl;

import com.post.serviceI.SolutionServiceI;

public class SolutionServiceImpl implements SolutionServiceI{

	
	SolutionDAOI sdao=new SolutionDAOImpl();
	
	
	 public boolean insertSolution(SolutionTo sf){
		 
		 return sdao.insertSolution(sf);
		 
	 }
		
		public Vector<SolutionTo> getQueryStatus(String login){
			
			return sdao.getQueryStatus(login);
			
		}
		
		public Vector<SolutionTo> getSolution(int qid,String login){
			
			
			return sdao.getSolution(qid, login);
			
		}
	
	
	
}
