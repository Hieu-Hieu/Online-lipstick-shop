package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "billID")
	private int billID;
	@ManyToOne(optional = false)
	@JoinColumn(name = "userID", referencedColumnName = "userID")
	private User user;
	@Column(name = "address", length = 255)
	private String address;
	@Column(name = "phone", length = 11)
	private String phone;
	@Column(name = "date")
	// @Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "total")
	private double total;

	@Column(name = "paid")
	private boolean paid;

	@Column(name = "state")
	private boolean state;

//	@OneToMany(mappedBy="bill",cascade=CascadeType.ALL)
//	private Set<BillDetail> billDetail;

	public Bill() {
	}

	public Bill(User user, String address, String phone, Date date, double total, boolean paid, boolean state) {
		super();
		this.user = user;
		this.address = address;
		this.phone = phone;
		this.date = date;
		this.total = total;
		this.paid = paid;
		this.state = state;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public boolean getPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}