package com.post.bdbutil;



public class SqlConstants {
	
	
	//PostalDAo
	
	public static final String _INSERT_POST="insert into posteldetails values((select nvl(max(postid),1000)+1 from posteldetails),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String _INSERT_LoST_POST="insert into lostarticel values((select nvl(max(articelid),2010)+1 from lostarticel),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String _VIEW_POST="select postid,postitem,posttype,TO_CHAR(postdate,'DD-MM-YYYY'),postlocation,sname,shouseno,slocation,scity,sstate,scountry,spin,rname,rhouseno,rlocation,rcity,rstate,rcountry,rpin,deliverystatus from posteldetails";

	public static final String _VIEW_POST_AT="select postid,postitem,posttype,TO_CHAR(postdate,'DD-MM-YYYY'),postlocation,sname,shouseno,slocation,scity,sstate,scountry,spin,rname,rhouseno,rlocation,rcity,rstate,rcountry,rpin from posteldetails where postid=? ";
   
	public static final String _VIEW_LoST_POST="select postid,postitem,posttype,TO_CHAR(postdate,'DD-MM-YYYY'),postlocation,sname,shouseno,slocation,scity,sstate,scountry,spin,rname,rhouseno,rlocation,rcity,rstate,rcountry,rpin,deliverystatus from posteldetails where  deliverystatus=?";

	public static final String _VIEW_LoST_POST_AT="select postid,articeltype,posttype,TO_CHAR(postdate,'DD-MM-YYYY'),postlocation,sname,shouseno,slocation,scity,sstate,scountry,spin,rname,rhouseno,rlocation,rcity,rstate,rcountry,rpin,articelstatus from lostarticel where postid=? and articelstatus=? ";

	public static final String _CANCEL_POST="delete from posteldetails where postid=?";
	
	public static final String _UPDATE_POST="update posteldetails set postitem=?,posttype=?,postdate=?,postlocation=?,sname=?,shouseno=?,slocation=?,scity=?,sstate=?,scountry=?,spin=?,rname=?,rhouseno=?,rlocation=?,rcity=?,rstate=?,rcountry=?,rpin=? where postid=?";

	public static final String _UPDATE_POST_STATUS="update posteldetails set deliverydate=?,deliverystatus=? where postid=?";

	public static final String _GET_POSTMAN="select userid,firstname,lastname from userdetails  where logintype=? and  userid in (select userid from addresses where street=?)";
    
	public static final String _POST_SCHEDULE="insert into shedulepost values((select nvl(max(sid),1010)+1 from shedulepost),?,?,sysdate,'notdelivered')";

	public static final String _SELECT_POSTMAN="select userid,firstname,lastname from userdetails  where logintype=? and  userid in (select userid from addresses where street=?)";

	public static final String _VIEW_POST_SCHEDULE="select sid,postid,userid,TO_CHAR(sdate,'DD-MM-YYYY'),status from shedulepost";

	public static final String _ADD_DELEVERY="insert into delivery values((select nvl(max(did),110)+1 from delivery),?,?,sysdate,?)";
    
	public static final String _SELECT_USER="select userid from userdetails where loginid=?";

	public static final String _VIEW_DELEVERY="select did,postid,userid,TO_CHAR(ddate,'DD-MM-YYYY'),dstatus from delivery";

	public static final String _ADD_COMPLAINT="insert into complaint values((select nvl(max(compid),1110)+1 from complaint),?,?,?,?,sysdate)";
	
	public static final String _VIEW_COMPLAINT="select compid,postid,userid,description,status,TO_CHAR(cdate,'DD-MM-YYYY') from complaint";
	
	public static final String _UPDATE_STATUS="update lostarticel set articelstatus=? where postid=?";
	
	public static final String _POSTMAN_POST="select p.postid,p.postitem,p.posttype,TO_CHAR(p.postdate,'DD-MM-YYYY'),p.postlocation,p.sname,p.shouseno,p.slocation,p.scity,p.sstate,p.scountry,p.spin,p.rname,p.rhouseno,p.rlocation,p.rcity,p.rstate,p.rcountry,p.rpin,p.deliverystatus,To_CHAR(p.deliverydate,'DD-MM-YYYY') from posteldetails p where postid in (select postid from shedulepost where userid in(select userid from userdetails where loginid=?))";
	
	public static final String _INSERT_RESPONSE="insert into response values(?,sysdate,?)";
	
	public static final String _VIEW_RESPONSE="select c.compid,c.postid,c.userid,c.description,TO_CHAR(c.cdate,'DD-MM-YYYY'),TO_CHAR(r.resdate,'DD-MM-YYYY'),r.description ,u.userid,c.status from complaint c , response r ,userdetails u where c.compid=r.compid and r.compid=? and u.loginid=?";
	
	public static final String _COMPLAINT_STATUS="select c.compid,c.postid,c.userid,c.description,TO_CHAR(c.cdate,'DD-MM-YYYY') ,u.userid,c.status from complaint c  ,userdetails u where c.userid=u.userid  and u.loginid=?";

	
	
	
	//SolutionDAO
	   
	   public static final String _GIVE_SOLUTION="insert into solution values(?,?,?)";
	   
	   public static final String _GET_QUERY_STATUS="select q.queryid,q.userid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),s.solvdate,s.solution ,c.userid,q.qstatus from query q , solution s ,userdetails c where q.queryid=s.queryid and c.loginid=?";
	   
	   public static final String _GET_SOLUTION="select q.queryid,q.userid,q.qdescription,TO_CHAR(q.qdate,'DD-MM-YYYY'),TO_CHAR(s.solvdate,'DD-MM-YYYY'),s.solution ,u.userid,q.qstatus from query q , solution s ,userdetails u where q.queryid=s.queryid and s.queryid=? and u.loginid=?";
	   
	   //QueryDAo
	   
	   public static final String _INSERT_QUERY="insert into query values((select nvl(max(queryid),1000)+1 from query),?,?,?,?)";
	   
	   public static final String _GET_QUERY="select queryid,userid,qdescription,qstatus,to_char(qdate,'dd-mm-yy') from query";
	   
	   public static final String _GET_QUERY_AT="select queryid,userid,qdescription,qstatus,TO_CHAR(qdate,'dd-mm-yyyy') from query where queryid=?";
	   

	   
	   
	   //FeedbackDAO
	   
	   public static final String _INSERT_FEEDBACK="insert into feedback values((select nvl(max(fid),100)+1 from feedback),?,?,?,?,?,?,?,?)";
	   
	   public static final String _GET_FEEDBACK="select *from feedback";
	   
	   public static final String _All_FEEDBACKS="select *from feedback where fid=?";
	   
	   public static final String _DELETE_FEEDBACK="delete from feedback where fid=?";
	
	
	//SecutityDAO
	   
	   
	   public static final String _CHECK_LOGIN="{call logincheck(?,?,?)}";
	   
	   public static final String _LOGIN_AUDIT="{call signoutprocedure(?)}";
	   
	   public static final String _CHANGE_PADSSWORD="update userdetails set password=? where loginid=? and password=?";
	   
	   public static final String _CHANGE_QUESTION="{call ChangeQuetion(?,?,?,?,?)}";
	   
	   public static final String _RECOVER_PASSWORD="{call RecoverPassword(?,?,?,?)}";
	   
	   public static final String _CHECK_USER="select userid from userdetails where loginid=?";
	
	//ProfileDAo
	   
	   public static final String _REGISTRATION="{call insertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	   
	   public static final String _ADMIN_REGISTRATION="{call admininsertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	
	   public static final String _GET_PROFILE="{call showprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	   
	   public static final String _MODIFY_PROFILE="{call changeprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	   
	   
}
