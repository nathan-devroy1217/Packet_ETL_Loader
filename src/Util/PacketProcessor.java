package Util;

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
	public void processPacket() {
		//COMPLETE 
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
