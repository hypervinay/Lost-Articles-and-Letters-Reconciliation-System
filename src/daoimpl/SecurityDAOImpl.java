/*
 * SecurityDAO.java
 *
 * 
 */

package com.post.daoimpl;


import com.post.bdbutil.DBConnectionFactory;
import com.post.bdbutil.SqlConstants;
import com.post.daoI.SecurityDAOI;
import com.post.formbean.Profile;
import com.post.util.DateUtil;
import com.post.util.LoggerManager;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
/**
 *
 * @author 
 */
public class SecurityDAOImpl implements SecurityDAOI
{
     Connection con;
     private String desc;
     private boolean flag;
     ResultSet rs;
     PreparedStatement pstmt;
    /** Creates a new instance of SecurityDAO */
     
     
     
     
    public SecurityDAOImpl() 
    {
       
    	con = DBConnectionFactory.getConnection();
    	
               
    }
    
   
   
    //Login Check
    public String loginCheck(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        System.out.println("in DAO Login user is............."+loginid);
        String password=regbean.getPassword();
        System.out.println("in DAO Login pass is............."+password);
        String role="ee";        
        try
        {   
        	
        	
                 System.out.println("con"+con);
          //  con.setAutoCommit(true);
            CallableStatement cstmt=con.prepareCall(SqlConstants._CHECK_LOGIN);
            cstmt.setString(1,loginid);
            cstmt.setString(2,password);
            cstmt.registerOutParameter(3,Types.VARCHAR);
           boolean flag= cstmt.execute();
           System.out.println("flag->"+flag);
            role=cstmt.getString(3);
            System.out.println("logintype="+role);
            
            
        }
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            desc="Database Connection problem";
            flag=false;
        }
        //loginaudit(loginid,desc);
        return role;
    }
    
    
    //Method for login audit
    public void loginaudit(String loginid)
    {
        try 
        { 
        	
        	
        	
            CallableStatement cstmt=con.prepareCall(SqlConstants._LOGIN_AUDIT);
            cstmt.setString(1,loginid);
            
            System.out.println("in loginaudit");
           cstmt.execute();
           
            con.close();
        }
        catch(Exception e)
        {
             
            e.printStackTrace();
            }
    }
    //Change Password
    public boolean changePassword(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String oldpassword=regbean.getPassword();
        String newpassword=regbean.getNewPassword();
        try 
        {
        	
        	
        	con.setAutoCommit(false);
           
            PreparedStatement cstmt=con.prepareStatement(SqlConstants._CHANGE_PADSSWORD);
            
            
            cstmt.setString(1,newpassword);
            cstmt.setString(2,loginid);
            cstmt.setString(3,oldpassword);
            
          
            int i=cstmt.executeUpdate();
            System.out.println("i="+i);
            if(i==1)
            {
                flag=true;
                con.commit();
            }
            else
            {
                flag=false;
                con.rollback();
            }
            con.close();
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {sex.printStackTrace();
            	LoggerManager.writeLogSevere(sex);
            }
        }
        return flag;        
    }
    
    
     //Change Secret Question
    public boolean changeQuestion(Profile regbean)
    {
        String loginid=regbean.getLoginID();
        String password=regbean.getPassword();
        String secretquestid=regbean.getSecretQuestionID();
        
        String secretans=regbean.getSecretAnswer();
        
        CallableStatement cstmt;
        int i=0;
        try 
        {   
           
            	
            	//con.setAutoCommit(false);
                
               
                cstmt=con.prepareCall(SqlConstants._CHANGE_QUESTION);
            
                cstmt.setString(1,loginid);
                cstmt.setString(2,password);
                cstmt.setString(3,secretquestid);
                cstmt.setString(4,secretans);
                cstmt.registerOutParameter(5,Types.INTEGER); 
                cstmt.execute();
                i=cstmt.getInt(5);
                if(i==1)
                {
                    flag=true;
                    con.commit();
                }
                else
                {
                    flag=false;
                    con.rollback();
                }
           
            con.close();
        }
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
        }
        catch (Exception e) 
        {e.printStackTrace();
        	LoggerManager.writeLogSevere(e);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
            	LoggerManager.writeLogSevere(sex);
            }
        }
        return flag;        
    }
    
     //Recover Password using Existed Question
    public String recoverPasswordByQuestion(Profile regbean)
    {
        String password;
        String loginid=regbean.getLoginID();
        String secretquestid=regbean.getSecretQuestionID();
        String secretans=regbean.getSecretAnswer();
        try 
        {
        	
        	
        	con.setAutoCommit(true); 
            CallableStatement cstmt=con.prepareCall(SqlConstants._RECOVER_PASSWORD);
            cstmt.setString(1,loginid);
            cstmt.setString(2,secretquestid);
            cstmt.setString(3,secretans);
            cstmt.registerOutParameter(4,Types.VARCHAR);           
            cstmt.execute();
            password=cstmt.getString(4);
            con.close();
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            password="";
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
            password="";
        }
        return password;        
    }
    
    
    public String  checkUser(String userName)
    {
 	   String user=null;
 	   System.out.println("username"+userName);
 	   try 
 	   
        {
 		  
        	con.setAutoCommit(true); 
            CallableStatement cstmt=con.prepareCall(SqlConstants._CHECK_USER);
            cstmt.setString(1, userName);
            cstmt.registerOutParameter(2,Types.VARCHAR);           
            cstmt.execute();
            user=cstmt.getString(2);
            con.close();
        } 
        catch (SQLException ex) 
        {ex.printStackTrace();
        	LoggerManager.writeLogSevere(ex);
            user=null;
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
        	user=null;
        }
        return user;        
    }
    
    
    
    public boolean checkAvailability(String userid){
    	boolean flag=false;
    	try{
    		pstmt=con.prepareStatement("select userid from userdetails where loginid=?");
    		pstmt.setString(1, userid);
    		rs=pstmt.executeQuery();
    		if(rs.next()){
    			flag=true;
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return flag;
    }
    
}
   
