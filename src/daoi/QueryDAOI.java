package com.post.daoI;

import java.util.Vector;

import com.post.bean.QueryTo;
import com.post.formbean.QueryFormBean;


public interface QueryDAOI{
	
	public boolean insertQuery(QueryTo qto);
	public Vector<QueryTo> getQueries();
	public Vector<QueryTo> getQueriesAt(int qid1);
  }
