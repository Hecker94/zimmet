package ownership;

import java.sql.*;

public class baglanti {
	
	static Connection myConn;
	static Statement myStat;
	
	static ResultSet yap() {
		ResultSet myRs = null;
		try {			
			myConn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/zimmet","root","1234");
			myStat =  myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			myRs = myStat.executeQuery("select * from kisiler");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myRs;
	}
	
	static void ekle(String sql_sorgu) {
		
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void update(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void sil(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet myRs =null;		
		try {			
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myRs;
	}
}