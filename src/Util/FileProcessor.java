package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import packet_fields.Impl.FileErrorsImpl;

/**
 * FileProcessor takes file input,
 * creates objects, and routes to persistence
 * @author Nathan
 * @version 1/19/18
 */
public class FileProcessor {

	/** File being read by processor */
	private File file;
	
	private FileErrorsImpl fileErrors;
	
	/** FileInbound object containing file info and file itself */
	private FileInbound inb;

	/**
	 * Constructor for FileProcessor
	 * @param fileInb FileInbound object containing file info and file itself
	 */
	public FileProcessor(FileInbound fileInb) {
		file = fileInb.getFile();
		String line = null;
	}
	
	/**
	 * Processes file along with inbound processing
	 */
	public void processFile() {
		try {
			//Start by setting file status as "in processing"
			inb.updateFileProcessing();
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			//Need to continue here. Read file and spit out.
			//Maybe start with reading and validating data set,
			//...then populating to DB
			/*
			 * 
			 * 
			 * 
			 * 
			 */			
			inb.updateFileSuccess();
		} catch(FileNotFoundException ex) {
			// NEED TO POPULATE FILE_ERRORS OBJECT TO CATCH ERRORS
			inb.updateFileFail();
		} catch(IOException ex) {
			// NEED TO POPULATE FILE_ERRORS OBJECT TO CATCH ERRORS
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
