package Util;

import packet_fields.Impl.DeviceImpl;
import packet_fields.Impl.PacketImpl;

public class DeviceProcessor {

	/** FileInbound object containing important file data */
	private FileInbound inb;
	
	/** Line to be processed */
	private String line;
	
	/**
	 * Constructor for PacketProcessor
	 * @param inb FileInbound object containing important file data 
	 * @param line Line to be processed
	 */
	public DeviceProcessor(FileInbound inb, String line) {
		setInb(inb);
		setLine(line);
	}
	
	/**
	 * This method will process packet data and
	 * persist it to the packet table
	 */
	public DeviceImpl processDevice() {
		String[] strArr = line.split("\\s+");
		if(strArr.length == 3) {
			DeviceImpl deviceImpl = new DeviceImpl();
			deviceImpl.setIpAddress(strArr[0]);
			deviceImpl.setMacAddress(strArr[1]);
			
			StringBuilder sb = new StringBuilder();
			for(int i = 2; i < strArr.length; i++) {
				sb.append(strArr[i] + " ");
			}
			deviceImpl.setDeviceName(sb.toString());
			
			return deviceImpl;
		}
		return null;
	}
	
	/**
	 * Setter for inb
	 * @param inb FileInbound object containing important file data 
	 */
	public void setInb(FileInbound inb) {
		this.inb = inb;
	}

	/**
	 * Getter for line
	 * @param line Line to be processed
	 */
	public void setLine(String line) {
		this.line = line;
	}	
}
