package packet_fields.Impl;


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
}
