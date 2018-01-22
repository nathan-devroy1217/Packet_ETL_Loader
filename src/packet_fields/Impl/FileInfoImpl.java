package packet_fields.Impl;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.HomeNetworkConstants;
import packet_fields.File_Info;

/**
 * FileInfo class defines files processed by
 * ETL loader
 * @author Nathan
 * @version 1/17/18
 */
public class FileInfoImpl implements File_Info {

	/** Status of file during load */
	private int fileStatus;
	
	/** Path of file */
	private String filePath;
	
	/** Name of file */
	private String fileName;
	
	/** File associated with FileInfo object */
	private File file;
	
	/** Time file is inserted into DB */
	private String insrtDttm;
	
	/** Time file is updated in DB */
	private String updtDttm;

	/**
	 * Constructor for FileInfoImpl
	 * @param file File to be processed
	 */
	public FileInfoImpl(File file) {
		setFile(file);
	}
	
	/**
	 * Overloaded constructor for FileInfoImpl
	 */
	public FileInfoImpl() {
		
	}
	
	/**
	 * Setter for fileStatus
	 */
	@Override
	public void setFileStatus(int fileStatus) {
		this.fileStatus = fileStatus;
	}

	/**
	 * Getter for fileStatus
	 */
	@Override
	public int getFileStatus() {
		return fileStatus;
	}

	/**
	 * Setter for filePath
	 */
	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;	
	}

	/**
	 * Getter for filePath
	 */
	@Override
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Setter for fileName
	 */
	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Getter for fileName
	 */
	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public File getFile() {
		return file;
	}
	
	public String getInsrtDttm() {
		return insrtDttm;
	}
	
	public void setInsrtDttm(String insrtDttm) {
		this.insrtDttm = insrtDttm;
	}
	
	public String getUpdtDttm() {
		return updtDttm;
	}
	
	public void setUpdtDttm(String updtDttm) {
		this.updtDttm = updtDttm;
	}
	
	/** Getter for fileKey */
	public int getFileKey() {
		Connection conn = null;
		ResultSet rs = null;
		Integer value = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(HomeNetworkConstants.url,
					HomeNetworkConstants.user, HomeNetworkConstants.password);
			Statement stmt = conn.createStatement();
			// Need to update SQL statement
			String sql = "select file_key from file_info where file_name=\"" + this.getFileName() + "\" and insert_dttm=\"" 
			+ this.getInsrtDttm() + "\";";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				value = rs.getInt("file_key");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
