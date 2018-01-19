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
	
	/** Setter for fileStatus */
	void setFileStatus(int fileStatus);
	
	/** Getter for fileStatus */
	int getFileStatus();

	/** Setter for filePath */
	void setFilePath(String filePath);
	
	/** Getter for filePath */
	String getFilePath();
	
	/** Setter for fileName */
	void setFileName(String fileName);
	
	/** Getter for fileName */
	String getFileName();
}
