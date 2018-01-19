package packet_fields.Impl;


import packet_fields.Email_Client;

/**
 * EmailClient defines email recipients for packet analysis
 * @author Nathan
 * @version 1/17/18
 */
public class EmailClientImpl implements Email_Client {

	/** Name of email client */
	private String clientName;
	
	/** Email address of email client */
	private String emailAddress;

	/** Whether client is active in system */
	private boolean isActive;
	
	/**
	 * Setter for clientName
	 */
	@Override
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * Getter for clientName
	 */
	@Override
	public String getClientName() {
		return clientName;
	}

	/**
	 * Setter for emailAddress
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Getter for emailAddress
	 */
	@Override
	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public boolean getIsActive() {
		return isActive;
	}
}
