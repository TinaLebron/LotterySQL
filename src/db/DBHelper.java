package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lottery.model.BigLottery;;

public class DBHelper {
	/*�ϥΪ̱b�K**/
	private final String DBName = "LotteryDB";
	private final String user     = "JJ";
	private final String password = "12345";
	
	
	/*�s�uurl**/
	private final String conUrl = "jdbc:sqlserver://localhost;"
			+ "databaseName = " + DBName + ";"
			+ "user = "         + user     + ";" 
			+ "password = "     + password + ";";
	
	/***/
	private Connection      con = null;
	private Statement      stmt = null;
	private ResultSet resultSet = null;
	private ResultSetMetaData resultSetMetaData = null;
	
	
	/**
	 *�s���ƾڮw(SQL)
	 **/
	public void connectToSQL() {	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(conUrl);
			DatabaseMetaData metadata = con.getMetaData();
			System.out.println("Database Product Name : " + metadata.getDatabaseProductName());//����ƾڮw
			if(!con.isClosed()) 
				System.out.println("connect successed!");
			else
				System.out.println("connect failed");
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
		finally {
			//getUserNumber();
			ArrayList<BigLottery> bigLotteries = selectAllFromBigLottery("BigLottery");
			for (BigLottery bigLottery : bigLotteries) {
				System.out.println("ID: "         + bigLottery.getID() + "   " + 
						           "UserName: "   + bigLottery.getUserName() +  "   " + 
						           "PickNumber: " + bigLottery.getPickNumber());
			}
		}
	
	}
	
	/**
	 *�����ƾڳs��
	 **/
	public void closeAll(ResultSet resultSet,Connection con,Statement stmt) {
		try {
			if(resultSet != null){
				resultSet.close();
			}
			if(con != null){
				con.close();
			}
			if(stmt != null){
				stmt.close();
			}
		}
		catch (Exception e){
			System.out.println(e.toString());
		}

	}
	
	/**
	 *�d��BigLottery��ƪ�
	 *@param table name
	 *@return �^��List<BigLottery>���
	 **/
	public ArrayList<BigLottery> selectAllFromBigLottery(String table) {
		String sql = "select * from [" + DBName + "].[dbo].[" + table + "]";
		ArrayList<BigLottery> bigLotteries = new ArrayList<BigLottery>();
		String ID = "";
		String userName = "";
		String pickNumber = "";

		try {
			int numberOfColumns = -1;
			
			if(con != null)
				stmt = con.createStatement();
			if(stmt != null)
				resultSet = stmt.executeQuery(sql);
			if(resultSet != null)
				resultSetMetaData = resultSet.getMetaData();
			
			if(resultSetMetaData != null) {
				numberOfColumns = resultSetMetaData.getColumnCount();
				while(resultSet.next()){
			    	for(int i = 1;i < numberOfColumns + 1; i++) {
			    		String field = resultSetMetaData.getColumnName(i);			    		
			    		if(field.equals("ID")) 
			    			ID = resultSet.getString(field);
			    		else if(field.equals("UserName"))
			    			userName = resultSet.getString(field);
			    		else if(field.equals("PickNumber"))
			    			pickNumber = resultSet.getString(field);
			    		
			    		//System.out.println(resultSet.getString(field));
			    	}
			    	bigLotteries.add(new BigLottery(ID , userName , pickNumber ));
			    }
			}
			else {
				System.out.println("select ���ѡA �y�{���~");
			}
			
		}
		catch (SQLException e) {
			System.out.println(e.toString());
			
		}
		
		return bigLotteries;
		
	}
	
	private String getUserNumber() {
		
		String query = "select * from [LotteryDB].[dbo].[BigLottery]";

		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);//Query���G�s�b�o��
			if(resultSet!= null) {
				resultSetMetaData = resultSet.getMetaData();
			    int numberOfColumns = resultSetMetaData.getColumnCount();
			    while(resultSet.next()){
			    	for(int i = 1;i < numberOfColumns+1;i++) {
			    		String field = resultSetMetaData.getColumnName(i);
			    		System.out.println(resultSet.getString(field));
			    	}
			    }
			}
		}
		catch (SQLException e) {
			System.out.println(e.toString());
			
		}
		return "";
		
	}
	
	
	
	
//	private String getUserNumber() {
//		
//		query = "select * from [LotteryDB].[dbo].[BigLottery]";
//
//		try {
//			resultSet = stmt.executeQuery(query);//Query���G�s�b�o��
//			if(resultSet!= null) {
//				resultSetMetaData = resultSet.getMetaData();
//			    int numberOfColumns = resultSetMetaData.getColumnCount();
//			    while(resultSet.next()){
//			    	for(int i = 1;i < numberOfColumns+1;i++) {
//			    		String cn = resultSetMetaData.getColumnName(i);
//			    		System.out.println(resultSet.getString(cn));
//			    	}
//			    }
//			}
//		}
//		catch (SQLException e) {
//			System.out.println(e.toString());
//			
//		}
//		return "";
//		
//	}
//	
//	private String getUserNumber(String colName) {
//		
//		query = "select " + colName + " from [LotteryDB].[dbo].[BigLottery]";
//		
//		try {
//			resultSet = stmt.executeQuery(query);//Query���G�s�b�o��
//			
//			if(resultSet != null) {
//				resultSetMetaData = resultSet.getMetaData();
//			    int numberOfColumns = resultSetMetaData.getColumnCount();
//			    while(resultSet.next()){
//			    	for(int i = 1;i < numberOfColumns+1;i++) {
//			    		String cn = resultSetMetaData.getColumnName(i);
//			    		System.out.println(resultSet.getString(cn));
//			    	}
//			    }
//			}
//			
//		}
//		catch (SQLException e) {
//			System.out.println(e.toString());
//			
//		}
//		return "";
//		
//	}
}
