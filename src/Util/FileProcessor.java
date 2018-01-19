package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileProcessor takes file input,
 * creates objects, and routes to persistence
 * @author Nathan
 * @version 1/19/18
 */
public class FileProcessor {

	/** File being read by processor */
	private File file;
		
	/** FileErrors object to invoke and persist error cases */
	private PersistFileErrors fileErrors;
	
	/** Line denotes each line in file */
	private String line;
	
	/** FileInbound object containing file info and file itself */
	private FileInbound inb;

	/**
	 * Constructor for FileProcessor
	 * @param fileInb FileInbound object containing file info and file itself
	 */
	public FileProcessor(FileInbound fileInb) {
		file = fileInb.getFile();
		setInb(fileInb);
		line = null;
	}
	
	/**
	 * Processes file along with inbound processing
	 */
	public void processFile() {
		BufferedReader bufferedReader = null;
		try {
			//Start by setting file status as "in processing"
			inb.updateFileProcessing();
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				PacketProcessor pp = new PacketProcessor(inb, line.toString());
				pp.processPacket();
			}
			inb.updateFileSuccess();
			bufferedReader.close();
		} catch(FileNotFoundException e) {
			//Add error to file_errors table
			fileErrors = new PersistFileErrors(inb);
			fileErrors.populateErrorIntoTable(inb, e.toString());
			
			//Update file_info table
			inb.updateFileFail();
		} catch(IOException ex) {
			//Add error to file_errors table
			fileErrors = new PersistFileErrors(inb);
			fileErrors.populateErrorIntoTable(inb, ex.toString());
			
			//Update file_info table
			inb.updateFileFail();
		}
	}
	
	/**
	 * Getter for inb
	 * @return FileInbound object containing file info and file itself
	 */
	public FileInbound getInb() {
		return inb;
	}

	/**
	 * Setter for inb
	 * @param inb FileInbound object containing file info and file itself
	 */
	public void setInb(FileInbound inb) {
		this.inb = inb;
	}
}
