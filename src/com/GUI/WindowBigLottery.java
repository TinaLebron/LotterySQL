package com.GUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

import com.lottery.big.BigLottery2;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.ComponentOrientation;
import java.awt.Insets;

public class WindowBigLottery {
private JFrame frame;
	
	private JLabel label_2;
	private JLabel lblNewLabel;
	private JLabel lblUserName;
	private JLabel lblPickNumber;
	
	private JButton btnPreviousNumber;
	private JLabel lblBigLottery;
	private JLabel lblDate;


	/**
	 * Launch the  application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBigLottery window = new WindowBigLottery();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBigLottery() {
		initialize();
	}
	
	/**
	 * �n��ܦb�e���W���ֳz���X(��list �榡�Ƶ��ϥΪ̬�)
	 */
	public String numbersToString(ArrayList<String> list) {
		String result = "";
		for(int i = 0; i < list.size(); i++) {
			if(i == 0) {
				result = "�S: " + list.get(i) + " ";
			}
			else if( i < 6) {
				result += list.get(i) + ",";
			}
			else {
				result += list.get(i);
			}
		}
		return result;
	}
	
	/**
	 * get user picked number which is sorted.
	 * ���ϥΪ̤W�@���ҿ諸���X�A�ñƧǡC
	 */
	public ArrayList<String> getPickedNumberByDate() {
		String pickNumber = "";
		String specialNumber = "";
		ArrayList<String> myNumbers = new ArrayList<String>();
		String unSubStringNumber = getUserNumber("PickNumber");
		
		for(int i = 0;i < getUserNumber("PickNumber").length(); i+=2) {
		    //pickNumber = lblPickNumber.getText().substring(i,i+2);
		    pickNumber = unSubStringNumber.substring(i,i+2);
		    
			if(i == 0) {
				specialNumber = pickNumber;
				//result = "�S:" + specialNumber + " ";
			}
			else if(i < (pickNumber.length()-1)){
			    myNumbers.add(pickNumber);
			   // result +=  myNumbers.get(i) + ",";
			}
			else {
				myNumbers.add(pickNumber);
			    //result +=  pickNumber;
			}
		}
		
		//System.out.println("\n�Ƨǫe");
	//	System.out.print(result);
		String[] myNumberstoArray = myNumbers.toArray(new String[myNumbers.size()]);
		int[] myNumberstoIntArray = sortByBubble(convertStringArraytoIntArray(myNumberstoArray));
		myNumbers = convertIntArraytoArrayList(myNumberstoIntArray);
		//Collections.sort(myNumbers);
		//System.out.println("\n�Ƨǫ�");
		//System.out.print(result);
		
	    /*�Ƨǫ�[�W�S�O��**/
		myNumbers.add(0, specialNumber);
		//System.out.println("\n�Ƨǫ�[�W�S�O��");
		//System.out.print(result);
		
		return myNumbers;
	}
	
	/**
	 * StringArray�ഫ��IntArray
	 */
	public int[] convertStringArraytoIntArray(String[] ary) {
		int[] integers = new int[ary.length];
		for(int i = 0;i < ary.length;i++) {
			integers[i] = Integer.parseInt(ary[i]);
		}
		return integers;
		
	}
	
	/**
	 * ��w�ƧǪk
	 */
	public int[] sortByBubble(int[] array) {
		int swap = 0;
		for(int i = 0;i < array.length-1;i++) {
			for(int j = 0;j < array.length-1;j++) {
				if(array[j] > array[j+1]) {
					swap = array[j];
					array[j] = array[j+1];
					array[j+1] = swap;
				}
			}
		}
		return array;
	}
	
