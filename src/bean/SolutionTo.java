package com.post.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.post.formbean.SolutionFormBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class SolutionTo {

	
	
	private String from;
	private String to;
	private String query;
	private String sdate;
	private String rdate;
    private String	solution;
    private int sid;
    private int qid;
     private int quid;
    private int userid;
   private String status;
   
   
   
   public SolutionTo(){
	   
	   
	   }
   
   
   
   public SolutionTo(SolutionFormBean sfb){
	   
	   
	   try{
			Map  map= BeanUtils.describe(sfb);
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
public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}
public String getSdate() {
	return sdate;
}
public void setSdate(String sdate) {
	this.sdate = sdate;
}
public String getRdate() {
	return rdate;
}
public void setRdate(String rdate) {
	this.rdate = rdate;
}
public String getSolution() {
	return solution;
}
public void setSolution(String solution) {
	this.solution = solution;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public int getQid() {
	return qid;
}
public void setQid(int qid) {
	this.qid = qid;
}
public int getQuid() {
	return quid;
}
public void setQuid(int quid) {
	this.quid = quid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
