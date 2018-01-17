package packet_fields;

import java.sql.Timestamp;

/**
 * Interface Declaration for File_Errors
 * @author Nathan
 * @version 1/17/18
 */
public interface File_Errors {

	/** Setter for fileKey */
	void setFileKey(int fileKey);
	
	/** Getter for fileKey */
	int getFileKey();
	
	/** Setter for insrtDttm */
	void setInsrtDttm(Timestamp insrtDttm);
	
	/** Getter for insrtDttm */
	Timestamp getInsrtDttm();
	
	/** Setter for updtDttm */
	void setUpdtDttm(Timestamp updtDttm);
	
	/** Getter for updtDttm */
	Timestamp getUpdtDttm();
	
	/** Setter for errorMsg */
	void setErrorMsg(String errorMsg);
	
	/** Getter for errorMsg */
	String getErrorMsg();
}
