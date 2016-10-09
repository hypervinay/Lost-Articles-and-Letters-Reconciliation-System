package com.post.delegate;

import com.post.formbean.Profile;
import com.post.serviceI.ProfileServiceI;
import com.post.serviceimpl.ProfileServiceImpl;
import com.post.util.CoreHash;
import com.post.util.CoreList;

public class ProfileMgrDelegate {
	
	
	
	ProfileServiceI psi=new ProfileServiceImpl();
	
	
	
	public boolean registration(Profile regbean){
		
		return psi.registration(regbean);
		
	}
	   
	public boolean adminregistration(Profile regbean){
		
		return psi.adminregistration(regbean);
	}

	public Profile getProfile(String loginname,String path){
		
		return psi.getProfile(loginname, path);
	}

	public boolean modifyProfile(Profile regbean){
		
		return psi.modifyProfile(regbean);
	}

	public CoreHash getReportFromTo(String sdate,String edate){
		
		
		return psi.getReportFromTo(sdate, edate);
	}

	public boolean changeAccountStatus(String loginid,int status){
		
		return psi.changeAccountStatus(loginid, status);
	}

	public CoreList getEmpDetails(String path){
		
		return psi.getEmpDetails(path);
	}

	public CoreList getCustomerDetails(String path){
		
		
		return psi.getCustomerDetails(path);
	}

}
