package packet_fields;

import java.sql.Timestamp;

/**
 * Declaration of Packet interface
 * @author Nathan
 * @version 1/16/18 
 */
public interface Packet {

	/** Setter for id */
	void setId(int id);
	
	/** Getter for id */
	int getId();
	
	/** Setter for accessDttm */
	void setAccessDttm(Timestamp accessDttm);
	
	/** Getter for accessDttm */
	Timestamp getAccessDttm(); 
	
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
	void setTcpSrcPort(int tcpSrcPort);
	
	/** Getter for tcpSrcPort */
	int getTcpSrcPort();
	
	/** Setter for tcpDstPort */
	void setTcpDstPort(int tcpDstPort);
	
	/** Getter for tcpDstPort */
	int getTcpDstPort();
	
	/** Setter for resolvedUri */
	void setResolvedUri(String resolvedUri);
	
	/** Getter for resolvedUri */
	String getResolvedUri();
}
