package Tests;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Test configurations for Packet_ETL_Loader
 * @author Nathan
 * @version 1/17/18
 */
public class PacketInsertTest {

	/** Database connection to mySQL Driver */
	private Connection conn = null;
	
	/** Statement applied for test case */
	private Statement stmt = null;
	
	/** Database url connection */
	private final String url = "jdbc:mysql://192.168.1.15:3306/home_network_tst";
	
	/** Data load for device table */
	private String deviceData;
	
	/** Data load for email client table */
	private String emailClientData;
	
	/** Data load for file error table */
	private String fileErrorsData;
	
	/** Data load for file info table */
	private String fileInfoData;
	
	/** Data load for packet table */
	private String packetData;

	/**
	 * Constructor for PacketInsertTest
	 */
	public PacketInsertTest() {
		packetData = "Jan 15, 2018 14:42:04.872754000 CST*www.netflix.com*http://www.hulu.com*192.168.1.76*192.168.1.1*2324*80*www.google.com";
		fileInfoData = "Jan 15, 2018 14:42:04.872754000 CST*Jan 16, 2018 14:42:04.872754000 CST*1*/home/pi/files/*FilePacketData.dat";
		emailClientData = "Nathan*nrdevroy1217@gmail.com*Jan 15, 2018 14:42:04.872754000 CST*";
		fileErrorsData = "12345*Jan 15, 2018 14:42:04.872754000 CST*Jan 15, 2018 14:42:04.872754000 CST*Error: No such file*";
		deviceData = "192.168.1.25*Frank's Computer*mo:34:23:21:221:12*Jan 15, 2018 14:42:04.872754000 CST*Jan 15, 2018 14:42:04.872754000 CST*";	
	}
	
	/**
	 * Persist data to packet table
	 */
	public void persistToPacketTest() {
		
	}
	
	/**
	 * Persist data to file info table
	 */
	public void persistToFileInfoTest() {
		
	}
	
	/**
	 * Persist data to email client table
	 */
	public void persistToEmailClientDataTest() {
		
	}
	
	/**
	 * Persist data to file errors table
	 */
	public void persistToFileErrorsTest() {
		
	}
	
	/**
	 * Persist data to device table
	 */
	public void persistToDeviceDataTest() {
		
	}
}
