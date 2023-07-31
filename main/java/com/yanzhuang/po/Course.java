package com.yanzhuang.po;

public class Course 
{
	private String courseid;
	public Course()
	{
		
	}
	public Course(String courseid, String coursename, String professionid, double ratio, int credit) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.professionid = professionid;
		this.ratio = ratio;
		this.credit = credit;
	}
	private String coursename;
	private String professionid;
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", professionid=" + professionid
				+ ", ratio=" + ratio + ", credit=" + credit + "]";
	}
	private double ratio;
	private int credit;
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getProfessionid() {
		return professionid;
	}
	public void setProfessionid(String professionid) {
		this.professionid = professionid;
	}
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
