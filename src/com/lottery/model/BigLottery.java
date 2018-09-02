package com.lottery.model;

public class BigLottery {
	//ÄÝ©Ê
	private String _id;
	private String userName;
	private String pickNumber;
	
	public BigLottery(String _id , String userName, String pickNumber) {
		this._id = _id;
		this.userName = userName;
		this.pickNumber = pickNumber;
	}
	
	
	public void setID(String id) {
		this._id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPickNumber(String pickNumber) {
		this.pickNumber = pickNumber;
	}
	public String getID() {
		return _id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPickNumber() {
		return pickNumber;
	}
}
