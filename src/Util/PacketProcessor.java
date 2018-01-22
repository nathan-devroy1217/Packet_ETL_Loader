package Util;

import java.util.HashMap;
import packet_fields.Impl.PacketImpl;

/**
 * Processes packet information by line
 * @author Nathan
 * @version 1/19/18
 */
public class PacketProcessor {

	/** FileInbound object containing important file data */
	private FileInbound inb;
	
	/** Line to be processed */
	private String line;
	
	/**
	 * Constructor for PacketProcessor
	 * @param inb FileInbound object containing important file data 
	 * @param line Line to be processed
	 */
	public PacketProcessor(FileInbound inb, String line) {
		setInb(inb);
		setLine(line);
	}
	
	/**
	 * This method will process packet data and
	 * persist it to the packet table
	 */
	public PacketImpl processPacket() {
		String[] strArr = line.split("\\*");
		if(strArr.length == 8) {
			PacketImpl packetImpl = new PacketImpl();
			
			packetImpl.setAccessDttm(processTime(strArr[0]));
			packetImpl.setFileKey(inb.getFileInfo().getFileKey());
			packetImpl.setHttpHost((strArr[1].length() != 0 ? strArr[1] : "NULL"));
			packetImpl.setHttpRequestUri((strArr[2].length() != 0 ? strArr[2] : "NULL"));
			packetImpl.setSrcIp(strArr[3]);
			packetImpl.setDstIp((strArr[4].length() != 0 ? strArr[4] : "NULL"));
			packetImpl.setTcpSrcPort((strArr[5].length() != 0 ? strArr[5] : "NULL"));
			packetImpl.setTcpDstPort((strArr[6].length() != 0 ? strArr[6] : "NULL"));
			packetImpl.setResolvedUri((strArr[7].length() != 0 ? strArr[7] : "NULL"));

			return packetImpl;
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
	
	/**
	 * Method returns current date and time
	 * @return current date and time
	 */
	public String processTime(String inputString) {
		String returnString = "";
		HashMap<String,String> map = new HashMap<String,String>();
		map = populateMap(map);
		String[] splitStr = inputString.split("\\s+");
		String month = map.get(splitStr[0]);
		String day = splitStr[1].substring(0, 2);
		String year = splitStr[2];
		String timestamp = splitStr[3].substring(0, 8);
		
		returnString = year + "-" + month + "-" + day + " " + timestamp;
		return returnString;
	}
	
	private HashMap<String,String> populateMap(HashMap<String, String> map) {
		map.put("Jan", "01");
		map.put("Feb", "02");
		map.put("Mar", "03");
		map.put("Apr", "04");
		map.put("May", "05");
		map.put("Jun", "06");
		map.put("Jul", "07");
		map.put("Aug", "08");
		map.put("Sept", "09");
		map.put("Oct", "10");
		map.put("Nov", "11");
		map.put("Dec", "12");
		
		return map;
	}
}
