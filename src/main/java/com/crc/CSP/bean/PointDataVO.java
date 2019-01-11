package com.crc.CSP.bean;

public class PointDataVO {

	private String ID;
	private String pid;
	private double[] positionA;
	private double[] rotationA;
	
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
	
	public double[] getPositionA()
	{
		return positionA;
	}
	
	public void setPositionA(double[] positionA)
	{
		this.positionA = positionA;
	}
	
	public double[] getRotationA()
	{
		return rotationA;
	}
	
	public void setRotationA(double[] rotationA)
	{
		this.rotationA = rotationA;
	}
	
}
