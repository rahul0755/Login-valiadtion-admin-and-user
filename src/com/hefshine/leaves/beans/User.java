package com.hefshine.leaves.beans;

public class User {
	
	private int id;
	private String uname;
	 private String password;
	private String  role;
	private String status;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String uname, String password, String role, String status) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", password=" + password + ", role=" + role + ", status="
				+ status + "]";
	}
	
}
