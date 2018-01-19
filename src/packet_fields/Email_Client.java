package packet_fields;

/**
 * Declaration of Email_Client Interface
 * @author Nathan
 * @version 1/17/18
 */
public interface Email_Client {
	
	/** ID of the client */
	final String id = "NULL";
	
	/** Last sent message */
	final String lastMsg = "CURRENT_TIMESTAMP";
	
	/** Setter for clientName */
	void setClientName(String clientName);
	
	/** Getter for clientName */
	String getClientName();
	
	/** Setter for emailAddress */
	void setEmailAddress(String emailAddress);
	
	/** Getter for emailAddress */
	String getEmailAddress();
	
	/** Setter for isActive */
	void setIsActive(boolean isActive);
	
	/** Getter for isActive */
	boolean getIsActive();
}
