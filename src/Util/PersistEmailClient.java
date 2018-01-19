package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import packet_fields.Email_Client;
import packet_fields.Impl.EmailClientImpl;

/**
 * Persistence process for Email Client
 * @author Nathan
 * @version 1/18/18
 */
public class PersistEmailClient {
	
	/** JDBC connection string */
	private final String url = HomeNetworkConstants.url;
	
	/** Insert statement to DB */
	private Statement updtStmt = null;
	
	/** User name for DB connection */
	private final String user = HomeNetworkConstants.user;
	
	/** Password for DB connection */
	private final String password = HomeNetworkConstants.password;
	
	/** DB connection */
	private Connection conn = null;
	
	private ArrayList<EmailClientImpl> data;
			
	/**
	 * Constructor for PersistEmailClient
	 * @param data List of EmailClient objects to persist
	 */
	public PersistEmailClient(ArrayList<EmailClientImpl> data) {
		this.data = data;
	}
	
	/**
	 * Persist a list of EmailClient objects
	 * @param data the list of EmailClient objects to persist to DB
	 */
	public void persist() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			for(EmailClientImpl item : data) {
				updtStmt = conn.createStatement();
				String sql = "insert into email_client(id,client_name,email_addr,last_msg,is_active)"
						+ " values(" + Email_Client.id + ",\"" + item.getClientName() + "\",\""
						+ item.getEmailAddress() + "\"," + Email_Client.lastMsg + "," + item.getIsActive() 
						+ ");";
				System.out.println(sql);
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
