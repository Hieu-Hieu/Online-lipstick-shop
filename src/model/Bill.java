package model;

import java.sql.Date;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class Bill {
	private String billID;
	private String userID;
	private String address;
	private Date date;
	private double total;
	

	public Bill(String billID, String userID, double total ,String address, Date date) {
		super();
		this.billID = billID;
		this.userID = userID;
		this.address = address;
		this.date = date;
		this.total = total;
	}
	public Bill() {}
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}	
}
