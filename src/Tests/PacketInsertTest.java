package Tests;

import java.sql.Connection;

import Util.PersistDevice;
import Util.PersistEmailClient;
import Util.PersistFileErrors;
import Util.PersistFileInfo;
import Util.PersistPacket;
import packet_fields.Impl.DeviceImpl;
import packet_fields.Impl.EmailClientImpl;
import packet_fields.Impl.FileErrorsImpl;
import packet_fields.Impl.FileInfoImpl;
import packet_fields.Impl.PacketImpl;

/**
 * Test configurations for Packet_ETL_Loader
 * @author Nathan
 * @version 1/17/18
 */
public class PacketInsertTest {

	/** DB Connection */
	private Connection conn;
	
	/**
	 * Constructor for PacketInsertTest
	 */
	public PacketInsertTest(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * Persist data to packet table
	 */
	public void persistToPacketTest() {
		PacketImpl packet = new PacketImpl();
		packet.setFileKey(2);
		packet.setHttpHost("www.netflix.com");
		packet.setHttpRequestUri("http://www.hulu.com");
		packet.setSrcIp("192.168.1.76");
		packet.setDstIp("192.168.1.1");
		packet.setTcpSrcPort("2245");
		packet.setTcpDstPort("22");
		packet.setResolvedUri("www.google.com");
		
		PersistPacket pp = new PersistPacket(packet, conn);
		pp.persist();
	}
	
	/**
	 * Persist data to file info table
	 */
	public void persistToFileInfoTest() {
		FileInfoImpl fileInfo = new FileInfoImpl(conn);
		fileInfo.setFileStatus(2);
		fileInfo.setFilePath("/home/pi/files/");
		fileInfo.setFileName("testFile.dat");

		PersistFileInfo fi = new PersistFileInfo(fileInfo, conn);
		fi.persist();
	}
	
	/**
	 * Persist data to email client table
	 */
	public void persistToEmailClientDataTest() {
		EmailClientImpl client = new EmailClientImpl();
		client.setClientName("Charles");
		client.setEmailAddress("charlesjohnson@gmail.com");
		client.setIsActive(true);

		PersistEmailClient pec = new PersistEmailClient(client, conn);
		pec.persist();
	}
	
	/**
	 * Persist data to file errors table
	 */
	public void persistToFileErrorsTest() {
		FileErrorsImpl fileErrors = new FileErrorsImpl();
		fileErrors.setFileKey(12);
		fileErrors.setErrorMsg("Error: Bad Insert");
		
		PersistFileErrors pfe = new PersistFileErrors(fileErrors, conn);
		pfe.persist();
	}
	
	/**
	 * Persist data to device table
	 */
	public void persistToDeviceDataTest() {
		DeviceImpl device = new DeviceImpl();
		device.setIpAddress("192.168.1.25");
		device.setDeviceName("Frank's Computer");
		device.setMacAddress("mo:34:23:21:221:12");

		PersistDevice pd = new PersistDevice(device, conn);
		pd.persist();
	}
}
