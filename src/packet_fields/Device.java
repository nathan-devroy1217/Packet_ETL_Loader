package packet_fields;

import java.sql.Timestamp;

/**
 * Declaration of Device Interface
 * @author Nathan
 * @version 1/17/18
 */
public interface Device {
	
	/** Device Id variable */
	final static String deviceId = "NULL";
	
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
	
	/** Setter for deviceInsrtDttm */
	void setDeviceInsrtDttm(Timestamp deviceInsrtDttm);
	
	/** Getter for deviceInsrtDttm */
	Timestamp getDeviceInsrtDttm();
	
	/** Setter for deviceUpdtDttm */
	void setDeviceUpdtDttm(Timestamp deviceUpdtDttm);
	
	/** Getter for deviceUpdtDttm */
	Timestamp getDeviceUpdtDttm();
}
