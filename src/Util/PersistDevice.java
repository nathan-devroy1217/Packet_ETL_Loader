package Util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import packet_fields.Device;
import packet_fields.Impl.DeviceImpl;

/**
 * Persistence process for Device objects
 * @author Nathan
 * @version 1/18/18
 */
public class PersistDevice {

	/** Insert statement to DB */
	private Statement updtStmt = null;
	
	/** DB connection */
	private Connection conn;
	
	/** List of Device objects */
	private DeviceImpl data;
			
	/**
	 * Constructor for PersistDevice
	 * @param data List of Device objects to persist
	 */
	public PersistDevice(DeviceImpl data, Connection conn) {
		this.data = data;
		this.conn = conn;
	}
	
	/**
	 * Persist a list of Device objects
	 * @param data the list of Device objects to persist to DB
	 */
	public void persist() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			updtStmt = conn.createStatement();
			String sql = "insert into device(device_id,ip_address,device_name,mac_address,"
					+ "device_insrt_dttm,device_updt_dttm) values(" + Device.deviceId + ",\"" + data.getIpAddress()
					+ "\",\"" + data.getDeviceName() + "\",\"" + data.getMacAddress() + "\"," + Device.deviceInsrtDttm
					+ "," + Device.deviceUpdtDttm + ");";
			System.out.println(sql);
			updtStmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
