package com.post.serviceI;

import com.post.formbean.Profile;

public interface SecurityServiceI {

	
	public String loginCheck(Profile regbean);
    
 	public void loginaudit(String loginid);

 	public boolean changePassword(Profile regbean);

 	public boolean changeQuestion(Profile regbean);

 	public String recoverPasswordByQuestion(Profile regbean);

 	public String  checkUser(String userName);
}
