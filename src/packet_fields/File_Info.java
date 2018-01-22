package packet_fields;

import java.io.File;

/**
 * Declaration of File_Info Interface
 * @author Nathan
 * @version 1/17/18
 */
public interface File_Info {
	
	/** Value of fileKey */
	final String file_key = "NULL";
		
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
	
	/** Setter for File */
	void setFile(File file);
	
	/** Getter for object */
	File getFile();
	
	/** Setter for insrtDttm */
	void setInsrtDttm(String dttm);
	
	/** Getter for insrtDttm */
	String getInsrtDttm();
	
	/** Setter for updtDttm */
	void setUpdtDttm(String updtDttm);
	
	/** Getter for updtDttm */
	String getUpdtDttm();
}
