package Tests;

import java.util.ArrayList;

import Util.PersistFileInfo;
import packet_fields.Impl.FileInfoImpl;

/**
 * Test case for checking file key from file_info tables
 * @author Nathan
 * @version 1/19/18
 */
public class FileKeyTest {

	/**
	 * Constructor for FileKeyTest
	 */
	public FileKeyTest() {
	}
	
	/**
	 * Checks file key from file_info tables
	 */
	public void checkFileKey() {
		ArrayList<FileInfoImpl> list = new ArrayList<FileInfoImpl>();
		FileInfoImpl fileInfo = new FileInfoImpl();
		fileInfo.setFileStatus(2);
		fileInfo.setFilePath("/home/pi/files/");
		fileInfo.setFileName("testFile.dat");
		
		list.add(fileInfo);
		PersistFileInfo fi = new PersistFileInfo(list);
		fi.persist();
		
		System.out.println(fileInfo.getFileKey());
	}
}
