package com.crc.CSP.bean;

public class Hip03DataVO {

	private String id;
	private double[] positionA;
	private double[] rotationA;
	private double[] scaleA;
	
	private double[] cupRotation;
	private double[] cupPosition;
	private double cupDiatance;
	
	private double[] result;
	
	private int[] Score;
	private double hip03Score;
	
	private int dropPoint;
	private int maxPoint;
	private String isDroped;
	
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
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
	
	public double[] getScaleA()
	{
		return scaleA;
	}
	
	public void setScaleA(double[] scaleA)
	{
		this.scaleA = scaleA;
	}
	
	public double[] getCupRotation()
	{
		return cupRotation;
	}
	
	public void setCupRotation(double[] cupRotation)
	{
		this.cupRotation = cupRotation;
	}
	
	public double[] getCupPosition()
	{
		return cupPosition;
	}
	
	public void setCupPosition(double[] cupPosition)
	{
		this.cupPosition = cupPosition;
	}
	
	public double getCupDiatance()
	{
		return cupDiatance;
	}
	
	public void setCupDiatance(double cupDiatance)
	{
		this.cupDiatance = cupDiatance;
	}
	
	public double[] getResult()
	{
		return result;
	}
	
	public void setResult(double[] result)
	{
		this.result = result;
	}
	
	public int[] getScore()
	{
		return Score;
	}
	
	public void setScore(int[] Score)
	{
		this.Score = Score;
	}
	
	public double getHip03Score()
	{
		return hip03Score;
	}
	
	public void setHip03Score(double hip03Score)
	{
		this.hip03Score = hip03Score;
	}
	
	public int getDropPoint()
	{
		return dropPoint;
	}
	
	public void setDropPoint(int dropPoint)
	{
		this.dropPoint = dropPoint;
	}
	
	public int getMaxPoint()
	{
		return maxPoint;
	}
	
	public void setMaxPoint(int maxPoint)
	{
		this.maxPoint = maxPoint;
	}
	
	public String getIsDroped()
	{
		return isDroped;
	}
	
	public void setIsDroped(String isDroped)
	{
		this.isDroped = isDroped;
	}
	
}
