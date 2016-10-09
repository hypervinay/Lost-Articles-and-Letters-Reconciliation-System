/*
 * SecurityDAO.java
 *
 * 
 */

package com.post.daoI;


import com.post.formbean.Profile;
/**
 *
 * @author 
 */
public interface SecurityDAOI {
    
	 	public String loginCheck(Profile regbean);
    
	 	public void loginaudit(String loginid);
    
	 	public boolean changePassword(Profile regbean);
    
	 	public boolean changeQuestion(Profile regbean);
    
	 	public String recoverPasswordByQuestion(Profile regbean);
    
	 	public String  checkUser(String userName);
    
}
   
