package Util;

import java.sql.Connection;
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
	
	/** Insert statement to DB */
	private Statement updtStmt = null;
	
	/** DB connection */
	private Connection conn;
	
	/** Data list of EmailClientImpl objects */
	private ArrayList<EmailClientImpl> data;
			
	/**
	 * Constructor for PersistEmailClient
	 * @param data List of EmailClient objects to persist
	 */
	public PersistEmailClient(ArrayList<EmailClientImpl> data, Connection conn) {
		this.data = data;
		this.conn = conn;
	}
	
	/**
	 * Persist a list of EmailClient objects
	 * @param data the list of EmailClient objects to persist to DB
	 */
	public void persist() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
		}
	}
}
