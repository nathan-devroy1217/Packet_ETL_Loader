package Tests;

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
		client.setClientName("Charles");
		client.setEmailAddress("charlesjohnson@gmail.com");
		client.setIsActive(true);
		
		list.add(client);
		PersistEmailClient pec = new PersistEmailClient(list);
		pec.persist();
	}
	
	/**
	 * Persist data to file errors table
	 */
	public void persistToFileErrorsTest() {
		ArrayList<FileErrorsImpl> list = new ArrayList<FileErrorsImpl>();
		FileErrorsImpl fileErrors = new FileErrorsImpl();
		fileErrors.setFileKey(1);
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
		
		list.add(device);
		PersistDevice pd = new PersistDevice(list);
		pd.persist();
	}
}
