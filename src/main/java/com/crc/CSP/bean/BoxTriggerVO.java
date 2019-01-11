package com.crc.CSP.bean;

public class BoxTriggerVO {

	private String ID;
	private String pid;
	private int stepScore;
	private int maxScore;
	private int score;
	private String note;
	private int innerTriggerCount;
	private int outerTriggerCount;
	private int innerTriggerTouchCount;
	private int outerTriggerTouchCount;
	
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
	
	public int getStepScore()
	{
		return stepScore;
	}
	
	public void setStepScore(int stepScore)
	{
		this.stepScore = stepScore;
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
	
	public int getInnerTriggerCount()
	{
		return innerTriggerCount;
	}
	
	public void setInnerTriggerCount(int innerTriggerCount)
	{
		this.innerTriggerCount = innerTriggerCount;
	}
	
	public int getOuterTriggerCount()
	{
		return outerTriggerCount;
	}
	
	public void setOuterTriggerCount(int outerTriggerCount)
	{
		this.outerTriggerCount = outerTriggerCount;
	}
	
	public int getInnerTriggerTouchCount()
	{
		return innerTriggerTouchCount;
	}
	
	public void setInnerTriggerTouchCount(int innerTriggerTouchCount)
	{
		this.innerTriggerTouchCount = innerTriggerTouchCount;
	}
	
	public int getOuterTriggerTouchCount()
	{
		return outerTriggerTouchCount;
	}
	
	public void setOuterTriggerTouchCount(int outerTriggerTouchCount)
	{
		this.outerTriggerTouchCount = outerTriggerTouchCount;
	}
	
}
