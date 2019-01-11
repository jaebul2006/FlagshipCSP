package com.crc.CSP.bean;

public class HipCommonVO {

	private String date;
	private String ID;
	private String UID;
	private int ActionCount;
	private int totalScore;
	private String file_name;
	
	public String getDate()
	{
		return date;
	}
	
	public void setData(String date)
	{
		this.date = date;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public void setID(String ID)
	{
		this.ID = ID;
	}
	
	public String getUID()
	{
		return UID;
	}
	
	public void setUID(String UID)
	{
		this.UID = UID;
	}
	
	public int getActionCount()
	{
		return ActionCount;
	}
	
	public void setActionCount(int ActionCount)
	{
		this.ActionCount = ActionCount;
	}
	
	public int getTotalScore()
	{
		return totalScore;
	}
	
	public void setTotalScore(int totalScore)
	{
		this.totalScore = totalScore;
	}
	
	public String getFile_name()
	{
		return file_name;
	}
	
	public void setFile_name(String file_name)
	{
		this.file_name = file_name;
	}
}
