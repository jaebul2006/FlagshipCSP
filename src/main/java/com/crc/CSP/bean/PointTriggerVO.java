package com.crc.CSP.bean;

public class PointTriggerVO {

	private String ID;
	private String pid;
	private int deduction;
	private int failure;
	private String name;
	
	public String getID()
	{
		return ID;
	}
	
	public void setID(String ID)
	{
		this.ID = ID;
	}
	
	public String getPid()
	{
		return pid;
	}
	
	public void setPid(String pid)
	{
		this.pid = pid;
	}
	
	public int getDeduction()
	{
		return deduction;
	}
	
	public void setDeduction(int deduction)
	{
		this.deduction = deduction;
	}
	
	public int getFailure()
	{
		return failure;
	}
	
	public void setFailure(int failure)
	{
		this.failure = failure;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
}
