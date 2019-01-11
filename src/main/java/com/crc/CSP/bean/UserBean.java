package com.crc.CSP.bean;

public class UserBean {

	private String ID;
	private String PASSWORD;
	private int ENABLED;
	private String AUTHORITY;
	private String USERNAME;
	private String USERTYPE;
	private String ACCOUNT_ID;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	
	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}
	
	public int getENABLED() {
		return ENABLED;
	}
	
	public void setENABLED(int ENABLED) {
		this.ENABLED = ENABLED;
	}
	
	public String getAUTHORITY()
	{
		return AUTHORITY;
	}
	
	public void setAUTHORITY(String AUTHORITY)
	{
		this.AUTHORITY = AUTHORITY;
	}
	
	public String getUSERNAME() {
		return USERNAME;
	}
	
	public void setUSERNAME(String USERNAME) {
		this.USERNAME = USERNAME;
	}
	
	public String getUSERTYPE()
	{
		return USERTYPE;
	}
	
	public void setUSERTYPE(String USERTYPE)
	{
		this.USERTYPE = USERTYPE;
	}
	
	public String getACCOUNT_ID()
	{
		return ACCOUNT_ID;
	}
	
	public void setACCOUNT_ID(String ACCOUNT_ID)
	{
		this.ACCOUNT_ID = ACCOUNT_ID;
	}
	
	
	
}
