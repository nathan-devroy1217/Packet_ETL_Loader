package Util.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import packet_fields.Impl.EmailClientImpl;

/**
 * Persistence process for Email Client
 * @author Nathan
 * @version 1/18/18
 */
public class PersistEmailClient extends PersistAbstract {
	
	/** JDBC connection string */
	private final String url = super.url;
	
	/** Insert statement to DB */
	private Statement updtStmt = null;
	
	/** User name for DB connection */
	private final String user = super.user;
	
	/** Password for DB connection */
	private final String password = super.password;
	
	/** DB connection */
	private Connection conn = null;
	
	private ArrayList<EmailClientImpl> data;
			
	/**
	 * Constructor for PersistDevice
	 * @param data List of Device objects to persist
	 */
	public PersistEmailClient(ArrayList<EmailClientImpl> data) {
		this.data = data;
	}
	
	/**
	 * Persist a list of Device objects
	 * @param data the list of Device objects to persist to DB
	 */
	public void persist() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			for(EmailClientImpl item : data) {
				updtStmt = conn.createStatement();
				//Need to update SQL statement
				String sql = "insert into device() values()";
				updtStmt.executeUpdate(sql);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				System.out.println("Closing database connection....");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
