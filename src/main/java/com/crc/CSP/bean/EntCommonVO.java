package com.crc.CSP.bean;

public class EntCommonVO {

	private String ID;
	private String UID;
	private String pid;
	private String name;
	private String classNo;
	private String date;
	private int ActionCount;
	private int totalScore;
	
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
	
	public String getPid()
	{
		return pid;
	}
	
	public void setPid(String pid)
	{
		this.pid = pid;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getClassNo()
	{
		return classNo;
	}
	
	public void setClassNo(String classNo)
	{
		this.classNo = classNo;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
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
}
