package model;

import java.sql.Date;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class Bill {
	private int billID;
	private String userID;
	private String address;
	private Date date;
	private double total;
	private int paid; //values 0 or 1
	
	public Bill(int billID, String userID, String address, Date date, double total, int paid) {
		super();
		this.billID = billID;
		this.userID = userID;
		this.address = address;
		this.date = date;
		this.total = total;
		this.paid = paid;
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
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

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}
}
