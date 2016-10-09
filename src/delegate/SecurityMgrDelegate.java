package com.post.delegate;

import com.post.formbean.Profile;

import com.post.serviceI.SecurityServiceI;

import com.post.serviceimpl.SecurityServiceImpl;

public class SecurityMgrDelegate {
	
	
	boolean flag=false;
	
	SecurityServiceI ssi=new SecurityServiceImpl();
	
	public boolean changePassword(Profile pb)
	{
	return ssi.changePassword(pb);	
	
	}
	
  public boolean changeQuestion(Profile pb)
	{
		return ssi.changeQuestion(pb);
		
		
	}
	public String checkUser(String uname)
	{
		return ssi.checkUser(uname);
		
	}
	
	public String recoverPasswordByQuestion(Profile regbean){
		
		return ssi.recoverPasswordByQuestion(regbean);
		
	}
	
	public void loginaudit(String loginid){
		
		ssi.loginaudit(loginid);
		
	}
	
	public String loginCheck(Profile regbean){
		
		return ssi.loginCheck(regbean);
		
		
	}
	
	

}
