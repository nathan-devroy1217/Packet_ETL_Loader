package packet_fields.Impl;

import java.sql.Timestamp;

import packet_fields.File_Errors;

/**
 * FileErrors class defines errors in file load
 * @author Nathan
 * @version 1/17/18
 */
public class FileErrorsImpl implements File_Errors {

	/** File key for file */
	private int fileKey;
	
	/** Date of file error insert */
	private Timestamp insrtDttm;
	
	/** Date of file error update */
	private Timestamp updtDttm;
	
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
	 * Setter for insrtDttm
	 */
	@Override
	public void setInsrtDttm(Timestamp insrtDttm) {
		this.insrtDttm = insrtDttm;
	}

	/**
	 * Getter for insrtDttm
	 */
	@Override
	public Timestamp getInsrtDttm() {
		return insrtDttm;
	}

	/**
	 * Setter for updtDttm
	 */
	@Override
	public void setUpdtDttm(Timestamp updtDttm) {
		this.updtDttm = updtDttm;
	}

	/**
	 * Getter for updtDttm
	 */
	@Override
	public Timestamp getUpdtDttm() {
		return updtDttm;
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
