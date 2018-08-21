import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.lottery.big.BigLottery;

import enums.GameMenu;

public class Main {
	BigLottery bigLottery = new BigLottery();
	
	public static void main(String[]args){
		Main main = new Main();
		main.connetToSQL();
		main.play(GameMenu.BIGLOTTERY);
		
	}
	
	/**get 指定欄位(colName)的所有資料*/
	private String getUserNumber(Connection con,String colName) {
		String query = "SELECT " + colName + " FROM [LotteryDB].[dbo].[BigLottery]";
		String result = "";
		ResultSet resultSet = null;
		ResultSetMetaData resultSetMetaData = null;
		try{
			Statement stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);
	
			//stmt.close();
			//con.close();
			
			if(resultSet != null) {
				resultSetMetaData = resultSet.getMetaData();
				int numColumns = resultSetMetaData.getColumnCount();
				while(resultSet.next()) {
					for(int i = 1; i < numColumns+1; i ++) {
						String cn = resultSetMetaData.getColumnName(i);
						System.out.println(resultSet.getString(cn));//印出資料
					}
				}
			}
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		
		return "";
	}
	
	private String getUserNumber(Connection con) {
		String query = "SELECT * FROM [LotteryDB].[dbo].[BigLottery]";
		String result = "";
		ResultSet resultSet = null;
		ResultSetMetaData resultSetMetaData = null;
		try{
			Statement stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);
			//stmt.close();
			//con.close();
			
			if(resultSet != null) {
				resultSetMetaData = resultSet.getMetaData();
				int numColumns = resultSetMetaData.getColumnCount();
				//System.out.println("numColumns : " + numColumns);
				while(resultSet.next()) {
					for(int i = 1; i < numColumns+1; i ++) {
						String colName = resultSetMetaData.getColumnName(i);
						System.out.println(resultSet.getString(colName));//印出資料
					}
				}
			}
			
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		
		return "";
	}
	
	
	private void connetToSQL() {
		String conUrl = "jdbc:sqlserver://localhost;\"\r\n"
						+"\"databaseName=LotteryDB;"
						+ "user=JJ;"
						+ "password=12345;";

		try { 
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			Connection con = DriverManager.getConnection(conUrl);
			DatabaseMetaData metadata = con.getMetaData(); 
			String reuslt = getUserNumber(con,"UserName");
			getUserNumber(con);
		    System.out.println("Database Name: "+ metadata.getDatabaseProductName());
		
		}
		catch (SQLException e) {
				System.out.println("Exception :"+e.toString());
	    } 
			
		
	}
	
	public  void play(GameMenu game){
		switch (game) {
			case BIGLOTTERY:
				 bigLottery.play();
				break;
			
			case SMALLLOTTERY:
				 //bigLottery.play();
				break;
			}
		
	}
	
}
