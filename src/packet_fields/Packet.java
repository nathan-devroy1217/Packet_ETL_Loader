package packet_fields;

import java.sql.Timestamp;

/**
 * Declaration of Packet interface
 * @author Nathan
 * @version 1/16/18 
 */
public interface Packet {
	
	/** Id of packet */
	final String id = "NULL";
	
	/** Setter for fileKey */
	void setFileKey(int fileKey);
	
	/** Getter for fileKey */
	int getFileKey();
	
	/** Setter for httpHost */
	void setHttpHost(String httpHost);
	
	/** Getter for httpHost */
	String getHttpHost();
	
	/** Setter for httpRequestUri */
	void setHttpRequestUri(String httpRequestUri);
	
	/** Getter for httpRequestUri */
	String getHttpRequestUri();
	
	/** Setter for srcIp */
	void setSrcIp(String srcIp);
	
	/** Getter for srcIp */
	String getSrcIp();
	
	/** Setter for dstIp */
	void setDstIp(String dstIp);
	
	/** Getter for dstIp */
	String getDstIp();
	
	/** Setter for tcpSrcPort */
	void setTcpSrcPort(String tcpSrcPort);
	
	/** Getter for tcpSrcPort */
	String getTcpSrcPort();
	
	/** Setter for tcpDstPort */
	void setTcpDstPort(String tcpDstPort);
	
	/** Getter for tcpDstPort */
	String getTcpDstPort();
	
	/** Setter for resolvedUri */
	void setResolvedUri(String resolvedUri);
	
	/** Getter for resolvedUri */
	String getResolvedUri();
	
	/** Setter for accessDttm */
	void setAccessDttm(String accessDttm);
	
	/** Getter for accessDttm */
	String getAccessDttm();
}
