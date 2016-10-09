package com.post.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.post.bdbutil.DBConnectionFactory;
import com.post.bdbutil.SqlConstants;
import com.post.bean.FeedbackTo;
import com.post.daoI.FeedBackDAOI;


public class FeedBackDAOImpl implements FeedBackDAOI {
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	Connection con;

	public FeedBackDAOImpl() {
		con = DBConnectionFactory.getConnection();
	}

	public boolean insertFeedBack(FeedbackTo fb) {

		boolean flag = true;

		try {

			pstmt = con.prepareStatement(SqlConstants._INSERT_FEEDBACK);

			String feedback = fb.getFeedback();
			String name = fb.getName();
			String addr = fb.getAddress();
			String email = fb.getEmail();
			String city = fb.getCity();
			String country = fb.getCountry();
			int pin = fb.getPin();
			String occupation = fb.getOccupation();

			pstmt.setString(1, feedback);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, email);
			pstmt.setString(5, city);
			pstmt.setInt(6, pin);
			pstmt.setString(7, country);
			pstmt.setString(8, occupation);

			int insert = pstmt.executeUpdate();

			if (insert > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

	public Vector<FeedbackTo> getFeedBack() {
		Vector<FeedbackTo> vfb = null;

		try {

			pstmt = con.prepareStatement(SqlConstants._GET_FEEDBACK);
			rs = pstmt.executeQuery();

			vfb = new Vector<FeedbackTo>();
			while (rs.next()) {

				int fid = rs.getInt(1);
				String feedback = rs.getString(2);
				String username = rs.getString(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String city = rs.getString(6);
				int pin = rs.getInt(7);
				String country = rs.getString(8);
				String ocupation = rs.getString(9);

				FeedbackTo fb = new FeedbackTo();

				fb.setAddress(address);
				fb.setCity(city);
				fb.setCountry(country);
				fb.setEmail(email);
				fb.setFeedback(feedback);
				fb.setOccupation(ocupation);
				fb.setPin(pin);
				fb.setName(username);
				fb.setFid(fid);

				vfb.add(fb);

			}

		} catch (SQLException e) {
			// TODO: handle SQLException
		}
		return vfb;

	}

	public Vector<FeedbackTo> getAllFeedBack(int fid1) {
		Vector<FeedbackTo> vfb = null;

		try {

			pstmt = con.prepareStatement(SqlConstants._All_FEEDBACKS);

			pstmt.setInt(1, fid1);

			rs = pstmt.executeQuery();

			vfb = new Vector<FeedbackTo>();
			while (rs.next()) {

				int fid = rs.getInt(1);
				String feedback = rs.getString(2);
				String username = rs.getString(3);
				String address = rs.getString(4);
				String email = rs.getString(5);
				String city = rs.getString(6);
				int pin = rs.getInt(7);
				String country = rs.getString(8);
				String ocupation = rs.getString(9);

				FeedbackTo fb = new FeedbackTo();

				fb.setAddress(address);
				fb.setCity(city);
				fb.setCountry(country);
				fb.setEmail(email);
				fb.setFeedback(feedback);
				fb.setOccupation(ocupation);
				fb.setPin(pin);
				fb.setName(username);
				fb.setFid(fid);

				vfb.add(fb);

			}

		} catch (SQLException e) {
			// TODO: handle SQLException
		}
		return vfb;

	}

	public boolean cancelFeedBack(int fid) {

		boolean flag = true;

		try {

			pstmt = con.prepareStatement(SqlConstants._DELETE_FEEDBACK);

			pstmt.setInt(1, fid);

			int delete = pstmt.executeUpdate();

			if (delete > 0) {

				con.commit();
			} else {
				flag = false;
				con.rollback();
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return flag;
	}

}
