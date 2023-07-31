package com.yanzhuang.http;

public class Studentwai {
	private int count;
	private String entertime;
	private String idnum;
	private String note;
	private String profession;
	private String pwd;
	private int sage;
	private String sex;
	private String sname;
	private String sno;
	public int getCount() {
		return count;
	}
	public Studentwai()
	{
		
	}
	
	@Override
	public String toString() {
		return "Studentwai [count=" + count + ", entertime=" + entertime + ", idnum=" + idnum + ", note=" + note
				+ ", profession=" + profession + ", pwd=" + pwd + ", sage=" + sage + ", sex=" + sex + ", sname=" + sname
				+ ", sno=" + sno + "]";
	}
	public Studentwai(int count, String entertime, String idnum, String note, String profession, String pwd, int sage,
			String sex, String sname, String sno) {
		super();
		this.count = count;
		this.entertime = entertime;
		this.idnum = idnum;
		this.note = note;
		this.profession = profession;
		this.pwd = pwd;
		this.sage = sage;
		this.sex = sex;
		this.sname = sname;
		this.sno = sno;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getEntertime() {
		return entertime;
	}
	public void setEntertime(String entertime) {
		this.entertime = entertime;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}

}
