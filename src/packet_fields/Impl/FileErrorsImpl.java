package packet_fields.Impl;


import packet_fields.File_Errors;

/**
 * FileErrors class defines errors in file load
 * @author Nathan
 * @version 1/17/18
 */
public class FileErrorsImpl implements File_Errors {

	/** File key for file */
	private int fileKey;
	
	/** Error message delivered to console */
	private String errorMsg;
	
	/**
	 * Setter for fileKey
	 */
	@Override
	public void setFileKey(int fileKey) {
		this.fileKey = fileKey;
	}

	/**
	 * Getter for fileKey
	 */
	@Override
	public int getFileKey() {
		return fileKey;
	}

	/**
	 * Setter for errorMsg
	 */
	@Override
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * Getter for errorMsg
	 */
	@Override
	public String getErrorMsg() {
		return errorMsg;
	}
}
