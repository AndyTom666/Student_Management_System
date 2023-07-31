package com.yanzhuang.po;

import java.sql.ResultSet;
import com.yanzhuang.database.DBIO;

public class Student implements DBIO
{
	private String stuid;
	private String stuname;
	private String pwd;
	private int age;
	private String professionid;
	private int role;
	private String date;
	private int sex;
	private String idnum;
	private int totalscore;
	private String photo;
	private String note;
	private String professionname;
	public String getProfessionname() {
		return professionname;
	}
	public void setProfessionname(String professionname) {
		this.professionname = professionname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public int getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Student()
	{
		
	}
	public Student(String stuid, String stuname, String pwd, int age, String professionid, int role, String date,
			int sex, String idnum, int totalscore, String photo, String note) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.pwd = pwd;
		this.age = age;
		this.professionid = professionid;
		this.role = role;
		this.date = date;
		this.sex = sex;
		this.idnum = idnum;
		this.totalscore = totalscore;
		this.photo = photo;
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", stuname=" + stuname + ", pwd=" + pwd + ", professionid=" + professionid
				+ ", role=" + role + ", date=" + date + ", sex=" + sex + ", idnum=" + idnum + ", age=" + age + ", totalscore="
				+ totalscore + ", photo=" + photo + ", note=" + note + "]";
	}
	@Override
	public Object toObject(ResultSet rs) {
		// TODO Auto-generated method stub
		if(rs==null) return null;
		Student stu=new Student();
		try
		{
			stu.setStuid(rs.getString("stuid"));
			stu.setStuname(rs.getString("stuname"));
			stu.setPwd(rs.getString("pwd"));
			//stu.set(rs.getInt("count"));
			stu.setProfessionid(rs.getString("professionid"));
			stu.setRole(rs.getInt("role"));
			stu.setDate(rs.getString("date"));
			stu.setIdnum(rs.getString("idnum"));
			stu.setSex(rs.getInt("sex"));
			stu.setNote(rs.getString("note"));
			stu.setPhoto(rs.getString("photo"));
			stu.setTotalscore(rs.getInt("totalscore"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return stu;
	}

}
