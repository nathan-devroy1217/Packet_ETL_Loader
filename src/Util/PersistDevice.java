package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

	/** JDBC connection string */
	private final String url = HomeNetworkConstants.url;
	
	/** Insert statement to DB */
	private Statement updtStmt = null;
	
	/** User name for DB connection */
	private final String user = HomeNetworkConstants.user;
	
	/** Password for DB connection */
	private final String password = HomeNetworkConstants.password;
	
	/** DB connection */
	private Connection conn = null;
	
	private ArrayList<DeviceImpl> data;
			
	/**
	 * Constructor for PersistDevice
	 * @param data List of Device objects to persist
	 */
	public PersistDevice(ArrayList<DeviceImpl> data) {
		this.data = data;
	}
	
	/**
	 * Persist a list of Device objects
	 * @param data the list of Device objects to persist to DB
	 */
	public void persist() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			for(DeviceImpl item : data) {
				updtStmt = conn.createStatement();		
				String sql = "insert into device(device_id,ip_address,device_name,mac_address,"
						+ "device_insrt_dttm,device_updt_dttm) values(" + Device.deviceId + 
						",\"" + item.getIpAddress() + "\",\"" + item.getDeviceName() + "\",\""
						+ item.getMacAddress() + "\"," + Device.deviceInsrtDttm +
						"," + Device.deviceUpdtDttm + ");";
				System.out.println(sql);
				updtStmt.executeUpdate(sql);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				System.out.println("Closing database connection....");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
