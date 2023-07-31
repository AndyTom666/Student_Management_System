package com.yanzhuang.po;

public class Profession {
	private String professionid;
	private String professionname;
	public String getProfessionid() {
		return professionid;
	}
	public void setProfessionid(String professionid) {
		this.professionid = professionid;
	}
	public String getProfessionname() {
		return professionname;
	}
	public void setProfessionname(String professionname) {
		this.professionname = professionname;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "profession [professionid=" + professionid + ",professionname="+professionname+"]";
	}

}
