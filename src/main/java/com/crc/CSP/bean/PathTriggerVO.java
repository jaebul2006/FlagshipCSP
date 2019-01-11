package com.crc.CSP.bean;

public class PathTriggerVO {

	private String ID;
	private String pid;
	private int stepScore;
	private int maxScore;
	private int score;
	private String note;
	private double[] position;
	private double[] rotation;
	private double[] scale;
	private PointDataVO[] points;
	private PointDataVO[] pathPoints;
	private PointDataVO[] targetPoints;
	
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
	
	public double[] getScale()
	{
		return scale;
	}
	
	public void setScale(double[] scale)
	{
		this.scale = scale;
	}
	
	public PointDataVO[] getPoints()
	{
		return points;
	}
	
	public void setPoints(PointDataVO[] points)
	{
		this.points = points;
	}
	
	public PointDataVO[] getPathPoints()
	{
		return pathPoints;
	}
	
	public void setPathPoints(PointDataVO[] pathPoints)
	{
		this.pathPoints = pathPoints;
	}
	
	public PointDataVO[] getTargetPoints()
	{
		return targetPoints;
	}
	
	public void setTargetPoints(PointDataVO[] targetPoints)
	{
		this.targetPoints = targetPoints;
	}
	
}
