package Util;

public class HomeNetworkConstants {

	public static final int fileLoadUnprocessed = 0;
	public static final int fileProcessing = 1;
	public static final int successfulFileLoad = 2;
	public static final int failedFileLoad = 3;
	public static final String urlLocal = "jdbc:mysql://192.168.1.15:3306/home_network_tst";
	public static final String urlRemote = "jdbc:mysql://127.0.0.1:3306/home_network_tst";
	public static final String localUser = "nathan";
	public static final String remoteUser = "root";
	public static final String password = "Elijah1027";
	private static String toDateTime;
	private static String fromDateTime;
	public static final String packetGetQuery = 
			"select \n" + 
			"packet.access_dttm, \n" + 
			"device.device_name,\n" + 
			"packet.src_ip, \n" + 
			"packet.resolved_url \n" + 
			"from packet \n" + 
			"inner join device \n" + 
			"on (device.ip_address = packet.src_ip) \n" +
			"order by access_dttm desc \n" +
			"where access_dttm between \n" + 
			fromDateTime + " and " + toDateTime + "\n" +
			" limit 4000;";
}
