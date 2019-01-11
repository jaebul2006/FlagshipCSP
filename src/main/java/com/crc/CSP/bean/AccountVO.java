package com.crc.CSP.bean;

public class AccountVO 
{
	private String ID;
	private String AdminID;
	private String MacAddress;
	private String user_type;
	private String LastLogin;
	private String AuthToken;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getAdminID() {
		return AdminID;
	}
	
	public void setAdminID(String AdminID) {
		this.AdminID = AdminID;
	}
	
	public String getMacAddress() {
		return MacAddress;
	}
	
	public void setMacAddress(String MacAddress) {
		this.MacAddress = MacAddress;
	}
	
	public String getUser_type() {
		return user_type;
	}
	
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	public String getLastLogin() {
		return LastLogin;
	}
	
	public void setLastLogin(String LastLogin) {
		this.LastLogin = LastLogin;
	}
	
	public String getAuthToken() {
		return AuthToken;
	}
	
	public void setAuthToken(String AuthToken) {
		this.AuthToken = AuthToken;
	}
	
}
