package Util.Impl;

import java.sql.Statement;
import java.util.ArrayList;

import packet_fields.Impl.DeviceImpl;

/**
 * Persistence process for Device objects
 * @author Nathan
 * @version 1/18/18
 */
public class PersistDevice extends PersistAbstract {

	/** Get statement to DB */
	private Statement requestStmt = null;
	
	/** Insert statement to DB */
	private Statement updtStmt = null;
	
	/**
	 * Constructor for PersistDevice
	 * @param data Device object to persist
	 */
	public PersistDevice(DeviceImpl data) {
		super.dbConnect();
		//Stuff here needed
	}
	
	/**
	 * Constructor for PersistDevice
	 * @param data List of Device objects to persist
	 */
	public PersistDevice(ArrayList<DeviceImpl> data) {
		super.dbConnect();
		//Stuff here needed
	}
	
	/**
	 * Persist a list of Device objects
	 * @param data the list of Device objects to persist to DB
	 */
	public void persistDevice(ArrayList<DeviceImpl> data) {
		//Stuff here needed
	}

	/**
	 * Persist individual Device object
	 * @param data the Device object to persist to DB
	 */
	public void persistString(DeviceImpl data) {
		//Stuff here needed
	}
		
	/**
	 * Get Device data from DB
	 * @return ArrayList of Device objects 
	 */
	public ArrayList<DeviceImpl> getDevice() {
		ArrayList<DeviceImpl> data = null;
		//Stuff here needed
		return data;
	}
}