	/**
	 * ��w�ƧǪk
	 */
	public ArrayList<String> convertIntArraytoArrayList(int[] array) {
		ArrayList<String> result = new ArrayList<>();
		for(int i : array) {
			result.add("" + i);
		}
		
		return result;
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		connectToSQL();
		
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(800, 400));
		frame.setMaximumSize(new Dimension(800, 400));
		frame.setBounds(300, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		label_2 = new JLabel("\u5927\u6A02\u900F");
		label_2.setSize(new Dimension(24, 24));
		lblNewLabel = new JLabel("New label");
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		JLabel lblWelcome = new JLabel("\u6B61\u8FCE\u5149\u81E8");
		lblWelcome.setFont(new Font("�s�ө���", Font.PLAIN, 38));
		lblUserName = new JLabel("New label");
		lblUserName.setFont(new Font("�s�ө���", Font.PLAIN, 42));
		
		JLabel lblPreviousNumber = new JLabel("\u60A8\u4E0A\u671F\u6240\u9078\u7684\u865F\u78BC\u70BA:");
		lblPreviousNumber.setFont(new Font("�s�ө���", Font.PLAIN, 38));
		lblPreviousNumber.setPreferredSize(new Dimension(108, 34));
		lblPreviousNumber.setMinimumSize(new Dimension(108, 34));
		lblPickNumber = new JLabel("New label"); 
		lblPickNumber.setFont(new Font("�s�ө���", Font.PLAIN, 42));
		
		btnPreviousNumber = new JButton("\u4E0A\u671F\u865F\u78BC");
		btnPreviousNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblUserName.setText(getUserNumber("UserName"));
				
				/*�ϥΪ̿諸���X(�ھڤ�����\��|������)**/
				//String number = numbersToString(getPickedNumberByDate());
				ArrayList<String> list = getPickedNumberByDate();
				String str = numbersToString(list);
				lblPickNumber.setText(str);
				//lblPickNumber.setText(getUserNumber("PickNumber"));
				
				
		}});
		
		
		panel.add(label_2);
		panel.add(lblNewLabel);
		
		lblBigLottery = new JLabel("\u5927\u6A02\u900F");
		lblBigLottery.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblBigLottery.setFont(new Font("�s�ө���", Font.PLAIN, 45));
		panel_1.add(lblBigLottery);
		
		lblDate = new JLabel(getdate());
		lblDate.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblDate.setFont(new Font("�s�ө���", Font.PLAIN, 38));
		panel_1.add(lblDate);
		panel_1.add(lblWelcome);
		panel_1.add(lblUserName);
		panel_1.add(lblPreviousNumber);
		panel_1.add(lblPickNumber);
		frame.getContentPane().add(btnPreviousNumber, BorderLayout.WEST);
		
		
		
	}
	
	//BigLottery 
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
			//System.out.println(metadata.getDatabaseProductName());//����ƾڮw
		}
		catch(SQLException e) {
			System.out.println("Exception: " + e.toString());
		}
	}
	
	private String getUserNumber() {
		
		query = "select * from [LotteryDB].[dbo].[BigLottery]";

		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);//Query���G�s�b�o��
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
		
		//query = "select " + colName + " from [LotteryDB].[dbo].[BigLottery]";
		query = "select " + colName + " from [LotteryDB].[dbo].[BigLottery] where UserName = 'Bob'";
		String result = "";
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);//Query���G�s�b�o��
			
			if(resultSet != null) {
				resultSetMetaData = resultSet.getMetaData();
			    int numberOfColumns = resultSetMetaData.getColumnCount();
			    while(resultSet.next()){
			    	for(int i = 1;i < numberOfColumns+1;i++) {
			    		String cn = resultSetMetaData.getColumnName(i);
			    		 result = resultSet.getString(cn);
			    		
			    		
			    		
//			    		System.out.println(resultSet.getString(cn));
			    	}
			    }
			}
			
		}
		catch (SQLException e) {
			System.out.println(e.toString());
			
		}
		return result;
		
	}
	
	public String getdate() {
//		//�����ϥ�LocalDateTime���O�Ө��o����P�ɶ�
//		LocalDateTime currenPoint = LocalDateTime.now();
////		System.out.println(currenPoint);
//		return currenPoint.toString();
		
		Date dNow = new Date();
		//SimpleDateFormat formatter = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		System.out.println(formatter.format(dNow));
		return formatter.format(dNow).toString();
	}

}
