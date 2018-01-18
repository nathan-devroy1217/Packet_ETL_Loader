package Util.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Abstract definition for persistence objects
 * @author Nathan
 * @version 1/18/18
 */
public abstract class PersistAbstract {

	/** Remote DB connection url */
	private final String url = "jdbc:mysql://192.168.1.15:3306/home_network_tst";
	
	/** User name for DB connection */
	private final String user = "nathan";
	
	/** Password for DB connection */
	private final String password = "Elijah1027";
	
	/** DB connection */
	private Connection connect = null;
	
	/**
	 * Connect to DB
	 * @throws Exception if connection is null
	 */
	protected void dbConnect() {
		try {
			System.out.println("Attempting to connect to database....");
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
