package com.crc.CSP.bean;

public class UncinectomyVO {

	private String ID;
	private String pid;
	private int maxScore;
	private int score;
	private String note;
	private PointTriggerVO[] points;
	private double[] position;
	private double[] rotation;
	private double[] localcale;
	private int[] pinCount;
	private double[] pins;
	private double[] targetPins;
	
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
	
	public int getMaxScore()
	{
		return maxScore;
	}
	
	public void setMaxScore(int maxScore)
	{
		this.maxScore = maxScore;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public String getNote()
	{
		return note;
	}
	
	public void setNote(String note)
	{
		this.note = note;
	}
	
	public PointTriggerVO[] getPoints()
	{
		return points;
	}
	
	public void setPoints(PointTriggerVO[] points)
	{
		this.points = points;
	}
	
	public double[] getPosition()
	{
		return position;
	}
	
	public void setPosition(double[] position)
	{
		this.position = position;
	}
	
	public double[] getRotation()
	{
		return rotation;
	}
	
	public void setRotation(double[] rotation)
	{
		this.rotation = rotation;
	}
	
	public double[] getLocalcale()
	{
		return localcale;
	}
	
	public void setLocalcale(double[] localcale)
	{
		this.localcale = localcale;
	}
	
	public int[] getPinCount()
	{
		return pinCount;
	}
	
	public void setPinCount(int[] pinCount)
	{
		this.pinCount = pinCount;
	}
	
	public double[] getPins()
	{
		return pins;
	}
	
	public void setPins(double[] pins)
	{
		this.pins = pins;
	}
	
	public double[] getTargetPins()
	{
		return targetPins;
	}
	
	public void setTargetPins(double[] targetPins)
	{
		this.targetPins = targetPins;
	}
	
}
