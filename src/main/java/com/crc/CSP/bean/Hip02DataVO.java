package com.crc.CSP.bean;

public class Hip02DataVO {

	private String id;
	private double[] positionA;
	private double[] rotationA;
	private double[] scaleA;
	private double[] pointsX;
	private double[] pointsY;
	private double[] pointsZ;
	private double[] pointsGapX;
	private double[] pointsGapY;
	private double[] pointsGapZ;
	
	private double[] pointsgapAvg;
	private double[] pointsgapMax;
	
	private double cupDiatance;
	private double[] result;
	private int[] Score;
	private double hip02Score;
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
	
	public double[] getPointsX()
	{
		return pointsX;
	}
	
	public void setPointsX(double[] pointsX)
	{
		this.pointsX = pointsX;
	}
	
	public double[] getPointsY()
	{
		return pointsY;
	}
	
	public void setPointsY(double[] pointsY)
	{
		this.pointsY = pointsY;
	}
	
	public double[] getPointsZ()
	{
		return pointsZ;
	}
	
	public void setPointsZ(double[] pointsZ)
	{
		this.pointsZ = pointsZ;
	}
	
	public double[] getPointsGapX()
	{
		return pointsGapX;
	}
	
	public void setPointsGapX(double[] pointsGapX)
	{
		this.pointsGapX = pointsGapX;
	}
	
	public double[] getPointsGapY()
	{
		return pointsGapY;
	}
	
	public void setPointsGapY(double[] pointsGapY)
	{
		this.pointsGapY = pointsGapY;
	}
	
	public double[] getPointsGapZ()
	{
		return pointsGapZ;
	}
	
	public void setPointsGapZ(double[] pointsGapZ)
	{
		this.pointsGapZ = pointsGapZ;
	}
	
	public double[] getPointsgapAvg()
	{
		return pointsgapAvg;
	}
	
	public void setPointsgapAvg(double[] pointsgapAvg)
	{
		this.pointsgapAvg = pointsgapAvg;
	}
	
	public double[] getPointsgapMax()
	{
		return pointsgapMax;
	}
	
	public void setPointsgapMax(double[] pointsgapMax)
	{
		this.pointsgapMax = pointsgapMax;
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
	
	public double getHip02Score()
	{
		return hip02Score;
	}
	
	public void setHip02Score(double hip02Score)
	{
		this.hip02Score = hip02Score;
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
