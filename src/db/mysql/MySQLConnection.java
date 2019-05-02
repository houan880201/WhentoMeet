package db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import db.DBConnection;

public class MySQLConnection implements DBConnection {
	private Connection conn;
    
    public MySQLConnection() {
   	 try {
   		 Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
   		 conn = DriverManager.getConnection(MySQLDBCONF.URL);
   		 
   	 } catch (Exception e) {
   		 e.printStackTrace();
   	 }
    }
	@Override
	public void close() {
	   	 if (conn != null) {
	   		 try {
	   			 conn.close();
	   		 } catch (Exception e) {
	   			 e.printStackTrace();
	   		 }
	   	 }
	}
	/**
	 * Demo Method
	 */
	@Override
	public void setPeopleNum(String meetingId) {
		// TODO Auto-generated method stub
		if (conn == null) {
			System.err.println("DB connection failed");
			return;
		}
		try {
			String sql = "INSERT INTO meeting(meeting_id) VALUES(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, meetingId);
			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addEvent(String meetingId, String daysOfTheWeek, String eventName, String eventDesc, String startTime, String endTime) {
		if (conn == null) {
			System.err.println("DB connection failed");
			return;
		}

		try {
            System.out.println("before preparing sql");
            String sql = "INSERT INTO Meeting(meeting_id, days_of_the_week, event_name, event_desc, start_time, end_time) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "1");
            ps.setString(2, daysOfTheWeek);
            ps.setString(3, eventName);
            ps.setString(4, eventDesc);
            ps.setString(5, startTime);
            ps.setString(6, endTime);
            System.out.println("before executing sql");
			ps.execute();
		} catch (Exception e) {
            System.out.println("error!!");
			e.printStackTrace();
		}
	}

}
