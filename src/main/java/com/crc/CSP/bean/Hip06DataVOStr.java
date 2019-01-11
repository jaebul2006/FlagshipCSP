package com.crc.CSP.bean;

public class Hip06DataVOStr {

	private String id;
	private String positionA;
	private String rotationA;
	private String scaleA;
	// poins 는 별도의 VO
	private double entryPointDiatance;
	private double degree15;
	private double pathWay;
	private String pathWayLinearX;
	private String pathWayLinearZ;
	private String Score;
	private double hip06Score;
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getPositionA()
	{
		return positionA;
	}
	
	public void setPositionA(String positionA)
	{
		this.positionA = positionA;
	}
	
	public String getRotationA()
	{
		return rotationA;
	}
	
	public void setRotationA(String rotationA)
	{
		this.rotationA = rotationA;
	}
	
	public String getScaleA()
	{
		return scaleA;
	}
	
	public void setScaleA(String scaleA)
	{
		this.scaleA = scaleA;
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
	
	public String getPathWayLinearX()
	{
		return pathWayLinearX;
	}
	
	public void setPathWayLinearX(String pathWayLinearX)
	{
		this.pathWayLinearX = pathWayLinearX;
	}
	
	public String getPathWayLinearZ()
	{
		return pathWayLinearZ;
	}
	
	public void setPathWayLinearZ(String pathWayLinearZ)
	{
		this.pathWayLinearZ = pathWayLinearZ;
	}
	
	public String getScore()
	{
		return Score;
	}
	
	public void setScore(String Score)
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
