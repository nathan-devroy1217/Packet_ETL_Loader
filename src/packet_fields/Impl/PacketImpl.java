package packet_fields.Impl;

import java.sql.Timestamp;

import packet_fields.Packet;

/**
 * Packet class defines packet details transmitted 
 * via home network
 * @author Nathan
 * @version 1/17/18
 */
public class PacketImpl implements Packet {
	
	/** File key for packet */
	private int fileKey;
	
	/** HTTP host ID for packet */
	private String httpHost;
	
	/** HTTP URI designated to packet */
	private String httpRequestUri;
	
	/** Source IP address */
	private String srcIp;
	
	/** Destination IP address */
	private String dstIp;
	
	/** Source TCP port */
	private String tcpSrcPort;
	
	/** Destination TCP port */
	private String tcpDstPort;
	
	/** URI of packet transmitted */
	private String resolvedUri;
	
	/** Time packet inserted into DB */
	private String accessDttm;
		
	/**
	 * Getter for accessDttm
	 */
	public String getAccessDttm() {
		return accessDttm;
	}

	/**
	 * Setter for accessDttm
	 */
	public void setAccessDttm(String accessDttm) {
		this.accessDttm = accessDttm;
	}

	/**
	 * Setter for fileKey
	 */
	@Override
	public void setFileKey(int fileKey) {
		this.fileKey = fileKey;
	}

	/**
	 * Getter for fileKey
	 */
	@Override
	public int getFileKey() {
		return fileKey;
	}

	/**
	 * Setter for httpHost
	 */
	@Override
	public void setHttpHost(String httpHost) {
		this.httpHost = httpHost;
	}

	/**
	 * Getter for httpHost
	 */
	@Override
	public String getHttpHost() {
		return httpHost;
	}

	/**
	 * setter for httpRequestUri
	 */
	@Override
	public void setHttpRequestUri(String httpRequestUri) {
		this.httpRequestUri = httpRequestUri;
	}
	
	/**
	 * Getter for httpRequestUri
	 */
	@Override
	public String getHttpRequestUri() {
		return httpRequestUri;
	}

	/**
	 * Setter for srcIp
	 */
	@Override
	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}
	
	/**
	 * Getter for srcIp
	 */
	@Override
	public String getSrcIp() {
		return srcIp;
	}

	/**
	 * Setter for dstIp
	 */
	@Override
	public void setDstIp(String dstIp) {
		this.dstIp = dstIp;
	}

	/**
	 * Getter for dstIp
	 */
	@Override
	public String getDstIp() {
		return dstIp;
	}

	/**
	 * Setter for tcpSrcPort
	 */
	@Override
	public void setTcpSrcPort(String tcpSrcPort) {
		this.tcpSrcPort = tcpSrcPort;
	}

	/**
	 * Getter for tcpSrcPort
	 */
	@Override
	public String getTcpSrcPort() {
		return tcpSrcPort;
	}

	/**
	 * Setter for tcpDstPort
	 */
	@Override
	public void setTcpDstPort(String tcpDstPort) {
		this.tcpDstPort = tcpDstPort;
	}

	/**
	 * Getter for tcpDstPort
	 */
	@Override
	public String getTcpDstPort() {
		return tcpDstPort;
	}

	/**
	 * Setter for resolvedUri
	 */
	@Override
	public void setResolvedUri(String resolvedUri) {
		this.resolvedUri = resolvedUri;
	}

	/**
	 * Getter for resolvedUri
	 */
	@Override
	public String getResolvedUri() {
		return resolvedUri;
	}
}
