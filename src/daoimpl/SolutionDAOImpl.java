package com.post.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Vector;

import com.post.bdbutil.DBConnectionFactory;
import com.post.bdbutil.SqlConstants;
import com.post.bean.SolutionTo;
import com.post.daoI.SolutionDAOI;
import com.post.formbean.QueryFormBean;
import com.post.formbean.SolutionFormBean;
import com.post.util.DateUtil;



public class SolutionDAOImpl implements SolutionDAOI{
	
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs,rs1;
	Connection con;
	
	
	public SolutionDAOImpl(){
		
		
		con=DBConnectionFactory.getConnection();
		
		
	}
	
	
	
	
	
	public boolean insertSolution(SolutionTo sf)
	{
		
		boolean flag=true;
		
		int update=0;
		try{
			
			
			
			
			pstmt=con.prepareStatement(SqlConstants._GIVE_SOLUTION);
			
			int qid=sf.getQid();
			 String sdate=sf.getRdate();
			 System.out.println("in DAo date is..........."+sdate);
			 String solution=sf.getSolution();
			 
			 pstmt.setInt(1, qid);
			 pstmt.setString(2,  sdate);
			 pstmt.setString(3, solution);
			 
			 int insert=pstmt.executeUpdate();
			 
			 
			 if(insert>0)
			 {
				 stmt=con.createStatement();
				update=stmt.executeUpdate("update query set qstatus='solved' where queryid="+qid);
			
				
				 
			 }
			 
			
			
			 if(update>0)
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
			 catch(SQLException e){}
			}
		return flag;
		}

		
		public Vector<SolutionTo> getQueryStatus(String login)
		{
			
			Vector<SolutionTo> vsb=null;
			int uid=0;
		
			
			try{
				
				
				
				
				
				pstmt=con.prepareStatement("select q.queryid,q.userid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),s.solvdate,s.solution ,q.qstatus from query q , solution s ,userdetails c where q.queryid=s.queryid and c.userid=?");
				
                  
				
				System.out.println("in Solution DAo loginid is..........."+login);
				
				stmt=con.createStatement();
				rs1=stmt.executeQuery("select userid from userdetails where loginid="+login);
				
				if(rs1.next()){
					
					uid=rs1.getInt(1);
				}
				
				pstmt.setInt(1,uid);
				
				rs=pstmt.executeQuery();
				
				vsb=new Vector<SolutionTo>();
				while(rs.next())
				{
					
					int qid=rs.getInt(1);
					int quid=rs.getInt(2);
					String description=rs.getString(3);
					String qdate=rs.getString(4);
					String sdate=rs.getString(5);
					String solution=rs.getString(6);
					
					String status=rs.getString(8);
					
					
					SolutionTo sb=new SolutionTo();
					
					sb.setQid(qid);
					sb.setRdate(sdate);
					sb.setSolution(solution);
					sb.setQuery(description);
					sb.setRdate(sdate);
					sb.setRdate(qdate);
					
					sb.setQuid(quid);
					sb.setStatus(status);
					
					vsb.add(sb);
					
				}
				
			}
			catch (SQLException e) {
				// TODO: handle exception
			}
			
			return vsb;
		}
	
	
		
		
		public Vector<SolutionTo> getSolution(int qid,String login)
		{
			
			Vector<SolutionTo> vsb=null;
			
		
			
			try{
				
				
				
				
				
				
				pstmt=con.prepareStatement(SqlConstants._GET_SOLUTION);
				
				
				

			System.out.println("in Dao Class Query id is ........"+qid);
				
				
				pstmt.setInt(1, qid);
				pstmt.setString(2, login);
				System.out.println("in Dao Class login id is ........"+login);
				
				rs=pstmt.executeQuery();
				
				vsb=new Vector<SolutionTo>();
				while(rs.next())
				{
					
					int qid1=rs.getInt(1);
					int quid=rs.getInt(2);
					String description=rs.getString(3);
					String qdate=rs.getString(4);
					String sdate=rs.getString(5);
					String solution=rs.getString(6);
					int userid=rs.getInt(7);
					String status=rs.getString(8);
					
					
					SolutionTo sb=new SolutionTo();
					
					sb.setQid(qid1);
					sb.setRdate(sdate);
					sb.setSolution(solution);
					sb.setQuery(description);
					
					sb.setSdate(qdate);
					sb.setUserid(userid);
					sb.setQuid(quid);
					sb.setStatus(status);
					
					vsb.add(sb);
					
				}
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return vsb;
		}
	
		
		
		
		
}
