
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


	/** method to add a new event */
	public void addEvent(String meetingId, String daysOfTheWeek, String eventName, String eventDesc, String startTime, String endTime);
}



