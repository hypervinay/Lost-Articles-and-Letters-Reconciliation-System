package com.post.serviceimpl;

import java.util.Vector;

import com.post.bean.QueryTo;
import com.post.daoI.QueryDAOI;
import com.post.daoimpl.QueryDAOImpl;
import com.post.formbean.QueryFormBean;
import com.post.serviceI.QueryServiceI;

public class QueryServiceImpl implements QueryServiceI{

	
	QueryDAOI qdao=new QueryDAOImpl();
	
	public boolean insertQuery(QueryTo qfb){
		
		return qdao.insertQuery(qfb);
		
	}
	public Vector<QueryTo> getQueries(){
		
		return qdao.getQueries();
		
	}
	public Vector<QueryTo> getQueriesAt(int qid1){
		
		return qdao.getQueriesAt(qid1);
		
	}
}
