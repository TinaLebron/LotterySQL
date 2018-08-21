package com.lottery.big;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class BigLottery2 {
	
	private String conUrl = "jdbc:sqlserver://localhost;"
			+ "databaseName = LotteryDB2;"
			+"user = JJ;"
			+"password = 12345;";
	private Connection con = null;
	private String query = null;
	private Statement stmt = null;
	private ResultSet resultSet = null;
	private ResultSetMetaData resultSetMetaData = null;
	
	public String getconUrl() {
		return this.conUrl;
	}
	public void setconUrl(String conUrl) {
		this.conUrl = conUrl;
	}
	
	public Connection getcon() {
		return this.con;
	}
	public void setcon(Connection con) {
		this.con = con;
	}
	public String getquery() {
		return this.query;
	}
	public void setquery(String query) {
		this.query = query;
	}
	public Statement getstmt() {
		return this.stmt;
	}
	public void setstmt(Statement stmt) {
		this.stmt = stmt;
	}
	public ResultSet getresultSet() {
		return this.resultSet;
	}
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	public ResultSetMetaData getresultSetMetaData() {
		return this.resultSetMetaData;
	}
	public void setresultSetMetaData(ResultSetMetaData resultSetMetaData) {
		this.resultSetMetaData = resultSetMetaData;
	}
	
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
	
	public static void main(String[]args) {
		BigLottery2 bigLottery2 = new BigLottery2();
		bigLottery2.connectToSQL();
		bigLottery2.getUserNumber("UserName");
	}

}
