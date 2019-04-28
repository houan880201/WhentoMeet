
package db;

public interface DBConnection {
	/**
	 * Close the connection.
	 */
	public void close();
	
	/**
	 * Demo method
	 */
	public void setPeopleNum(String meetingId);
}



