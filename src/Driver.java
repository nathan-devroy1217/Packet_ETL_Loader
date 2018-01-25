import Tests.FileKeyTest;
import Tests.PacketInsertTest;
import Tests.ProcessFileTest;
import Util.DBConnectUtil;
import Util.FileInbound;
import Util.FileProcessor;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;

/**
 * Driver for Packet_ETL_Loader
 * @author Nathan
 * @version 1/18/18
 */
public class Driver {

	/**
	 * Driver for Packet_ETL_Loader
	 * @param args input arguments
	 */
	public static void main(String[] args) {

		/*
		 * args[0] ==> File to load
		 * args[1] ==> Execution environment: 1 = local dev
		 * 									  2 = remote (rpi)
		 */
		
		// Open database connection to TST
		int executionEnvironment = Integer.parseInt(args[1]);
		DBConnectUtil dbc = new DBConnectUtil(executionEnvironment);
		Connection conn = dbc.connectDB();
		File file = new File(args[0]);
	
		FileInbound inb = new FileInbound(file, conn);
		FileProcessor fp = new FileProcessor(inb, conn);
		fp.processFile();
		
		
		
		//PacketInsertTest test = new PacketInsertTest(conn);
		//FileKeyTest fKTest = new FileKeyTest(conn);
		//ProcessFileTest pft = new ProcessFileTest(conn);
		//*********************************
		//Uncomment to initiate test persistence cases
		//*********************************
		//test.persistToDeviceDataTest();
		//test.persistToEmailClientDataTest();
		//test.persistToFileErrorsTest();
		//test.persistToFileInfoTest();
		//test.persistToPacketTest();
		
		//*********************************
		//Uncomment to initiate file key test cases
		//*********************************
		//fKTest.checkFileKey();
		//fKTest.checkFileProcessing();
		
		//*********************************
		//Uncomment to initiate file processing test case
		//*********************************
		//pft.processTestFile();
		
		// Close database connection
		dbc.closeDB();
	}
}
