package model;

import java.sql.Date;

public class Bill {
	private String billID;
	private String userID;
	private String address;
	private Date date;
	
	public Bill(String billID, String userID, String address, Date date) {
		super();
		this.billID = billID;
		this.userID = userID;
		this.address = address;
		this.date = date;
	}

	public String getBillID() {
		return billID;
	}

	public void setBillID(String billID) {
		this.billID = billID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
