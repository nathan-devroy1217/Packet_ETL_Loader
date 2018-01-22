package Tests;

import java.io.File;
import java.sql.Connection;

import Util.DBConnectUtil;
import Util.FileInbound;
import Util.FileProcessor;

/**
 * Test case to process files
 * @author Nathan
 * @version 1/19/18
 */
public class ProcessFileTest {

	/**
	 * Constructor for ProcessFileTest
	 */
	public ProcessFileTest() {
		
	}
	
	/**
	 * Process test file using traditional persistence flow
	 */
	public void processTestFile() {
		DBConnectUtil dbc = new DBConnectUtil();
		Connection conn = dbc.connectDB();
		File file = new File("packets1.txt");
		FileInbound inb = new FileInbound(file, conn);
		FileProcessor fp = new FileProcessor(inb, conn);
		fp.processFile();
		dbc.closeDB();
	}
	
	
}
