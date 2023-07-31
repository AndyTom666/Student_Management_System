package com.yanzhuang.po;

public class Teacher 
{
	private String teacherid;
	public Teacher()
	{
		
	}
	public Teacher(String teacherid, String teachername, String pwd, String professionid,int role) {
		super();
		this.teacherid = teacherid;
		this.teachername = teachername;
		this.pwd = pwd;
		this.professionid = professionid;
		this.role = role;
	}
	private String teachername;
	private String pwd;
	private String professionid;
	private int role;
	@Override
	public String toString() {
		return "Teacher [teacherid=" + teacherid + ", teachername=" + teachername + ", pwd=" + pwd + ", professionid="
				+ professionid + ", role=" + role + "]";
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getProfessionid() {
		return professionid;
	}
	public void setProfessionid(String professionid) {
		this.professionid = professionid;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
