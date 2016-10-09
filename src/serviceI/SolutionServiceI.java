package com.post.serviceI;

import java.util.Vector;

import com.post.bean.SolutionTo;
import com.post.formbean.SolutionFormBean;

public interface SolutionServiceI {

	
public boolean insertSolution(SolutionTo sto);
	
	public Vector<SolutionTo> getQueryStatus(String login);
	
	public Vector<SolutionTo> getSolution(int qid,String login);
}
