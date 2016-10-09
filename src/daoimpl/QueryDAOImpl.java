package com.post.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.post.bdbutil.DBConnectionFactory;
import com.post.bdbutil.SqlConstants;
import com.post.bean.QueryTo;
import com.post.daoI.QueryDAOI;
import com.post.formbean.PostBean;
import com.post.formbean.QueryFormBean;
import com.post.util.DateUtil;


public class QueryDAOImpl implements QueryDAOI{
	
	PreparedStatement pstmt,pstmt1;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	
	public QueryDAOImpl()
	{
		
		con = DBConnectionFactory.getConnection();	
		
	}
	
	
	public boolean insertQuery(QueryTo qfb)
	{
		boolean flag=true;
		int uid=0;
		
		try{
			
			
		
			pstmt=con.prepareStatement(SqlConstants._INSERT_QUERY);
			
			
		String query=qfb.getQuery();
		System.out.println("in Dao query is ......"+query);
		String status="inactive";
		String qdate=qfb.getDate();
		String from=qfb.getFrom();
		
		
		stmt=con.createStatement();
		rs=stmt.executeQuery("select userid from userdetails where loginid="+"'"+from+"'");
		
		if(rs.next())
			
		 uid=rs.getInt(1);
		System.out.println("in DAo from userdetails userid is........"+uid);
		
		pstmt.setInt(1, uid);
		pstmt.setString(2, query);
		pstmt.setString(3, status);
		pstmt.setString(4, qdate);
		
		int insert=pstmt.executeUpdate();
			
			
		if(insert>0)
        {
        
         con.commit();
        }
        else
        {
       	 flag=false;
       	 con.rollback();
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
       catch (SQLException se) 
       {
           se.printStackTrace();
       }
   }
   
   finally
	{
	 try{
		 if(con!=null)
			 con.close();				 
	 }
	 catch(Exception e){}
	}
return flag;
}

	public Vector<QueryTo> getQueries()
	{
		Vector<QueryTo> vqb=null;
		String fname="";
		String lname="";
		
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._GET_QUERY);
			
			rs=pstmt.executeQuery();
			
			 vqb=new Vector<QueryTo>();
			while(rs.next())
			{
				int qid=rs.getInt(1);
				int uid=rs.getInt(2);
				String query=rs.getString(3);
				String status=rs.getString(4);
				String date=rs.getString(5);
				
				stmt=con.createStatement();
				rs1=stmt.executeQuery("select firstname,lastname from userdetails where userid="+uid);
				if(rs1.next())
				 fname=rs1.getString(1);
				 lname=rs1.getString(2);
				
				 QueryTo qf=new QueryTo();
				
				qf.setDate(date);
				qf.setQid(qid);
				qf.setFname(fname);
				qf.setLname(lname);
				qf.setQuery(query);
				qf.setDate(date);
				qf.setStatus(status);
				
				vqb.add(qf);
			}
			
			
			
			
			
		}
		catch (SQLException e) {
			// TODO: handle exception
			
			System.out.println("Exception raised."+e);
		}
		return vqb;
		
		
	}
	
	
	
	public Vector<QueryTo> getQueriesAt(int qid1)
	{
		Vector<QueryTo> vqb=null;
		String fname="";
		String lname="";
		
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._GET_QUERY_AT);
			
			pstmt.setInt(1, qid1);
			rs=pstmt.executeQuery();
			
			 vqb=new Vector<QueryTo>();
			while(rs.next())
			{
				int qid=rs.getInt(1);
				int uid=rs.getInt(2);
				String query=rs.getString(3);
				String status=rs.getString(4);
				String date=rs.getString(5);
				
				stmt=con.createStatement();
				rs1=stmt.executeQuery("select firstname,lastname from userdetails where userid="+uid);
				if(rs1.next())
				 fname=rs1.getString(1);
				 lname=rs1.getString(2);
				
				 QueryTo qf=new QueryTo();
				
				qf.setDate(date);
				qf.setQid(qid);
				qf.setFname(fname);
				qf.setLname(lname);
				qf.setQuery(query);
				qf.setDate(date);
				qf.setStatus(status);
				
				vqb.add(qf);
			}
			
			
			
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Exception raised."+e);
		}
		return vqb;
		
		
	}
	
	

}
