import Tests.FileKeyTest;
import Tests.PacketInsertTest;
import Tests.ProcessFileTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Driver for Packet_ETL_Loader
 * @author Nathan
 * @version 1/18/18
 */
public class Driver {

	public static void main(String[] args) {
		PacketInsertTest test = new PacketInsertTest();
		FileKeyTest fKTest = new FileKeyTest();
		ProcessFileTest pft = new ProcessFileTest();
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
			
	}
}
