import Tests.PacketInsertTest;

/**
 * Driver for Packet_ETL_Loader
 * @author Nathan
 * @version 1/18/18
 */
public class Driver {

	public static void main(String[] args) {
		PacketInsertTest test = new PacketInsertTest();
		
		//*********************************
		//Uncomment to initiate test cases
		//*********************************
		//test.persistToDeviceDataTest();
		//test.persistToEmailClientDataTest();
		//test.persistToFileErrorsTest();
		//test.persistToFileInfoTest();
		//test.persistToPacketTest();
	}

}
