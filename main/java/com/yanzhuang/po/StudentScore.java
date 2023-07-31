package com.yanzhuang.po;

public class StudentScore {
	private String stuid;
	private double totalscore;
	public StudentScore()
	{
		
	}
	public StudentScore(String stuid, double totalscore) {
		super();
		this.stuid = stuid;
		this.totalscore = totalscore;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public double getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(double totalscore) {
		this.totalscore = totalscore;
	}
	@Override
	public String toString() {
		return "StudentScore [stuid=" + stuid + ", totalscore=" + totalscore + "]";
	}

}
