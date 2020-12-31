package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "billID")
	private int billID;

	@ManyToOne
	@Column(name = "userID")
	private User userID;

	@Column(name = "address")
	private String address;

//	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Column(name = "total")
	private double total;

	@Column(name = "paid")
	private boolean paid;

	@Column(name = "state")
	private boolean state;

	public Bill(int billID, User userID, String address, Date date, double total, boolean paid, boolean state) {
		super();
		this.billID = billID;
		this.userID = userID;
		this.address = address;
		this.date = date;
		this.total = total;
		this.paid = paid;
		this.state = state;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public Bill() {
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
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

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
