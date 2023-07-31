package com.yanzhuang.util;

public class Point 
{	
	 private String x;
	 private double y;
	 public Point()
	 {
		 
	 }
	public Point(String x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

}
