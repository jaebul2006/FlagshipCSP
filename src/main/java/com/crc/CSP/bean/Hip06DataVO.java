package com.crc.CSP.bean;

public class Hip06DataVO {

	private String id;
	private double[] positionA;
	private double[] rotationA;
	private double[] scaleA;
	private Hip06PointsVO[] points;
	private double entryPointDiatance;
	private double degree15;
	private double pathWay;
	private double[] pathWayLinearX;
	private double[] pathWayLinearZ;
	private int[] Score;
	private double hip06Score;
	
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
	public Hip06PointsVO[] getPoints()
	{
		return points;
	}
	
	public void setPoints(Hip06PointsVO[] points)
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
	
	public int[] getScore()
	{
		return Score;
	}
	
	public void setScore(int[] Score)
	{
		this.Score = Score;
	}
	
	public double getHip06Score()
	{
		return hip06Score;
	}
	
	public void setHip06Score(double hip06Score)
	{
		this.hip06Score = hip06Score;
	}
	
}
