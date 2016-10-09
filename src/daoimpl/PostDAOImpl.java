package com.post.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;



import com.post.bdbutil.DBConnectionFactory;
import com.post.bdbutil.SqlConstants;
import com.post.bean.PostTo;

import com.post.daoI.PostDAOI;
import com.post.formbean.PostBean;
import com.post.util.CoreHash;
import com.post.util.DateUtil;
import com.post.util.LoggerManager;

public class PostDAOImpl implements PostDAOI{
	
	
	
	public PostDAOImpl()
	{
		
		con = DBConnectionFactory.getConnection();	
		
		
	}
	
	PreparedStatement pstmt,pstmt1,pstmt2,pstmt3;
	Statement stmt;
	ResultSet rs,rs1,rs2;
	Connection con;
	
	
	
	public boolean insertPost(PostTo pb)
	{
		boolean flag=true;
		
        
        try{
        	
		
          pstmt=con.prepareStatement(SqlConstants._INSERT_POST);
        	
        	
        String pitem=pb.getPitem();
		String ptype=pb.getPtype();
		String pdate=pb.getPdate();
		String plocation=pb.getPlocation();
		String sname=pb.getSname();
		String shno=pb.getShouseno();
		String slocation=pb.getSlocation();
		String scity=pb.getScity();
		String sstate=pb.getSstate();
		String scountry=pb.getScountry();
	     int spin=pb.getSpin();
		String rname=pb.getRname();
		String rhno=pb.getRhouseno();
		String rlocation=pb.getRlocation();
		String rcity=pb.getRcity();
		String rstate=pb.getRstate();
		String rcountry=pb.getRcountry();
		int rpin=pb.getRpin();
		
		pstmt.setString(1, pitem);
		pstmt.setString(2, ptype);
		pstmt.setString(3, DateUtil.parseDate(pdate));
		pstmt.setString(4, plocation);
		pstmt.setString(5, sname);
		pstmt.setString(6, shno);
		pstmt.setString(7, slocation);
		pstmt.setString(8, scity);
		pstmt.setString(9, sstate);
		pstmt.setString(10, scountry);
		pstmt.setInt(11, spin);
		pstmt.setString(12, rname);
		pstmt.setString(13, rhno);
		pstmt.setString(14, rlocation);
		pstmt.setString(15, rcity);
		pstmt.setString(16, rstate);
		pstmt.setString(17, rcountry);
		pstmt.setInt(18, rpin);
		pstmt.setString(19, null);
		pstmt.setString(20, "pending");
		
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
   
   catch (SQLException e) 
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
	
	
	
	public boolean insertLostPost(PostTo pb)
	{
		boolean flag=true;
		
        
        try{
        	
		
          pstmt=con.prepareStatement(SqlConstants._INSERT_LoST_POST);
        	
        int postid=pb.getPostid();	
        String pitem=pb.getPitem();
		String ptype=pb.getPtype();
		String pdate=pb.getPdate();
		String plocation=pb.getPlocation();
		String sname=pb.getSname();
		String shno=pb.getShouseno();
		String slocation=pb.getSlocation();
		String scity=pb.getScity();
		String sstate=pb.getSstate();
		String scountry=pb.getScountry();
	     int spin=pb.getSpin();
		String rname=pb.getRname();
		String rhno=pb.getRhouseno();
		String rlocation=pb.getRlocation();
		String rcity=pb.getRcity();
		String rstate=pb.getRstate();
		String rcountry=pb.getRcountry();
		int rpin=pb.getRpin();
		
		pstmt.setString(1, pitem);
		
		pstmt.setString(2, DateUtil.parseDate(pdate));
		pstmt.setString(3, plocation);
		pstmt.setString(4, sname);
		pstmt.setString(5, shno);
		pstmt.setString(6, slocation);
		pstmt.setString(7, scity);
		pstmt.setString(8, sstate);
		pstmt.setString(9, scountry);
		pstmt.setInt(10, spin);
		pstmt.setString(11, rname);
		pstmt.setString(12, rhno);
		pstmt.setString(13, rlocation);
		pstmt.setString(14, rcity);
		pstmt.setString(15, rstate);
		pstmt.setString(16, rcountry);
		pstmt.setInt(17, rpin);
		pstmt.setString(18, "notfound");
		pstmt.setString(19, ptype);
		pstmt.setInt(20, postid);
		
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
   
   catch (SQLException e) 
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
	
	
	
	
	public Vector<PostTo> viewPost()
	{
		
		Vector<PostTo> vpb=null;
		
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._VIEW_POST);
			
			rs=pstmt.executeQuery();
			vpb=new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int postid=rs.getInt(1);
				String pitem=rs.getString(2);
				String ptype=rs.getString(3);
				String pdate=rs.getString(4);
				String plocation=rs.getString(5);
				String sname=rs.getString(6);
				String shno=rs.getString(7);
				String slocation=rs.getString(8);
				String scity=rs.getString(9);
				String sstate=rs.getString(10);
				String scountry=rs.getString(11);
				int spin=rs.getInt(12);
				String rname=rs.getString(13);
				String rhno=rs.getString(14);
				String rlocation=rs.getString(15);
				String rcity=rs.getString(16);
				String rstate=rs.getString(17);
				String rcountry=rs.getString(18);
				int rpin=rs.getInt(19);
				String dstatus=rs.getString(20);
				
				PostTo pb=new PostTo();
				
				
				pb.setPdate(pdate);
				pb.setPitem(pitem);
				pb.setPlocation(plocation);
				pb.setPostid(postid);
				pb.setPtype(ptype);
				pb.setScity(scity);
				pb.setScountry(scountry);
				pb.setShouseno(shno);
				pb.setSlocation(slocation);
				pb.setSname(sname);
				pb.setSpin(spin);
				pb.setSstate(sstate);
				pb.setRcity(rcity);
				pb.setRcountry(rcountry);
				pb.setRhouseno(rhno);
				pb.setRlocation(rlocation);
				pb.setRname(rname);
				pb.setRpin(rpin);
				pb.setRstate(rstate);
				pb.setDstatus(dstatus);
				vpb.add(pb);
				
				
			}
			
	}
     catch (SQLException e) {
      e.printStackTrace();
     }		
		
		
		
		return vpb;
}
	

	
	
	
	
	
	
	
	
	public Vector<PostTo> viewPostAt(int pid)
	{
		
		Vector<PostTo> vpb=null;
		
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._VIEW_POST_AT);
			
			pstmt.setInt(1, pid);
			
			rs=pstmt.executeQuery();
			vpb=new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int postid=rs.getInt(1);
				String pitem=rs.getString(2);
				String ptype=rs.getString(3);
				String pdate=rs.getString(4);
				String plocation=rs.getString(5);
				String sname=rs.getString(6);
				String shno=rs.getString(7);
				String slocation=rs.getString(8);
				String scity=rs.getString(9);
				String sstate=rs.getString(10);
				String scountry=rs.getString(11);
				int spin=rs.getInt(12);
				String rname=rs.getString(13);
				String rhno=rs.getString(14);
				String rlocation=rs.getString(15);
				String rcity=rs.getString(16);
				String rstate=rs.getString(17);
				String rcountry=rs.getString(18);
				int rpin=rs.getInt(19);
				
				
				PostTo pb=new PostTo();
				
				
				pb.setPdate(pdate);
				pb.setPitem(pitem);
				pb.setPlocation(plocation);
				pb.setPostid(postid);
				pb.setPtype(ptype);
				pb.setScity(scity);
				pb.setScountry(scountry);
				pb.setShouseno(shno);
				pb.setSlocation(slocation);
				pb.setSname(sname);
				pb.setSpin(spin);
				pb.setSstate(sstate);
				pb.setRcity(rcity);
				pb.setRcountry(rcountry);
				pb.setRhouseno(rhno);
				pb.setRlocation(rlocation);
				pb.setRname(rname);
				pb.setRpin(rpin);
				pb.setRstate(rstate);
				
				vpb.add(pb);
				
				
			}
			
	}
     catch (SQLException e) {
      e.printStackTrace();
     }		
		
		
		
		return vpb;
}
	
	
	
	
	public Vector<PostTo> viewLostPost()
	{
		
		Vector<PostTo> vpb=null;
		
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._VIEW_LoST_POST);
			
			
			pstmt.setString(1, "pending");
			rs=pstmt.executeQuery();
			vpb=new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int postid=rs.getInt(1);
				String pitem=rs.getString(2);
				String ptype=rs.getString(3);
				String pdate=rs.getString(4);
				String plocation=rs.getString(5);
				String sname=rs.getString(6);
				String shno=rs.getString(7);
				String slocation=rs.getString(8);
				String scity=rs.getString(9);
				String sstate=rs.getString(10);
				String scountry=rs.getString(11);
				int spin=rs.getInt(12);
				String rname=rs.getString(13);
				String rhno=rs.getString(14);
				String rlocation=rs.getString(15);
				String rcity=rs.getString(16);
				String rstate=rs.getString(17);
				String rcountry=rs.getString(18);
				int rpin=rs.getInt(19);
				String dstatus=rs.getString(20);
				
				PostTo pb=new PostTo();
				
				
				pb.setPdate(pdate);
				pb.setPitem(pitem);
				pb.setPlocation(plocation);
				pb.setPostid(postid);
				pb.setPtype(ptype);
				pb.setScity(scity);
				pb.setScountry(scountry);
				pb.setShouseno(shno);
				pb.setSlocation(slocation);
				pb.setSname(sname);
				pb.setSpin(spin);
				pb.setSstate(sstate);
				pb.setRcity(rcity);
				pb.setRcountry(rcountry);
				pb.setRhouseno(rhno);
				pb.setRlocation(rlocation);
				pb.setRname(rname);
				pb.setRpin(rpin);
				pb.setRstate(rstate);
				pb.setDstatus(dstatus); 
				
				vpb.add(pb);
				
				
			}
			
	}
     catch (SQLException e) {
      e.printStackTrace();
     }		
		
		
		
		return vpb;
}
	
	
	
	
	public Vector<PostTo> searchLostPostAt(int pid)
	{
		
		Vector<PostTo> vpb=null;
		
		try{
			
			
			pstmt=con.prepareStatement("select postid,articeltype,posttype,TO_CHAR(postdate,'DD-MM-YYYY') from lostarticel where postid=? and articelstatus=? ");
			
			pstmt.setInt(1, pid);
			pstmt.setString(2, "notfound");
			
			rs=pstmt.executeQuery();
			vpb=new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int postid=rs.getInt(1);
				String pitem=rs.getString(2);
				String ptype=rs.getString(3);
				String pdate=rs.getString(4);
				
				
				PostTo pb=new PostTo();
				
				
				pb.setPdate(pdate);
				pb.setPitem(pitem);
				
				
				vpb.add(pb);
				
				int update=0;
				int modify=0;
				
				
				if(!vpb.isEmpty()){
					
					pstmt1=con.prepareStatement("update lostarticel set articelstatus=? where postid=?");
					
					pstmt1.setString(1, "found");
					pstmt1.setInt(2, pid);
					
					 update=pstmt1.executeUpdate();
					 
					 System.out.println("in Search Row updated in Lostarticel---------->"+update);
					
				}
				if(update>0){
					
					pstmt2=con.prepareStatement("update posteldetails set deliverystatus=? where postid=?");
					pstmt2.setString(1, "delivered");
					pstmt2.setInt(2, pid);
					
					modify=pstmt2.executeUpdate();
					 System.out.println("in Search Row updated in PostelDetails---------->"+modify);
					
				}
				if(modify>0){
					
					
					pstmt3=con.prepareStatement("update complaint set status=? where postid=? ");
					pstmt3.setString(1, "found");
					pstmt3.setInt(2, pid);
					int change=pstmt3.executeUpdate();
					System.out.println("in Search Row updated in Complaint---------->"+change);
					
				}
				
				
			}
	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vpb;
	}
	
	
	public Vector<PostTo> viewLostPostAt(int pid)
	{
		
		Vector<PostTo> vpb=null;
		
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._VIEW_LoST_POST_AT);
			
			pstmt.setInt(1, pid);
			pstmt.setString(2, "notfound");
			
			rs=pstmt.executeQuery();
			vpb=new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int postid=rs.getInt(1);
				String pitem=rs.getString(2);
				String ptype=rs.getString(3);
				String pdate=rs.getString(4);
				String plocation=rs.getString(5);
				String sname=rs.getString(6);
				String shno=rs.getString(7);
				String slocation=rs.getString(8);
				String scity=rs.getString(9);
				String sstate=rs.getString(10);
				String scountry=rs.getString(11);
				int spin=rs.getInt(12);
				String rname=rs.getString(13);
				String rhno=rs.getString(14);
				String rlocation=rs.getString(15);
				String rcity=rs.getString(16);
				String rstate=rs.getString(17);
				String rcountry=rs.getString(18);
				int rpin=rs.getInt(19);
				String astatus=rs.getString(20);
				
				PostTo pb=new PostTo();
				
				
				pb.setPdate(pdate);
				pb.setPitem(pitem);
				pb.setPlocation(plocation);
				pb.setPostid(postid);
				pb.setPtype(ptype);
				pb.setScity(scity);
				pb.setScountry(scountry);
				pb.setShouseno(shno);
				pb.setSlocation(slocation);
				pb.setSname(sname);
				pb.setSpin(spin);
				pb.setSstate(sstate);
				pb.setRcity(rcity);
				pb.setRcountry(rcountry);
				pb.setRhouseno(rhno);
				pb.setRlocation(rlocation);
				pb.setRname(rname);
				pb.setRpin(rpin);
				pb.setRstate(rstate);
				pb.setAstatus(astatus);
				
				vpb.add(pb);
				
				
			}
	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vpb;
	}
	
	
	public Vector<PostTo> getLostPostAt(int pid)
	{
		
		Vector<PostTo> vpb=null;
		
		try{
			
			
			pstmt=con.prepareStatement("select postid,postitem,posttype,TO_CHAR(postdate,'DD-MM-YYYY'),postlocation,sname,shouseno,slocation,scity,sstate,scountry,spin,rname,rhouseno,rlocation,rcity,rstate,rcountry,rpin,deliverystatus from posteldetails where postid=? and deliverystatus=? ");
			
			pstmt.setInt(1, pid);
			pstmt.setString(2, "pending");
			
			rs=pstmt.executeQuery();
			vpb=new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int postid=rs.getInt(1);
				String pitem=rs.getString(2);
				String ptype=rs.getString(3);
				String pdate=rs.getString(4);
				String plocation=rs.getString(5);
				String sname=rs.getString(6);
				String shno=rs.getString(7);
				String slocation=rs.getString(8);
				String scity=rs.getString(9);
				String sstate=rs.getString(10);
				String scountry=rs.getString(11);
				int spin=rs.getInt(12);
				String rname=rs.getString(13);
				String rhno=rs.getString(14);
				String rlocation=rs.getString(15);
				String rcity=rs.getString(16);
				String rstate=rs.getString(17);
				String rcountry=rs.getString(18);
				int rpin=rs.getInt(19);
				String astatus=rs.getString(20);
				
				PostTo pb=new PostTo();
				
				
				pb.setPdate(pdate);
				pb.setPitem(pitem);
				pb.setPlocation(plocation);
				pb.setPostid(postid);
				pb.setPtype(ptype);
				pb.setScity(scity);
				pb.setScountry(scountry);
				pb.setShouseno(shno);
				pb.setSlocation(slocation);
				pb.setSname(sname);
				pb.setSpin(spin);
				pb.setSstate(sstate);
				pb.setRcity(rcity);
				pb.setRcountry(rcountry);
				pb.setRhouseno(rhno);
				pb.setRlocation(rlocation);
				pb.setRname(rname);
				pb.setRpin(rpin);
				pb.setRstate(rstate);
				pb.setAstatus(astatus);
				
				vpb.add(pb);
				
				
			}
	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vpb;
	}
	
	
	public boolean cencelPost(int pid)
	{
		boolean flag=true;
		
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._CANCEL_POST);
			
			pstmt.setInt(1, pid);
			
			int delete=pstmt.executeUpdate();
			
			
			
			
			if(delete>0)
	        {
	        
	         con.commit();
	        }
	        else
	        {
	       	 flag=false;
	       	 con.rollback();
	        }

	   } 
	   
	   catch (SQLException e) 
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
	
	
	public boolean updatePost(PostTo pb)
	{
		boolean flag=true;
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._UPDATE_POST);
			
			
			String pitem=pb.getPitem();
			String ptype=pb.getPtype();
			String pdate=pb.getPdate();
			String plocation=pb.getPlocation();
			String sname=pb.getSname();
			String shno=pb.getShouseno();
			String slocation=pb.getSlocation();
			String scity=pb.getScity();
			String sstate=pb.getSstate();
			String scountry=pb.getScountry();
		     int spin=pb.getSpin();
			String rname=pb.getRname();
			String rhno=pb.getRhouseno();
			String rlocation=pb.getRlocation();
			String rcity=pb.getRcity();
			String rstate=pb.getRstate();
			String rcountry=pb.getRcountry();
			int rpin=pb.getRpin();
			int pid=pb.getPostid();
			
			System.out.println("in Update dao postid is........"+pid);
			
			pstmt.setString(1, pitem);
			pstmt.setString(2, ptype);
			pstmt.setString(3, DateUtil.parseDate(pdate));
			pstmt.setString(4, plocation);
			pstmt.setString(5, sname);
			pstmt.setString(6, shno);
			pstmt.setString(7, slocation);
			pstmt.setString(8, scity);
			pstmt.setString(9, sstate);
			pstmt.setString(10, scountry);
			pstmt.setInt(11, spin);
			pstmt.setString(12, rname);
			pstmt.setString(13, rhno);
			pstmt.setString(14, rlocation);
			pstmt.setString(15, rcity);
			pstmt.setString(16, rstate);
			pstmt.setString(17, rcountry);
			pstmt.setInt(18, rpin);
			pstmt.setInt(19, pid);
			
			
			int update=pstmt.executeUpdate();
			
			
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
	   
	   catch (SQLException e) 
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
	
	
	
	public boolean updatePostStatus(PostTo pb)
	{
		
		boolean flag=true;
		try{
			
			pstmt=con.prepareStatement(SqlConstants._UPDATE_POST_STATUS);
			
			
			int pid=pb.getPostid();
			String ddate=pb.getDdate();
			String dstatus=pb.getDstatus();
			
			pstmt.setString(1, DateUtil.parseDate(ddate));
			pstmt.setString(2, dstatus);
			pstmt.setInt(3, pid);
			
			int update=pstmt.executeUpdate();
			
			
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
	   
	   catch (SQLException e) 
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
	
	public Vector<PostTo> getPostMan(int postid)
	{
		
	Vector<PostTo> vpb=null;
	String location="";
	try{
		
		
		pstmt=con.prepareStatement(SqlConstants._GET_POSTMAN);
		
		 System.out.println("in DAo class posytid is............."+postid);
		
		stmt=con.createStatement();
		rs=stmt.executeQuery("select rlocation from posteldetails where postid="+postid);
		
		if(rs.next())
		{
			
			 location=rs.getString(1);
		}
      pstmt.setString(1, "postman");
	  pstmt.setString(2, location);	
		
		rs1=pstmt.executeQuery();
		vpb=new Vector<PostTo>();
		
		while(rs1.next())
		{
			
			int userid=rs1.getInt(1);
			String fname=rs1.getString(2);
			String lname=rs1.getString(3);
			
			
			PostTo pb=new PostTo();
			
			pb.setUserid(userid);
			pb.setFname(fname);
			pb.setLname(lname);
			
			
			vpb.add(pb);
			
	}
	
}
	catch (SQLException e) {
		e.printStackTrace();
	}
		return vpb;
		
		
	}	
		
		
		public boolean insertShedulePost(int uid,int pid)
		{
			boolean flag=true;
			
			
			try{
				
			
				pstmt=con.prepareStatement(SqlConstants._POST_SCHEDULE);
				
				
				pstmt.setInt(1, pid);
				pstmt.setInt(2, uid);
				
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
		   
		   catch (SQLException e) 
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
		
		public CoreHash postman(int postid)
		{
			CoreHash aCoreHash = new CoreHash();
			aCoreHash.clear();
	
			int categoryid;
			Statement st;
			String location="";
			try {
				
				
				
				System.out.println("in DAo class posytid is............."+postid);
				
				stmt=con.createStatement();
				rs=stmt.executeQuery("select rlocation from posteldetails where postid="+postid);
				
				if(rs.next())
				{
					
					 location=rs.getString(1);
				}
				
				pstmt=con.prepareStatement(SqlConstants._SELECT_POSTMAN);
				
				 pstmt.setString(1, "postman");
				  pstmt.setString(2, location);	
					
					rs1=pstmt.executeQuery();
				
				
				while(rs1.next())
				{			
					int userid=rs1.getInt(1);
					String fname=rs1.getString(2);
					String lname=rs1.getString(3);
					
					
					
					
					aCoreHash.put("uid",userid);
					aCoreHash.put("first",fname);
					aCoreHash.put("last",lname);
				}
			} 
			catch (SQLException e)
			{
				LoggerManager.writeLogWarning(e);
			}
			finally
	    	{
	    		try
	    		{
	    			con.close();
	    		}
	    		catch(SQLException se)
	    		{
	    			LoggerManager.writeLogWarning(se);
	    		}
	    	}
			return aCoreHash;
	
		}
		
		
		public Vector<PostTo>  viewPostShedule()
		{
			
			Vector<PostTo> vpb=null;
			String rlocation="";
			String ulocation="";
			try{
				
				pstmt=con.prepareStatement(SqlConstants._VIEW_POST_SCHEDULE);
				
				rs=pstmt.executeQuery();
				vpb=new Vector<PostTo>();
				
				while(rs.next())
				{
					
					int sid=rs.getInt(1);
					int postid=rs.getInt(2);
					int userid=rs.getInt(3);
					String date=rs.getString(4);
					String status=rs.getString(5);
					
					System.out.println("in dao status is........"+status);
					
					stmt=con.createStatement();
					rs1=stmt.executeQuery("select rlocation from posteldetails where postid="+postid);
					if(rs1.next())
					{
						
						rlocation=rs1.getString(1);		
					}
					
					pstmt1=con.prepareStatement("select street from addresses where userid=?");
					pstmt1.setInt(1, userid);
					
					rs2=pstmt1.executeQuery();
					if(rs2.next())
					{
						
						 ulocation=rs2.getString(1);
						
					}
					
					PostTo pb=new PostTo();
					
					
					pb.setRlocation(rlocation);
					pb.setPostid(postid);
					pb.setUserid(userid);
					pb.setUlocation(ulocation);
					pb.setSdate(date);
					pb.setSheduleid(sid);
					pb.setSstate(status);
					
					vpb.add(pb);
					
				}
				
	}
		catch (SQLException e) {
		e.printStackTrace();
		}	
					
		return vpb;	
			
}
		
		
		
		public Vector<PostTo>  viewPostSheduleAt(String login)
		{
			
			Vector<PostTo> vpb=null;
			String rlocation="";
			String ulocation="";
			try{
				
				pstmt=con.prepareStatement("select sid,postid,userid,TO_CHAR(sdate,'DD-MM-YYYY'),status from shedulepost where userid in(select userid from userdetails where loginid=?)");
				
				
				
				pstmt.setString(1, login);
				rs=pstmt.executeQuery();
				vpb=new Vector<PostTo>();
				
				while(rs.next())
				{
					
					int sid=rs.getInt(1);
					int postid=rs.getInt(2);
					int userid=rs.getInt(3);
					String date=rs.getString(4);
					String status=rs.getString(5);
					
					System.out.println("in dao status is........"+status);
					
					stmt=con.createStatement();
					rs1=stmt.executeQuery("select rlocation from posteldetails where postid="+postid);
					if(rs1.next())
					{
						
						rlocation=rs1.getString(1);		
					}
					
					pstmt1=con.prepareStatement("select street from addresses where userid=?");
					pstmt1.setInt(1, userid);
					
					rs2=pstmt1.executeQuery();
					if(rs2.next())
					{
						
						 ulocation=rs2.getString(1);
						
					}
					
					PostTo pb=new PostTo();
					
					
					pb.setRlocation(rlocation);
					pb.setPostid(postid);
					pb.setUserid(userid);
					pb.setUlocation(ulocation);
					pb.setSdate(date);
					pb.setSheduleid(sid);
					pb.setSstate(status);
					
					vpb.add(pb);
					
				}
				
	}
		catch (SQLException e) {
		e.printStackTrace();
		}	
					
		return vpb;	
			
}
	public boolean addDevilery(PostTo pb)
	{
		
		boolean flag=true;
		int userid=0;
		try{
		
		pstmt=con.prepareStatement(SqlConstants._ADD_DELEVERY);
			
		int postid=pb.getPostid();
		
		
		
		
		
		String login=pb.getLogin();
		
		pstmt1=con.prepareStatement(SqlConstants._SELECT_USER);
		
		pstmt1.setString(1, login);
		rs=pstmt1.executeQuery();
		
		if(rs.next())
		{
			
	 userid=rs.getInt(1);
			
			
		}
		
		pstmt.setInt(1, postid);
		pstmt.setInt(2, userid);
		pstmt.setString(3, "deliveried");	
			
		int insert=pstmt.executeUpdate();
		int update=0;
		int modify=0;
		
		
             if(insert>0){
			
			pstmt3=con.prepareStatement("update posteldetails set deliverystatus='deliveried',deliverydate=sysdate where postid=?");
			
			pstmt3.setInt(1, postid);
			
			 update=pstmt3.executeUpdate();
			System.out.println("in dao Status is changed.in PostelDetails...."+update);
			
		}
		
         if(update>0){
			
			pstmt2=con.prepareStatement("update shedulepost set status='deliveried' where postid=?");
			
			pstmt2.setInt(1, postid);
			
			 modify=pstmt2.executeUpdate();
			System.out.println("in dao Status is changed.in ShedulePost...."+modify);
			
		}
		
		
		
		if(modify>0)
        {
        
         con.commit();
        }
        else
        {
       	 flag=false;
       	 con.rollback();
        }

   } 
   
   catch (SQLException e) 
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
		
	
	
	public Vector<PostTo> viewDelivery()
	{
		Vector<PostTo> vpb=null;
		
		String rlocation="";
		String ulocation="";
		
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._VIEW_DELEVERY);
			
			rs=pstmt.executeQuery();
			
			vpb=new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int did=rs.getInt(1);
				int postid=rs.getInt(2);
				int userid=rs.getInt(3);
				String ddate=rs.getString(4);
				String dstatus=rs.getString(5);
				
				
				
				stmt=con.createStatement();
				rs1=stmt.executeQuery("select rlocation from posteldetails where postid="+postid);
				if(rs1.next())
				{
					
					rlocation=rs1.getString(1);		
				}
				
				pstmt1=con.prepareStatement("select street from addresses where userid=?");
				pstmt1.setInt(1, userid);
				
				rs2=pstmt1.executeQuery();
				if(rs2.next())
				{
					
					 ulocation=rs2.getString(1);
					
				}
				
				PostTo pb=new PostTo();
				
				
				pb.setDid(did);
				pb.setDdate(ddate);
				pb.setDstatus(dstatus);
				pb.setPostid(postid);
				pb.setUserid(userid);
				pb.setRlocation(rlocation);
				pb.setUlocation(ulocation);
				
				vpb.add(pb);
				}
			
	}
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		
return vpb;		
}
	

	
	public boolean addComplaint(PostTo pb)
	{
		boolean flag=true;
		int uid=0;
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._ADD_COMPLAINT);
			
			int postid=pb.getPostid();
			String login=pb.getLogin();
			String description=pb.getDescription();
			
			stmt=con.createStatement();
			rs=stmt.executeQuery("select userid from userdetails where loginid="+"'"+login+"'");
			
			if(rs.next())
				
			 uid=rs.getInt(1);
			System.out.println("in DAo from userdetails userid is........"+uid);
			
			
			pstmt.setInt(1, postid);
			pstmt.setInt(2, uid);
			pstmt.setString(3, description);
			pstmt.setString(4, "notfound");
			
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
	   
	   catch (SQLException e) 
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
	
	
	
	
	public Vector<PostTo> viewComplaint()
	{
		
		Vector<PostTo> vpb=null;
		String fname="";
		String lname="";
		try{
			
			
			
			pstmt=con.prepareStatement(SqlConstants._VIEW_COMPLAINT);
			
			rs=pstmt.executeQuery();
			
			vpb=new Vector<PostTo>();
			while(rs.next())
			{
				int compid=rs.getInt(1);
				int postid=rs.getInt(2);
				int userid=rs.getInt(3);
				String description=rs.getString(4);
				String cstatus=rs.getString(5);
				String cdate=rs.getString(6);
				
				stmt=con.createStatement();
				rs1=stmt.executeQuery("select firstname,lastname from userdetails where userid="+userid);
				if(rs1.next())
				 fname=rs1.getString(1);
				 lname=rs1.getString(2);
				
				
				 PostTo pb=new PostTo();
				
				pb.setPostid(postid);
				pb.setUserid(userid);
				pb.setCompid(compid);
				pb.setDescription(description);
				pb.setCstatus(cstatus);
				pb.setCdate(cdate);
				pb.setFname(fname);
				pb.setLname(lname);
				
				vpb.add(pb);
				
		}
	}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return vpb;
	}
	
	
	
	public boolean updateStatus(int postid, String status)
	{
		
		boolean flag=true;
		int update=0;
		
		try{
			
		
			pstmt=con.prepareStatement(SqlConstants._UPDATE_STATUS);
			
			pstmt.setString(1, status);
			pstmt.setInt(2, postid);
			
			
			
			int i=pstmt.executeUpdate();
			
			
			if(i>0)
			{
				
				
				pstmt1=con.prepareStatement("update complaint set status=? where postid=?");
				
				
				pstmt1.setString(1, status);
				pstmt1.setInt(2, postid);
				
				 update=pstmt1.executeUpdate();
			
			
			
			
			
         
			
			
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
			else {
				flag=false;
		       	 con.rollback();
			}

	   } 
	   
	   catch (SQLException e) 
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
		
	
	public Vector<PostTo> postmanPost(String login)
	{
		Vector<PostTo> vpb=null;
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._POSTMAN_POST);
			
			pstmt.setString(1, login);
			
			rs=pstmt.executeQuery();
			vpb=new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int postid=rs.getInt(1);
				String pitem=rs.getString(2);
				String ptype=rs.getString(3);
				String pdate=rs.getString(4);
				String plocation=rs.getString(5);
				String sname=rs.getString(6);
				String shno=rs.getString(7);
				String slocation=rs.getString(8);
				String scity=rs.getString(9);
				String sstate=rs.getString(10);
				String scountry=rs.getString(11);
				int spin=rs.getInt(12);
				String rname=rs.getString(13);
				String rhno=rs.getString(14);
				String rlocation=rs.getString(15);
				String rcity=rs.getString(16);
				String rstate=rs.getString(17);
				String rcountry=rs.getString(18);
				int rpin=rs.getInt(19);
				String dstatus=rs.getString(20);
				String ddate=rs.getString(21);
				
				PostTo pb=new PostTo();
				
				
				pb.setPdate(pdate);
				pb.setPitem(pitem);
				pb.setPlocation(plocation);
				pb.setPostid(postid);
				pb.setPtype(ptype);
				pb.setScity(scity);
				pb.setScountry(scountry);
				pb.setShouseno(shno);
				pb.setSlocation(slocation);
				pb.setSname(sname);
				pb.setSpin(spin);
				pb.setSstate(sstate);
				pb.setRcity(rcity);
				pb.setRcountry(rcountry);
				pb.setRhouseno(rhno);
				pb.setRlocation(rlocation);
				pb.setRname(rname);
				pb.setRpin(rpin);
				pb.setRstate(rstate);
				pb.setDstatus(dstatus);
				pb.setDdate(ddate);
				
				
				
				vpb.add(pb);
				
				
			}
			
	}
     catch (SQLException e) {
      e.printStackTrace();
     }		
		
		
		
		return vpb;
}
	
	
	
	
	
	public boolean insertResponse(PostTo pb)
	{
		
		
		boolean flag=true;
		try{
			
			
			
			pstmt=con.prepareStatement(SqlConstants._INSERT_RESPONSE);
			
			int compid=pb.getCompid();
			
			String desc=pb.getDescription();
			
			pstmt.setInt(1, compid);
			pstmt.setString(2, desc);
			
			
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
	   
	   catch (SQLException e) 
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

	
	
	
	public Vector<PostTo> viewResponse(int compid,String login)
	
	{
		Vector<PostTo> vpb=null;
		
		try{
			
			pstmt=con.prepareStatement(SqlConstants._VIEW_RESPONSE);
			
			pstmt.setInt(1, compid);
			System.out.println("in Dao class compid=.........."+compid);
			pstmt.setString(2, login);
			System.out.println("in Dao class loginid=.........."+login);
			
			rs=pstmt.executeQuery();
			vpb= new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int compid1=rs.getInt(1);
				int postid=rs.getInt(2);
				int cuserid=rs.getInt(3);
				String cdescription=rs.getString(4);
				String cdate=rs.getString(5);
				String rdate=rs.getString(6);
				String rdescription=rs.getString(7);
				int userid=rs.getInt(8);
				String cstatus=rs.getString(9);
				
				PostTo pb=new PostTo();
				
				
				pb.setCompid(compid1);
				pb.setPostid(postid);
				pb.setCuserid(cuserid);
				pb.setDescription(cdescription);
				pb.setCdate(cdate);
				pb.setRdate(rdate);
				pb.setRdescription(rdescription);
				pb.setUserid(userid);
				pb.setCstatus(cstatus);
				pb.setFrom(login);
				
				
				vpb.add(pb);
				
		}
			
			
			
		}
		
		catch (Exception e) {
			
			
			e.printStackTrace();
			
		}
		
		return vpb;
		
		
		
		
		
		
	}
	
	public Vector<PostTo> getComplaintStatus(String login)
	{
		
		Vector<PostTo> vpb=null;
		try{
			
			
			pstmt=con.prepareStatement(SqlConstants._COMPLAINT_STATUS);
			
			pstmt.setString(1, login);
			System.out.println("in Dao login is................"+login);
			rs=pstmt.executeQuery();
			
			
             vpb= new Vector<PostTo>();
			
			while(rs.next())
			{
				
				int compid1=rs.getInt(1);
				int postid=rs.getInt(2);
				int cuserid=rs.getInt(3);
				String cdescription=rs.getString(4);
				String cdate=rs.getString(5);
				
				
				int userid=rs.getInt(6);
				String cstatus=rs.getString(7);
				
				PostTo pb=new PostTo();
				
				
				pb.setCompid(compid1);
				pb.setPostid(postid);
				pb.setCuserid(cuserid);
				pb.setDescription(cdescription);
				pb.setCdate(cdate);
			
				
				pb.setUserid(userid);
				pb.setCstatus(cstatus);
				
				
				
				vpb.add(pb);
				
		}
			
			
			
		}
		
		catch (SQLException e) {
			
			
			e.printStackTrace();
			
		}
		
		return vpb;
		
		
		
		
		
		
	}



	
}
		

