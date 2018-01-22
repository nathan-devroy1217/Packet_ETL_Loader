package Tests;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Util.FileInbound;
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
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		ArrayList<FileInfoImpl> list = new ArrayList<FileInfoImpl>();
		FileInfoImpl fileInfo = new FileInfoImpl();
		fileInfo.setFileStatus(2);
		fileInfo.setInsrtDttm(timeStamp);
		fileInfo.setUpdtDttm(timeStamp);
		fileInfo.setFilePath("/home/pi/files/");
		fileInfo.setFileName("testFile.dat");
		
		list.add(fileInfo);
		PersistFileInfo fi = new PersistFileInfo(list);
		fi.persist();
		
		System.out.println("File key: " + fileInfo.getFileKey());
	}
	
	public void checkFileProcessing() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		ArrayList<FileInfoImpl> list = new ArrayList<FileInfoImpl>();
		FileInfoImpl fileInfo = new FileInfoImpl();
		fileInfo.setFileStatus(0);
		fileInfo.setInsrtDttm(timeStamp);
		fileInfo.setUpdtDttm(timeStamp);
		fileInfo.setFilePath("/home/pi/files/");
		fileInfo.setFileName("testFile.dat");
		
		list.add(fileInfo);
		PersistFileInfo fi = new PersistFileInfo(list);
		fi.persist();
		
		System.out.println("Check switch to processing on inbound file:");
		fi.updateFileInfoProcessing();
		
		System.out.println("Check switch to load failure on inbound file:");
		fi.updateFileInfoFailed();
		
		System.out.println("Check switch to load success on inbound file:");
		fi.updateFileInfoSuccess();
	}
}
