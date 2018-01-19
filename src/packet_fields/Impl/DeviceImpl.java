package packet_fields.Impl;

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
}
