package model;

import java.sql.Date;

public class Bill {
	private int billID;
	private int userID;
	private String address;
	private Date date;
	private double total;
	private boolean paid;

	public Bill(int billID, int userID, double total, String address, Date date, boolean paid) {
		super();
		this.billID = billID;
		this.userID = userID;
		this.address = address;
		this.date = date;
		this.total = total;
		this.paid = paid;
	}

	public boolean getPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public Bill() {
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
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
