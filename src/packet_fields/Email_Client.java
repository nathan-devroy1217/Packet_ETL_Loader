package packet_fields;

import java.sql.Timestamp;

/**
 * Declaration of Email_Client Interface
 * @author Nathan
 * @version 1/17/18
 */
public interface Email_Client {
	
	/** ID of the client */
	final String id = "NULL";
	
	/** Setter for clientName */
	void setClientName(String clientName);
	
	/** Getter for clientName */
	String getClientName();
	
	/** Setter for emailAddress */
	void setEmailAddress(String emailAddress);
	
	/** Getter for emailAddress */
	String getEmailAddress();
	
	/** Setter for lastMsg */
	void setLastMsg(Timestamp lastMsg);
	
	/** Getter for lastMsg */
	Timestamp getLastMsg();
}
