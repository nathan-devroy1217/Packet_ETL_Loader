package Util;

import java.io.File;
import java.util.ArrayList;

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
	
	/**
	 * Constructor for FileInbound
	 * @param file Inbound file to process
	 */
	public FileInbound(File file) {
		fileInfo = new FileInfoImpl(file);
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
		fileInfo.setFileStatus(HomeNetworkConstants.fileLoadUnprocessed);
		
		ArrayList<FileInfoImpl> list = new ArrayList<FileInfoImpl>();
		list.add(fileInfo);
		PersistFileInfo pfi = new PersistFileInfo(list);
		pfi.persist();
	}
	
	/**
	 * Update table columns for processing file
	 */
	public void updateFileProcessing() {
		PersistFileInfo pfi = new PersistFileInfo(this);
		pfi.updateFileInfoProcessing();
	}
	
	/**
	 * Update table columns for successful file load
	 */
	public void updateFileSuccess() {
		PersistFileInfo pfi = new PersistFileInfo(this);
		pfi.updateFileInfoSuccess();
	}
	
	/**
	 * Update table columns for failed file load
	 */
	public void updateFileFail() {
		PersistFileInfo pfi = new PersistFileInfo(this);
		pfi.updateFileInfoFailed();
	}
}
