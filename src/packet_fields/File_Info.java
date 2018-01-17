package packet_fields;

import java.sql.Timestamp;

/**
 * Declaration of File_Info Interface
 * @author Nathan
 * @version 1/17/18
 */
public interface File_Info {
	
	/** Value of fileKey */
	final String file_key = "NULL";
	
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
