package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import packet_fields.Impl.PacketImpl;

/**
 * Persistence process for Packet
 * @author ndevroy
 *
 */
public class PersistPacket extends PersistAbstract {

	/** JDBC connection string */
	private final String url = super.url;

	/** Insert statement to DB */
	private Statement updtStmt = null;

	/** User name for DB connection */
	private final String user = super.user;

	/** Password for DB connection */
	private final String password = super.password;

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
						+ "http_request_uri,src_ip,dst_ip,tsp_src_port,tcp_dst_port,resolved_url) "
						+ "values(" + item.getId() + "," + item.getAccessDttm() +
						"," + item.getFileKey() + "," + item.getHttpHost() + "," + item.getHttpRequestUri() +
						"," + item.getSrcIp() + "," + item.getDstIp() + "," + item.getTcpSrcPort() +
						"," + item.getTcpDstPort() + "," + item.getResolvedUri() + ")";
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
