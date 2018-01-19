package packet_fields;

/**
 * Declaration of Device Interface
 * @author Nathan
 * @version 1/17/18
 */
public interface Device {
	
	/** Device Id variable */
	final static String deviceId = "NULL";
	
	/** Insert time */
	final static String deviceInsrtDttm = "CURRENT_TIMESTAMP";
	
	/** Update time */
	final static String deviceUpdtDttm = "CURRENT_TIMESTAMP";
	
	/** Setter for ipAddress */
	void setIpAddress(String ipAddress);
	
	/**Getter for ipAddress */
	String getIpAddress();
	
	/** Setter for deviceName */
	void setDeviceName(String deviceName);
	
	/** Getter for deviceName */
	String getDeviceName();
	
	/** Setter for macAddress */
	void setMacAddress(String macAddress);
	
	/** Getter for macAddress */
	String getMacAddress();

}
