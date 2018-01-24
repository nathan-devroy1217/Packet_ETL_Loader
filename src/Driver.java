import Tests.FileKeyTest;
import Tests.PacketInsertTest;
import Tests.ProcessFileTest;
import Util.DBConnectUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;

/**
 * Driver for Packet_ETL_Loader
 * @author Nathan
 * @version 1/18/18
 */
public class Driver {

	public static void main(String[] args) {
		// Open database connection to TST
		DBConnectUtil dbc = new DBConnectUtil();
		Connection conn = dbc.connectDB();
		
		PacketInsertTest test = new PacketInsertTest(conn);
		FileKeyTest fKTest = new FileKeyTest(conn);
		ProcessFileTest pft = new ProcessFileTest(conn);
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
		pft.processTestFile();
		
		// Close database connection
		dbc.closeDB();
	}
}
