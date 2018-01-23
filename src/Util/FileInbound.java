package Util;

import java.io.File;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import packet_fields.File_Info;
import packet_fields.Impl.FileInfoImpl;

/**
 * FileInbound processes file and updates DB tables when
 * file is run through system
 * @author Nathan
 * @version 1/19/18
 */
public class FileInbound {

	/** File being read by processor */
	private File file;
	
	/** FileInfo object to create */
	private FileInfoImpl fileInfo;
	
	/** DB connection */
	private Connection conn;
	
	/**
	 * Constructor for FileInbound
	 * @param file Inbound file to process
	 */
	public FileInbound(File file, Connection conn) {
		setFile(file);
		this.conn = conn;
		fileInfo = new FileInfoImpl(file, conn);
		processInboundFile();
	}

	/**
	 * Getter for fileInfo
	 * @return fileInfo
	 */
	public FileInfoImpl getFileInfo() {
		return fileInfo;
	}

	/**
	 * Setter for fileInfo
	 * @param fileInfo FileInfo object that will be populated
	 * when inbound file is received
	 */
	public void setFileInfo(FileInfoImpl fileInfo) {
		this.fileInfo = fileInfo;
	}
	
	/**
	 * Getter for file
	 * @return file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Setter for file
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * Populate file_info table with file metadata
	 */
	private void processInboundFile() {
		fileInfo.setFileName(file.getName());
		fileInfo.setFilePath(file.getAbsolutePath());
		fileInfo.setInsrtDttm(getCurrentTime());
		fileInfo.setUpdtDttm(getCurrentTime());
		fileInfo.setFileStatus(HomeNetworkConstants.fileLoadUnprocessed);

		PersistFileInfo pfi = new PersistFileInfo(fileInfo, conn);
		pfi.persist();
	}
	
	/**
	 * Update table columns for processing file
	 */
	public void updateFileProcessing() {
		PersistFileInfo pfi = new PersistFileInfo(this, conn);
		pfi.updateFileInfoProcessing();
	}
	
	/**
	 * Update table columns for successful file load
	 */
	public void updateFileSuccess() {
		PersistFileInfo pfi = new PersistFileInfo(this, conn);
		pfi.updateFileInfoSuccess();
	}
	
	/**
	 * Update table columns for failed file load
	 */
	public void updateFileFail() {
		PersistFileInfo pfi = new PersistFileInfo(this, conn);
		pfi.updateFileInfoFailed();
	}
	
	/**
	 * Method returns current date and time
	 * @return current date and time
	 */
	public String getCurrentTime() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return timeStamp;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
	
