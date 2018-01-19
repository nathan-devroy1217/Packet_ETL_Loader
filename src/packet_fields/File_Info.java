package packet_fields;

/**
 * Declaration of File_Info Interface
 * @author Nathan
 * @version 1/17/18
 */
public interface File_Info {
	
	/** Value of fileKey */
	final String file_key = "NULL";
	
	/** Last insert */
	final String insrtDttm = "CURRENT_TIMESTAMP";
	
	/** Last update */
	final String updtDttm = "CURRENT_TIMESTAMP";
	
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
