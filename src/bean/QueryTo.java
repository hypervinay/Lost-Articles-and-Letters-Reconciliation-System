package com.post.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.post.formbean.QueryFormBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class QueryTo {
	
	private int qid;
	private int userid;
	private String query;
	
	private String from;
	private String to;
	
	private String date;
	private String fname;
	private String lname;
	private String status;
	
	
	
	
	public QueryTo(){
		
		
		
		
	}
	
	public QueryTo(QueryFormBean qfb){
		
		
		 try{
				Map  map= BeanUtils.describe(qfb);
				BeanUtils.populate(this, map);
			}
			catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
