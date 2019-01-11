package com.crc.CSP.bean;

public class ExpertToolsVO {

	private String oper_name;
	private int touchCount;
	private int toolUseCount;
	private int toolInnerCount;
	private int toolTouchScore;
	private int toolViewScore;
	private int maxScore;
	
	
	public String getOper_name()
	{
		return oper_name;
	}
	
	public void setOper_name(String oper_name)
	{
		this.oper_name = oper_name;
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
