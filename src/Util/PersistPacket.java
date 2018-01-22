package Util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import packet_fields.Packet;
import packet_fields.Impl.PacketImpl;

/**
 * Persistence process for Packet
 * @author Nathan
 * @version 1/19/18
 */
public class PersistPacket {

	/** Insert statement to DB */
	private Statement updtStmt = null;

	/** DB connection */
	private Connection conn = null;

	private ArrayList<PacketImpl> data;

	/**
	 * Constructor for PersistPacket
	 * @param data List of Packet objects to persist
	 */
	public PersistPacket(ArrayList<PacketImpl> data, Connection conn) {
		this.data = data;
		this.conn = conn;
	}
	
	/**
	 * Persist a list of Packet objects
	 * @param data the list of Packet objects to persist to DB
	 */
	public void persist() {
		try {
			for (PacketImpl item : data) {
				if(item != null) {
					updtStmt = conn.createStatement();
					String sql = "insert into packet(id,access_dttm,file_key,http_host,"
							+ "http_request_uri,src_ip,dst_ip,tcp_src_port,tcp_dst_port,resolved_url) "
							+ "values(" + Packet.id + ",\"" + item.getAccessDttm() +
							"\"," + item.getFileKey() + ",\"" + item.getHttpHost() + "\",\"" + item.getHttpRequestUri() +
							"\",\"" + item.getSrcIp() + "\",\"" + item.getDstIp() + "\"," + item.getTcpSrcPort() +
							"," + item.getTcpDstPort() + ",\"" + item.getResolvedUri() + "\");";
					System.out.println(sql);
					updtStmt.executeUpdate(sql);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
