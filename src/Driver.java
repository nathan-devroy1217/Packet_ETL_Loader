import Tests.FileKeyTest;
import Tests.PacketInsertTest;
import Tests.ProcessFileTest;
import Util.CSVExporter;
import Util.DBConnectUtil;
import Util.FileInbound;
import Util.FileProcessor;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;

/**
 * Driver for Packet_ETL_Loader
 * 
 * @author Nathan
 * @version 1/18/18
 */
public class Driver {

	/**
	 * Driver for Packet_ETL_Loader
	 * 
	 * @param args
	 *            input arguments
	 * @throws Exception
	 */
	public static void main(String[] args) {
		System.out.println("DOGGY DOO");

		/*
		 * args[0] ==> File to load args[1] ==> Execution environment: 1 = local dev 2 =
		 * remote (rpi) args[2] ==> Process packet load OR device load: "Packet" =
		 * packet load "Device" = device load
		 */
		
		String filePath = new String("/Users/emilydevroy/eclipse-workspace/Packet_ETL_Loader");
		String fromDateTime = "2018-02-06 00:00:00";
		String toDateTime = "2018-02-07 00:00:00";
		CSVExporter ex = new CSVExporter(filePath, fromDateTime, toDateTime, 1);
		ex.createCsv();

		// PacketInsertTest test = new PacketInsertTest(conn);
		// FileKeyTest fKTest = new FileKeyTest(conn);
		// ProcessFileTest pft = new ProcessFileTest(conn);
		// *********************************
		// Uncomment to initiate test persistence cases
		// *********************************
		// test.persistToDeviceDataTest();
		// test.persistToEmailClientDataTest();
		// test.persistToFileErrorsTest();
		// test.persistToFileInfoTest();
		// test.persistToPacketTest();

		// *********************************
		// Uncomment to initiate file key test cases
		// *********************************
		// fKTest.checkFileKey();
		// fKTest.checkFileProcessing();

		// *********************************
		// Uncomment to initiate file processing test case
		// *********************************
		// pft.processTestFile();
		// pft.processTestDeviceFile();
		// Close database connection
		
		
		/*
		int executionEnvironment = Integer.parseInt(args[1]);
		String loadSpec = args[2];
		DBConnectUtil dbc = new DBConnectUtil(executionEnvironment);
		Connection conn = dbc.connectDB();
		File file = new File(args[0]);

		FileInbound inb = new FileInbound(file, conn);
		FileProcessor fp = new FileProcessor(inb, conn);

		if (loadSpec.equals("Packet")) {
			fp.processFile();
		} else if (loadSpec.equals("Device")) {
			fp.processDeviceFile();
		}
		dbc.closeDB();
		*/
	}
}
