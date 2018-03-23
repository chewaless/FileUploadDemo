package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.domains.User;

public class ConnectionUtils {

	// method for create connection
		public static Connection getConnection() throws Exception {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "santosh");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// method for save user data in database
		public static int registerUser(User user) throws Exception {
			int i = 0;
			try {
				String sql = "INSERT INTO sch_bulk_sms (mobile_no, created_date) VALUES (?, ?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, user.getMobileNumber());
				ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				return i;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		public ResultSet report() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT * FROM sch_bulk_sms";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		public ResultSet fetchUserDetails(String mobile_no) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT UNAME,UEMAIL,UPASS,UDEG FROM sch_bulk_sms WHERE mobile_no=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, mobile_no);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		public int updateUserDetails(String uname, String uemail, String upass, String udeg, String uemailhidden)
				throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE sch_bulk_sms SET UNAME=?,UEMAIL=?,UPASS=?,UDEG=? WHERE mobile_no=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, uname);
				ps.setString(2, uemail);
				ps.setString(3, upass);
				ps.setString(4, udeg);
				ps.setString(5, uemailhidden);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		public int deleteUserDetails(String mobile_no) throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM sch_bulk_sms WHERE mobile_no=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, mobile_no);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
	
}
