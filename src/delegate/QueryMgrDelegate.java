package com.post.delegate;

import java.util.Vector;

import com.post.bean.QueryTo;

import com.post.serviceI.QueryServiceI;
import com.post.serviceimpl.QueryServiceImpl;

public class QueryMgrDelegate {

	QueryServiceI qsi=new QueryServiceImpl();
	
	public boolean insertQuery(QueryTo qfb){
		
		return qsi.insertQuery(qfb);
	}
	
	public Vector<QueryTo> getQueries(){
		
		return qsi.getQueries();
		
	}
	public Vector<QueryTo> getQueriesAt(int qid1){
		
		return qsi.getQueriesAt(qid1);
		
	}
	
}
