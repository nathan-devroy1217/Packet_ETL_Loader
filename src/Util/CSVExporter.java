package Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import packet_fields.Device;

/**
 * Exporter class to push data to .csv files
 * @author Nathan
 * @version 2/7/18
 */
public class CSVExporter {

	/** From date for ranged query */
	private String fromDateTime;
	
	/** To date for ranged query */
	private String toDateTime;
	
	/** File path to which exporter will output file */
	private String filePath;
	
	/** DB connect instance */
	private DBConnectUtil dbConnectUtil;
	
	/** DB connection instance */
	private Connection connection;
	
	/**
	 * 
	 * @param filePath
	 * @param fromDateTime
	 * @param toDateTime
	 * @param executionEnvironment
	 */
	public CSVExporter(String filePath, String fromDateTime, String toDateTime, int executionEnvironment) {
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.filePath = filePath;
		 
		this.dbConnectUtil = new DBConnectUtil(executionEnvironment);
		this.connection = dbConnectUtil.connectDB();
		
	}
	
	/**
	 * Create CSV on date params
	 */
	public void createCsv() {
		String fileName = "filePath" + "/Devroy_Family_Network_Stats_" + fromDateTime + "--" + toDateTime + ".csv";	
		System.out.println(fileName);
		File file = new File(fileName);
		
		try {
			FileWriter fw = new FileWriter(file);
			Class.forName("com.mysql.jdbc.Driver");
			String query = HomeNetworkConstants.packetGetQuery;
			System.out.println(query);
		    Statement statement = connection.createStatement();
		    ResultSet rs = statement.executeQuery(query);
		    
		    //Print headers first, then print rows into CSV file
		    fw.append("Access Date");
		    fw.append("Device");
		    fw.append("Source IP");
		    fw.append("Site Visited");
		    
		    while(rs.next()) {
		    		fw.append(rs.getString(1));
		    		fw.append(rs.getString(2));
		    		fw.append(rs.getString(3));
		    		fw.append(rs.getString(4));
		    }
		    fw.flush();
		    fw.close();
		    System.out.println("File created successfully at " + file.getAbsolutePath());
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbConnectUtil.closeDB();
		}	
	}
}
/*

public class DbToCSV {
    public static void main(String[] args) {
        String filename ="Desktop:test.csv";
        try {
            FileWriter fw = new FileWriter(filename);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            String query = "select * from testtable";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append('\n');
               }
            fw.flush();
            fw.close();
            conn.close();
            System.out.println("CSV File is created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

*/