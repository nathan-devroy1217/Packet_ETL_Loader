package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

	/** JDBC connection string */
	private final String url = HomeNetworkConstants.url;

	/** Insert statement to DB */
	private Statement updtStmt = null;

	/** User name for DB connection */
	private final String user = HomeNetworkConstants.user;

	/** Password for DB connection */
	private final String password = HomeNetworkConstants.password;

	/** DB connection */
	private Connection conn = null;

	private ArrayList<PacketImpl> data;

	/**
	 * Constructor for PersistPacket
	 * @param data List of Packet objects to persist
	 */
	public PersistPacket(ArrayList<PacketImpl> data) {
		this.data = data;
	}

	/**
	 * Persist a list of Packet objects
	 * @param data the list of Packet objects to persist to DB
	 */
	public void persist() {
		System.out.println("Attempting to connect to database....");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			for (PacketImpl item : data) {
				updtStmt = conn.createStatement();
				String sql = "insert into packet(id,access_dttm,file_key,http_host,"
						+ "http_request_uri,src_ip,dst_ip,tcp_src_port,tcp_dst_port,resolved_url) "
						+ "values(" + Packet.id + "," + Packet.accessDttm +
						"," + item.getFileKey() + ",\"" + item.getHttpHost() + "\",\"" + item.getHttpRequestUri() +
						"\",\"" + item.getSrcIp() + "\",\"" + item.getDstIp() + "\"," + item.getTcpSrcPort() +
						"," + item.getTcpDstPort() + ",\"" + item.getResolvedUri() + "\");";
				System.out.println(sql);
				updtStmt.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				System.out.println("Closing database connection....");
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
