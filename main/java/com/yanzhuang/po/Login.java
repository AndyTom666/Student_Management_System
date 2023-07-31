package com.yanzhuang.po;

import java.sql.ResultSet;

import com.yanzhuang.database.DBIO;

public class Login implements DBIO
{
	public Login(String stuid, String pwd, int role, int stustate) {
		super();
		this.stuid = stuid;
		this.pwd = pwd;
		this.role = role;
		this.stustate = stustate;
	}
	public Login() {
		// TODO Auto-generated constructor stub
	}
	private String stuid;
	private String pwd;
	private int role;
	private int stustate;
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
		//System.out.println(stuid+"527");
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getStustate() {
		return stustate;
	}
	public void setStustate(int stustate) {
		this.stustate = stustate;
	}
	@Override
	public String toString() {
		return "Login [stuid=" + stuid + ", pwd=" + pwd + ", role=" + role + ", stustate=" + stustate + "]";
	}
	@Override
	public Object toObject(ResultSet rs) {
		// TODO Auto-generated method stub
		if(rs==null) return null;
		Login log=new Login();
		try
		{
			log.setStuid(rs.getString("stuid"));
			log.setPwd(rs.getString("pwd"));
			log.setRole(rs.getInt("role"));
			log.setStustate(rs.getInt("stustate"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return log;
	}
	
}
