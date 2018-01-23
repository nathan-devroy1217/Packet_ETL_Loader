package Util;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import packet_fields.File_Info;
import packet_fields.Impl.FileInfoImpl;

/**
 * Persistence process for File Info
 * @author Nathan
 * @version 1/18/18
 */
public class PersistFileInfo {

	/** Insert statement to DB */
	private Statement updtStmt = null;

	/** DB connection */
	private Connection conn;
	
	/** FileInbound object */
	private FileInbound inb;

	/** ArrayList of FileInfoImpl objects */
	private FileInfoImpl data;

	/**
	 * Constructor for PersistFileInfo
	 * @param data List of FileInfo objects to persist
	 */
	public PersistFileInfo(FileInfoImpl data, Connection conn) {
		this.data = data;
		this.conn = conn;
	}
	
	/**
	 * Method returns current date and time
	 * @return current date and time
	 */
	public String getCurrentTime() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	
	/**
	 * Overloaded method for FileInbound class
	 * @param inb FileInbound object to incorporate
	 */
	public PersistFileInfo(FileInbound inb, Connection conn) {
		this.inb = inb;
		this.conn = conn;
	}

	/**
	 * Persist a list of FileInfo objects
	 * @param data the list of FileInfo objects to persist to DB
	 */
	public void persist() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
				updtStmt = conn.createStatement();
				// Need to update SQL statement
				String sql = "insert into file_info(file_key, insert_dttm, update_dttm,"
						+ "file_status,file_path,file_name) values(" + File_Info.file_key +
						",\"" + data.getInsrtDttm() + "\",\"" + data.getUpdtDttm() + 
						"\"," + data.getFileStatus() + ",\"" + data.getFilePath() +
						"\",\"" + data.getFileName() + "\")";
				System.out.println(sql);
				updtStmt.executeUpdate(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Update file_info table for file processing
	 */
	public void updateFileInfoProcessing() {
		System.out.println("Updating file_info table for file processing....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			updtStmt = conn.createStatement();
			// Need to update SQL statement
			String sql = "update file_info set file_status=" + HomeNetworkConstants.fileProcessing + 
					" where file_name=\"" + 
					(data != null ? data.getFileName() : inb.getFileInfo().getFileName()) 
					+ "\" and file_key=" + 
					(data != null ? data.getFileKey() : inb.getFileInfo().getFileKey()) 
					+ ";";
			System.out.println(sql);
			updtStmt.executeUpdate(sql);
			System.out.println("File status updated!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Update file_info table for file load success
	 */
	public void updateFileInfoSuccess() {
		System.out.println("Updating file_info table for successful file load....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			updtStmt = conn.createStatement();
			// Need to update SQL statement
			String sql = "update file_info set file_status=" + HomeNetworkConstants.successfulFileLoad + 
					" where file_name=\"" + 
					(data != null ? data.getFileName() : inb.getFileInfo().getFileName()) 
					+ "\" and file_key=" + 
					(data != null ? data.getFileKey() : inb.getFileInfo().getFileKey()) 
					+ ";";
			System.out.println(sql);
			updtStmt.executeUpdate(sql);
			System.out.println("File status updated!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Update file_info table for file_load fail
	 */
	public void updateFileInfoFailed() {
		System.out.println("Updating file_info table for failed file load....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			updtStmt = conn.createStatement();
			// Need to update SQL statement
			String sql = "update file_info set file_status=" + HomeNetworkConstants.failedFileLoad + 
					" where file_name=\"" + data.getFileName() + "\" and file_key=" + 
					data.getFileKey() + ";";
			System.out.println(sql);
			updtStmt.executeUpdate(sql);
			System.out.println("File status updated!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
