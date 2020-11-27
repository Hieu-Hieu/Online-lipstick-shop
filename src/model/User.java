package model;

public class User {
	private String userID;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String address;
	private boolean role;
	
    public User() {
    }

    public User(String id, String username, String password, String email, String phone, String address, boolean role) {
        this.userID = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public String getid() {
        return userID;
    }

    public void setid(String id) {
        this.userID = id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }


    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }
    
    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }


    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }
    
    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public boolean isrole() {
        return role;
    }

    public void setrole(boolean role) {
        this.role = role;
    }   
}
