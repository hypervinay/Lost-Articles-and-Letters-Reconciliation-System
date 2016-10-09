package com.post.serviceimpl;

import com.post.daoI.SecurityDAOI;
import com.post.daoimpl.SecurityDAOImpl;
import com.post.formbean.Profile;
import com.post.serviceI.SecurityServiceI;

public class SecurityServiceImpl implements SecurityServiceI{
	
	
	SecurityDAOI sdao=new SecurityDAOImpl();
	
public String loginCheck(Profile regbean){
	
	return sdao.loginCheck(regbean);
	
}
    
 	public void loginaudit(String loginid){
 		
 		 sdao.loginaudit(loginid);
 		
 	}

 	public boolean changePassword(Profile regbean){
 		
 		
 		return sdao.changePassword(regbean);
 	}

 	public boolean changeQuestion(Profile regbean){
 		
 		return sdao.changeQuestion(regbean);
 		
 	}

 	public String recoverPasswordByQuestion(Profile regbean){
 		
 		return sdao.recoverPasswordByQuestion(regbean);
 		
 	}

 	public String  checkUser(String userName){
 		
 		
 		return sdao.checkUser(userName);
 	}

}
