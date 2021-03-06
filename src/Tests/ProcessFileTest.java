package Tests;

import java.io.File;
import java.sql.Connection;

import Util.DBConnectUtil;
import Util.DeviceProcessor;
import Util.FileInbound;
import Util.FileProcessor;

/**
 * Test case to process files
 * @author Nathan
 * @version 1/19/18
 */
public class ProcessFileTest {

	/** DB Connection */
	private Connection conn;
	
	/**
	 * Constructor for ProcessFileTest
	 */
	public ProcessFileTest(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * Process test file using traditional persistence flow
	 */
	public void processTestFile() {
		File file = new File("filteredPackets.txt");
		FileInbound inb = new FileInbound(file, conn);
		FileProcessor fp = new FileProcessor(inb, conn);
		fp.processFile();
	}
	
	/**
	 * Test case to process device file to device tables
	 */
	public void processTestDeviceFile() {
		DBConnectUtil dbc = new DBConnectUtil(1);
		Connection conn = dbc.connectDB();
		File file = new File("arp_request.txt");
		FileInbound inb = new FileInbound(file, conn);
		FileProcessor dp = new FileProcessor(inb, conn);
		dp.processDeviceFile();
		dbc.closeDB();
	}
}
