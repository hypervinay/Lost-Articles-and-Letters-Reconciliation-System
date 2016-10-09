package com.post.serviceI;

import com.post.formbean.Profile;
import com.post.util.CoreHash;
import com.post.util.CoreList;

public interface ProfileServiceI {
	
	
	public boolean registration(Profile regbean);
	   
	public boolean adminregistration(Profile regbean);

	public Profile getProfile(String loginname,String path);

	public boolean modifyProfile(Profile regbean);

	public CoreHash getReportFromTo(String sdate,String edate);

	public boolean changeAccountStatus(String loginid,int status);

	public CoreList getEmpDetails(String path);

	public CoreList getCustomerDetails(String path);

}
