package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private String conUrl = "jdbc:sqlserver://localhost;"
			+ "databaseName = LotteryDB2;"
			+"user = JJ;"
			+"password = 12345;";
	private Connection con = null;
	private String query = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private ResultSetMetaData resultSetMetaData = null;
	
	private  void connectToSQL() {	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		}
		catch (ClassNotFoundException e) {
			System.out.println("Exception: " + e.toString());
		}
		try {
			con = DriverManager.getConnection(conUrl);
			//DatabaseMetaData metadata = con.getMetaData();
			//System.out.println(metadata.getDatabaseProductName());//獲取數據庫
		}
		catch(SQLException e) {
			System.out.println("Exception: " + e.toString());
		}
	}
	
	private String getUserNumber() {
		
		query = "select * from [LotteryDB].[dbo].[BigLottery]";

		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);//Query結果存在這裡
			if(resultSet!= null) {
				resultSetMetaData = resultSet.getMetaData();
			    int numberOfColumns = resultSetMetaData.getColumnCount();
			    while(resultSet.next()){
			    	for(int i = 1;i < numberOfColumns+1;i++) {
			    		String cn = resultSetMetaData.getColumnName(i);
			    		System.out.println(resultSet.getString(cn));
			    	}
			    }
			}
		}
		catch (SQLException e) {
			System.out.println(e.toString());
			
		}
		return "";
		
	}
	
	private String getUserNumber(String colName) {
		
		query = "select " + colName + " from [LotteryDB].[dbo].[BigLottery]";
		
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);//Query結果存在這裡
			
			if(resultSet != null) {
				resultSetMetaData = resultSet.getMetaData();
			    int numberOfColumns = resultSetMetaData.getColumnCount();
			    while(resultSet.next()){
			    	for(int i = 1;i < numberOfColumns+1;i++) {
			    		String cn = resultSetMetaData.getColumnName(i);
			    		System.out.println(resultSet.getString(cn));
			    	}
			    }
			}
			
		}
		catch (SQLException e) {
			System.out.println(e.toString());
			
		}
		return "";
		
	}
}
