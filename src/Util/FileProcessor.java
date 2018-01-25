package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import packet_fields.Impl.DeviceImpl;
import packet_fields.Impl.PacketImpl;

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
	
	/** ArrayList of PacketImpl objects */
	private ArrayList<PacketImpl> packetList;
	
	/** ArrayList of DeviceImpl objects */
	private ArrayList<DeviceImpl> deviceList;
	
	/** DB connection */
	private Connection conn;
	/**
	 * Constructor for FileProcessor
	 * @param fileInb FileInbound object containing file info and file itself
	 */
	public FileProcessor(FileInbound fileInb, Connection conn) {
		file = fileInb.getFile();
		setInb(fileInb);
		line = null;
		this.conn = conn;
	}
	
	/**
	 * Process device file
	 */
	public void processDeviceFile() {
		BufferedReader bufferedReader = null;
		deviceList = new ArrayList<DeviceImpl>();
		try {
			inb.updateFileProcessing();
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				//Add processed device objects to deviceList
				DeviceProcessor dp = new DeviceProcessor(inb, line.toString());
				DeviceImpl deviceLine = dp.processDevice();	
				PersistDevice persistDevice = new PersistDevice(deviceLine, conn);
				persistDevice.persist();
			}
			//Update file_info table for successful load
			inb.updateFileSuccess();
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			fileErrors = new PersistFileErrors(inb);
			fileErrors.populateErrorIntoTable(inb, ex.toString());
		} catch (IOException ex) {
			fileErrors = new PersistFileErrors(inb);
			fileErrors.populateErrorIntoTable(inb, ex.toString());
		}
	}

	/**
	 * Processes file along with inbound processing
	 */
	public void processFile() {
		BufferedReader bufferedReader = null;
		packetList = new ArrayList<PacketImpl>();
		try {
			//Start by setting file status as "in processing"
			inb.updateFileProcessing();
			FileReader fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
				//Add processed packet objects to packetList
				PacketProcessor pp = new PacketProcessor(inb, line.toString());
				PacketImpl procPacket = pp.processPacket();
				PersistPacket persistPacket = new PersistPacket(procPacket, conn);
				persistPacket.persist();
				
			}
					
			//Update file_info table for successful load
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
