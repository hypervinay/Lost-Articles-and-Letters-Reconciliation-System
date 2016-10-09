package com.post.serviceimpl;

import com.post.daoI.ProfileDAOI;
import com.post.daoimpl.ProfileDAOImpl;
import com.post.formbean.Profile;
import com.post.serviceI.ProfileServiceI;
import com.post.util.CoreHash;
import com.post.util.CoreList;

public class ProfileServiceImpl implements ProfileServiceI{
	
	
	
	ProfileDAOI pdao=new ProfileDAOImpl();
	
	public boolean registration(Profile regbean){
		
		return pdao.registration(regbean);
		
	}
	   
	public boolean adminregistration(Profile regbean){
		
		return pdao.adminregistration(regbean);
		
	}

	public Profile getProfile(String loginname,String path){
		
		return pdao.getProfile(loginname, path);
	}

	public boolean modifyProfile(Profile regbean){
		
		return pdao.modifyProfile(regbean);
		
	}

	public CoreHash getReportFromTo(String sdate,String edate){
		
		return pdao.getReportFromTo(sdate, edate);
		
	}

	public boolean changeAccountStatus(String loginid,int status){
		
		
		return pdao.changeAccountStatus(loginid, status);
	}

	public CoreList getEmpDetails(String path){
		return pdao.getEmpDetails(path);
		
	}

	public CoreList getCustomerDetails(String path){
		
		
		return pdao.getCustomerDetails(path);
	}

}
