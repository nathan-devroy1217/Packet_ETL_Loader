package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {

	/** JDBC connection string */
	private final String url = HomeNetworkConstants.url;

	/** User name for DB connection */
	private final String user = HomeNetworkConstants.user;

	/** Password for DB connection */
	private final String password = HomeNetworkConstants.password;

	/** DB connection */
	private Connection conn = null;
	
	public DBConnectUtil() {
		
	}
	
	public Connection connectDB() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeDB() {
		if (conn != null) {
			System.out.println("Closing database connection....");
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
