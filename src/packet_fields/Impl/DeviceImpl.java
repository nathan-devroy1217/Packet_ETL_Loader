package packet_fields.Impl;

import java.sql.Timestamp;

import packet_fields.Device;

/**
 * Device defines devices using the network
 * @author Nathan
 * @version 1/17/18
 */
public class DeviceImpl implements Device {

	/** IP address of device */
	private String ipAddress;
	
	/** Name of device */
	private String deviceName;
	
	/** MAC address of device */
	private String macAddress;
	
	/** Time device inserted into device table */
	private Timestamp deviceInsrtDttm;
	
	/** Time device updated in device table */
	private Timestamp deviceUpdtDttm;
	
	/**
	 * Setter for ipAddress
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Getter for ipAddress
	 */
	@Override
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Setter for deviceName
	 */
	@Override
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * Getter for deviceName
	 */
	@Override
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * Setter for macAddress
	 */
	@Override
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	/**
	 * Getter for macAddress
	 */
	@Override
	public String getMacAddress() {
		return macAddress;
	}

	/**
	 * Setter for deviceInsrtDttm
	 */
	@Override
	public void setDeviceInsrtDttm(Timestamp deviceInsrtDttm) {
		this.deviceInsrtDttm = deviceInsrtDttm;
	}

	/**
	 * Getter for deviceInsrtDttm
	 */
	@Override
	public Timestamp getDeviceInsrtDttm() {
		return deviceInsrtDttm;
	}
	
	/**
	 * Setter for deviceUpdtDttm
	 */
	@Override
	public void setDeviceUpdtDttm(Timestamp deviceUpdtDttm) {
		this.deviceUpdtDttm = deviceUpdtDttm;
	}

	/**
	 * Getter for deviceUpdtDttm
	 */
	@Override
	public Timestamp getDeviceUpdtDttm() {
		return deviceUpdtDttm;
	}
}
