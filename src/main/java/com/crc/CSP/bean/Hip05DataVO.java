package com.crc.CSP.bean;

public class Hip05DataVO {

	private String id;
	private double[] positionA;
	private double[] rotationA;
	private double[] scaleA;
	private Hip05PointsVO[] points;
	private double entryPointDiatance;
	private double degree15;
	private double pathWay;
	private double[] pathWayLinearX;
	private double[] pathWayLinearZ;
	private double[] result;
	private int[] Score;
	private double hip05Score;
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
	
	// ��������
	public Hip05PointsVO[] getPoints()
	{
		return points;
	}
	
	public void setPoints(Hip05PointsVO[] points)
	{
		this.points = points;
	}
	
	public double getEntryPointDiatance()
	{
		return entryPointDiatance;
	}
	
	public void setEntryPointDiatance(double entryPointDiatance)
	{
		this.entryPointDiatance = entryPointDiatance;
	}
	
	public double getDegree15()
	{
		return degree15;
	}
	
	public void setDegree15(double degree15)
	{
		this.degree15 = degree15;
	}
	
	public double getPathWay()
	{
		return pathWay;
	}
	
	public void setPathWay(double pathWay)
	{
		this.pathWay = pathWay;
	}
	
	public double[] getPathWayLinearX()
	{
		return pathWayLinearX;
	}
	
	public void setPathWayLinearX(double[] pathWayLinearX)
	{
		this.pathWayLinearX = pathWayLinearX;
	}
	
	public double[] getPathWayLinearZ()
	{
		return pathWayLinearZ;
	}
	
	public void setPathWayLinearZ(double[] pathWayLinearZ)
	{
		this.pathWayLinearZ = pathWayLinearZ;
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
	
	public double getHip05Score()
	{
		return hip05Score;
	}
	
	public void setHip05Score(double hip05Score)
	{
		this.hip05Score = hip05Score;
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
