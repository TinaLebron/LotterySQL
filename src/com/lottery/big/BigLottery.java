package com.lottery.big;
import java.sql.*;

public class BigLottery {
	private Connection con = null; //Database objects 
	  //連接object 
	  private Statement stat = null; 
	  //執行,傳入之sql為完整字串 
	  private ResultSet rs = null; 
	  //結果集 
	  private PreparedStatement pst = null; 
	  //執行,傳入之sql為預儲之字申,需要傳入變數之位置 
	  //先利用?來做標示
	  private String selectSQL = "select * from LotteryDB";
	
	public BigLottery() {
		
	}
	
	
	
	
	public void SelectTable() 
	  { 
	    try 
	    { 
	      stat = con.createStatement(); 
	      rs = stat.executeQuery(selectSQL); 
	      System.out.println("ID\t\tUserName\t\tPickNumber"); 
	      while(rs.next()) 
	      { 
	        System.out.println(rs.getInt("ID")+"\t\t"+ 
	            rs.getString("UserName")+"\t\t"+rs.getString("PickNumber")); 
	      } 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println(e.toString()); 
	    } 
	    finally 
	    { 
	      Close(); 
	    } 
	  } 
	
	 private void Close() 
	  { 
	    try 
	    { 
	      if(rs!=null) 
	      { 
	        rs.close(); 
	        rs = null; 
	      } 
	      if(stat!=null) 
	      { 
	        stat.close(); 
	        stat = null; 
	      } 
	      if(pst!=null) 
	      { 
	        pst.close(); 
	        pst = null; 
	      } 
	    } 
	    catch(SQLException e) 
	    { 
	      System.out.println("Close Exception :" + e.toString()); 
	    } 
	  } 

	
	public void play() {
		
		
	}
}
