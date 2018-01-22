package Util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import packet_fields.File_Errors;
import packet_fields.Impl.FileErrorsImpl;

/**
 * Persistence process for File Errors
 * @author Nathan
 * @version 1/18/18
 */
public class PersistFileErrors {

	/** Insert statement to DB */
	private Statement updtStmt = null;

	/** DB connection */
	private Connection conn;

	/** Data list of FileErrorsImpl objects */
	private ArrayList<FileErrorsImpl> data;
	
	/** FileInbound wrapper containing file data */
	private FileInbound inb;

	/**
	 * Constructor for PersistFileErrors
	 * @param data List of FileErrors objects to persist
	 */
	public PersistFileErrors(ArrayList<FileErrorsImpl> data, Connection conn) {
		this.data = data;
		this.conn = conn;
	}
	
	/**
	 * Overloaded constructor with FileInbound type
	 * @param inb FileInbound object with key file info
	 */
	public PersistFileErrors(FileInbound inb) {
		this.inb = inb;
	}

	/**
	 * Persist a list of FileError objects
	 * @param data the list of FileError objects to persist to DB
	 */
	public void persist() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for (FileErrorsImpl item : data) {
				updtStmt = conn.createStatement();
				String sql = "insert into file_errors(file_key,insert_dttm,update_dttm,error_msg)"
						+ " values(" + item.getFileKey() + "," + File_Errors.insrtDttm + "," + 
						File_Errors.updtDttm + ",\"" + item.getErrorMsg() + "\");";
				System.out.println(sql);
				updtStmt.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Persist errors to error table
	 * @param inb FileInbound wrapper with file data
	 * @param errMsg Error message to populate
	 */
	public void populateErrorIntoTable(FileInbound inb, String errMsg) {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			updtStmt = conn.createStatement();
			String sql = "insert into file_errors(file_key,insert_dttm,update_dttm,error_msg)" + " values("
					+ inb.getFileInfo().getFileKey() + "," + File_Errors.insrtDttm + "," + File_Errors.updtDttm + ",\""
					+ errMsg + "\");";
			System.out.println(sql);
			updtStmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
