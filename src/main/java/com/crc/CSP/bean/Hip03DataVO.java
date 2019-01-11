package com.crc.CSP.bean;

public class Hip03DataVO {

	private String id;
	private double[] positionA;
	private double[] rotationA;
	private double[] scaleA;
	
	private double[] cupRotation;
	private double[] cupPosition;
	private double cupDiatance;
	private int[] Score;
	private double hip03Score;
	
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
	
}
