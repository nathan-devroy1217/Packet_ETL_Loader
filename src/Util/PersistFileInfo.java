package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import packet_fields.File_Info;
import packet_fields.Impl.FileInfoImpl;

/**
 * Persistence process for File Info
 * @author Nathan
 * @version 1/18/18
 */
public class PersistFileInfo extends PersistAbstract {

	/** JDBC connection string */
	private final String url = HomeNetworkConstants.url;

	/** Insert statement to DB */
	private Statement updtStmt = null;

	/** User name for DB connection */
	private final String user = HomeNetworkConstants.user;

	/** Password for DB connection */
	private final String password = HomeNetworkConstants.password;

	/** DB connection */
	private Connection conn = null;
	
	/** FileInbound object */
	private FileInbound inb;

	/** ArrayList of FileInfoImpl objects */
	private ArrayList<FileInfoImpl> data;

	/**
	 * Constructor for PersistFileInfo
	 * @param data List of FileInfo objects to persist
	 */
	public PersistFileInfo(ArrayList<FileInfoImpl> data) {
		this.data = data;
	}
	
	/**
	 * Overloaded method for FileInbound class
	 * @param inb FileInbound object to incorporate
	 */
	public PersistFileInfo(FileInbound inb) {
		this.inb = inb;
	}

	/**
	 * Persist a list of FileInfo objects
	 * @param data the list of FileInfo objects to persist to DB
	 */
	public void persist() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			for (FileInfoImpl item : data) {
				updtStmt = conn.createStatement();
				// Need to update SQL statement
				String sql = "insert into file_info(file_key, insert_dttm, update_dttm,"
						+ "file_status,file_path,file_name) values(" + File_Info.file_key +
						"," + File_Info.insrtDttm + "," + File_Info.updtDttm + 
						",\"" + item.getFileStatus() + "\",\"" + item.getFilePath() +
						"\",\"" + item.getFileName() + "\")";
				System.out.println(sql);
				updtStmt.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				System.out.println("Closing database connection....");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Update file_info table for file processing
	 */
	public void updateFileInfoProcessing() {
		System.out.println("Updating file_info table for file processing....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			updtStmt = conn.createStatement();
			// Need to update SQL statement
			String sql = "update file_info set file_status=" + HomeNetworkConstants.fileProcessing + 
					" where file_name=\"" + inb.getFileInfo().getFileName() + "\";";
			System.out.println(sql);
			updtStmt.executeUpdate(sql);
			System.out.println("File status updated!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				System.out.println("Closing database connection....");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Update file_info table for file load success
	 */
	public void updateFileInfoSuccess() {
		System.out.println("Updating file_info table for successful file load....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			updtStmt = conn.createStatement();
			// Need to update SQL statement
			String sql = "update file_info set file_status=" + HomeNetworkConstants.successfulFileLoad + 
					" where file_name=\"" + inb.getFileInfo().getFileName() + "\";";
			System.out.println(sql);
			updtStmt.executeUpdate(sql);
			System.out.println("File status updated!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				System.out.println("Closing database connection....");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Update file_info table for file_load fail
	 */
	public void updateFileInfoFailed() {
		System.out.println("Updating file_info table for failed file load....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			updtStmt = conn.createStatement();
			// Need to update SQL statement
			String sql = "update file_info set file_status=" + HomeNetworkConstants.failedFileLoad + 
					" where file_name=\"" + inb.getFileInfo().getFileName() + "\";";
			System.out.println(sql);
			updtStmt.executeUpdate(sql);
			System.out.println("File status updated!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				System.out.println("Closing database connection....");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}	
}
