package db;

import db.mysql.MySQLConnection;

public class DBConnectionFactory {

	public static DBConnection getConnection() {
		return new MySQLConnection();
	}

}


