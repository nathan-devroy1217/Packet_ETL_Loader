package Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import packet_fields.Impl.DeviceImpl;
import packet_fields.Impl.PacketImpl;

public class DeviceProcessor {

	/** FileInbound object containing important file data */
	private FileInbound inb;
	
	/** Line to be processed */
	private String line;
	
	/** DB connection pointer */
	private Connection conn;
	
	/** File errors object */
	private PersistFileErrors fileErrors;
	
	/**
	 * Constructor for PacketProcessor
	 * @param inb FileInbound object containing important file data 
	 * @param line Line to be processed
	 */
	public DeviceProcessor(FileInbound inb, String line, Connection conn) {
		setInb(inb);
		setLine(line);
		this.conn = conn;
	}
	
	/**
	 * This method will process packet data and
	 * persist it to the packet table
	 */
	public DeviceImpl processDevice() {
		ResultSet rs = null;
		HashMap<String, String> deviceMap = new HashMap<String, String>();
		DeviceImpl deviceImpl = new DeviceImpl();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select ip_address, device_name from device;";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			// We want to avoid insert conflicts with devices already in the device table
			// ...Therefore we will populate a HashMap with all devices and their IP
			// addresses as a referent
			while (rs.next()) {
				String ipAddr = rs.getString("ip_address");
				String deviceName = rs.getString("device_name");
				deviceMap.put(ipAddr, deviceName);
			}

			String[] strArr = line.split("\\s+");
			if (strArr.length == 7 && deviceMap.get(strArr[1].substring(1, strArr[1].length() - 1)) == null) {
				deviceImpl.setDeviceName(strArr[0]);
				deviceImpl.setIpAddress(strArr[1].substring(1, strArr[1].length() - 1));
				deviceImpl.setMacAddress(strArr[3]);
			} else {
				return null;
			}
		} catch (SQLException e) {
			fileErrors = new PersistFileErrors(inb);
			fileErrors.populateErrorIntoTable(inb, e.toString());
		}
		return deviceImpl;
	}

	/**
	 * Setter for inb
	 * @param inb FileInbound object containing important file data 
	 */
	public void setInb(FileInbound inb) {
		this.inb = inb;
	}

	/**
	 * Getter for line
	 * @param line Line to be processed
	 */
	public void setLine(String line) {
		this.line = line;
	}	
}
