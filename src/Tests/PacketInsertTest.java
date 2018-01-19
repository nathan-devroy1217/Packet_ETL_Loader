package Tests;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

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

	/**
	 * Constructor for PacketInsertTest
	 */
	public PacketInsertTest() {

	}
	
	/**
	 * Persist data to packet table
	 */
	public void persistToPacketTest() {
		ArrayList<PacketImpl> list = new ArrayList<PacketImpl>();
		PacketImpl packet = new PacketImpl();
		packet.setId(2);
		packet.setAccessDttm(Timestamp.valueOf("2018-05-03 08:34:00.324"));
		packet.setFileKey(2);
		packet.setHttpHost("www.netflix.com");
		packet.setHttpRequestUri("http://www.hulu.com");
		packet.setSrcIp("192.168.1.76");
		packet.setDstIp("192.168.1.1");
		packet.setTcpSrcPort(2245);
		packet.setTcpDstPort(22);
		packet.setResolvedUri("www.google.com");
		
		list.add(packet);
		PersistPacket pp = new PersistPacket(list);
		pp.persist();
	}
	
	/**
	 * Persist data to file info table
	 */
	public void persistToFileInfoTest() {
		ArrayList<FileInfoImpl> list = new ArrayList<FileInfoImpl>();
		FileInfoImpl fileInfo = new FileInfoImpl();
		fileInfo.setInsrtDttm(Timestamp.valueOf("2018-05-03 08:34:00.324"));
		fileInfo.setUpdtDttm(Timestamp.valueOf("2018-05-03 08:34:00.324"));
		fileInfo.setFileStatus(2);
		fileInfo.setFilePath("/home/pi/files/");
		fileInfo.setFileName("testFile.dat");
		
		list.add(fileInfo);
		PersistFileInfo fi = new PersistFileInfo(list);
		fi.persist();
	}
	
	/**
	 * Persist data to email client table
	 */
	public void persistToEmailClientDataTest() {
		ArrayList<EmailClientImpl> list = new ArrayList<EmailClientImpl>();
		EmailClientImpl client = new EmailClientImpl();
		client.setClientName("Nathan");
		client.setEmailAddress("nrdevroy1217@gmail.com");
		client.setLastMsg(Timestamp.valueOf("2018-05-01 09:34:00.324"));
		
		list.add(client);
		PersistEmailClient pec = new PersistEmailClient(list);
		pec.persist();
	}
	
	/**
	 * Persist data to file errors table
	 */
	public void persistToFileErrorsTest() {
		//fileErrorsData = "12345*Jan 15, 2018 14:42:04.872754000 CST*Jan 15, 2018 14:42:04.872754000 CST*Error: No such file*";
		
		ArrayList<FileErrorsImpl> list = new ArrayList<FileErrorsImpl>();
		FileErrorsImpl fileErrors = new FileErrorsImpl();
		fileErrors.setFileKey(1);
		fileErrors.setInsrtDttm(Timestamp.valueOf("2018-01-01 02:02:00.324"));
		fileErrors.setUpdtDttm(Timestamp.valueOf("2018-01-01 02:02:00.324"));
		fileErrors.setErrorMsg("Error: Bad Insert");
		
		list.add(fileErrors);
		PersistFileErrors pfe = new PersistFileErrors(list);
		pfe.persist();
	}
	
	/**
	 * Persist data to device table
	 */
	public void persistToDeviceDataTest() {
		ArrayList<DeviceImpl> list = new ArrayList<DeviceImpl>();
		DeviceImpl device = new DeviceImpl();
		device.setIpAddress("192.168.1.25");
		device.setDeviceName("Frank's Computer");
		device.setMacAddress("mo:34:23:21:221:12");
		device.setDeviceInsrtDttm(Timestamp.valueOf("2018-01-01 02:02:00.324"));
		device.setDeviceUpdtDttm(Timestamp.valueOf("2018-01-03 02:09:00.324"));
		
		list.add(device);
		PersistDevice pd = new PersistDevice(list);
		pd.persist();
	}
}
