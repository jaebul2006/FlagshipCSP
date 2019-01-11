package com.crc.CSP.bean;

public class ToolsVO {

	private String ID;
	private String pid;
	private int touchCount;
	private int toolUseCount;
	private int toolInnerCount;
	private int toolTouchScore;
	private int toolViewScore;
	private int maxScore;
	
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
	
	public int getTouchCount()
	{
		return touchCount;
	}
	
	public void setTouchCount(int touchCount)
	{
		this.touchCount = touchCount;
	}
	
	public int getToolUseCount()
	{
		return toolUseCount;
	}
	
	public void setToolUseCount(int toolUseCount)
	{
		this.toolUseCount = toolUseCount;
	}
	
	public int getToolInnerCount()
	{
		return toolInnerCount;
	}
	
	public void setToolInnerCount(int toolInnerCount)
	{
		this.toolInnerCount = toolInnerCount;
	}
	
	public int getToolTouchScore()
	{
		return toolTouchScore;
	}
	
	public void setToolTouchScore(int toolTouchScore)
	{
		this.toolTouchScore = toolTouchScore;
	}
	
	public int getToolViewScore()
	{
		return toolViewScore;
	}
	
	public void setToolViewScore(int toolViewScore)
	{
		this.toolViewScore = toolViewScore;
	}
	
	public int getMaxScore()
	{
		return maxScore;
	}
	
	public void setMaxScore(int maxScore)
	{
		this.maxScore = maxScore;
	}
	
}
