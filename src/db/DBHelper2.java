package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper2 {
	/*使用者密碼**/
	private String DBname = "LotteryDB";
	private String user = "JJ";
	private String  password = "12345";
	
	/*連結Url**/
	private String conUrl = "jdbc:sqlserver://localhost;"
			+ "DBname = " + DBname + ";"
			+ "user = " + user + ";"
			+ "password = " + password + ";";
	
	private Connection      con = null;
	private Statement      stmt = null;
	private ResultSet resultSet = null;
	private ResultSetMetaData resultSetMetaData = null;
	
	
	private  void connectToSQL() {	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			con = DriverManager.getConnection(conUrl);
			DatabaseMetaData metadata = con.getMetaData();
			System.out.println("DatabaseProductName : " + metadata.getDatabaseProductName());//獲取數據庫
			if(! con.isClosed()) {	
				System.out.println("connect successed!");
			}
			else {
				System.out.println("connect failed");
			}
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.toString());
		}
		finally {
			
		}
	}
	
	private String getUserNumber() {
		
		String SQL = "select * from [LotteryDB].[dbo].[BigLottery]";

		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(SQL);//Query結果存在這裡
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
		
		String SQL = "select " + colName + " from [LotteryDB].[dbo].[BigLottery]";
		
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(SQL);//Query結果存在這裡
			
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
