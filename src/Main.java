import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.GUI.WindowBigLottery;
import com.lottery.model.BigLottery;

import db.DBHelper;
import enums.GameMenu;

public class Main {
	
	
	
	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					//1600 x 1200 大小的視窗
					WindowBigLottery gameBigLottery = new WindowBigLottery(1600,1200);	
					DBHelper mDBHelper = new DBHelper();
					gameBigLottery.start();
					gameBigLottery.connectDB(mDBHelper);
					
					
					ArrayList<BigLottery> bigLotteries=  mDBHelper.selectAllFromBigLottery("BigLottery");
					gameBigLottery.setUserName(bigLotteries.get(1).getUserName());
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
//		Main main = new Main();
//		main.connetToSQL();
//		main.play(GameMenu.BIGLOTTERY);
//		
	}
	
	
	
}
