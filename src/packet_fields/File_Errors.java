package packet_fields;

/**
 * Interface Declaration for File_Errors
 * @author Nathan
 * @version 1/17/18
 */
public interface File_Errors {

	/** Last insert */
	final String insrtDttm = "CURRENT_TIMESTAMP";
	
	/** Last update */
	final String updtDttm = "CURRENT_TIMESTAMP";
	
	/** Setter for fileKey */
	void setFileKey(int fileKey);
	
	/** Getter for fileKey */
	int getFileKey();
	
	/** Setter for errorMsg */
	void setErrorMsg(String errorMsg);
	
	/** Getter for errorMsg */
	String getErrorMsg();
}
