package com.lottery.big;
import java.sql.*;

public class BigLottery {
	private Connection con = null; //Database objects 
	  //�s��object 
	  private Statement stat = null; 
	  //����,�ǤJ��sql������r�� 
	  private ResultSet rs = null; 
	  //���G�� 
	  private PreparedStatement pst = null; 
	  //����,�ǤJ��sql���w�x���r��,�ݭn�ǤJ�ܼƤ���m 
	  //���Q��?�Ӱ��Х�
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
