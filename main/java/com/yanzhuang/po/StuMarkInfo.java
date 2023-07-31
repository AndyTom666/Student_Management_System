package com.yanzhuang.po;

public class StuMarkInfo {
	private String markid;
	private String stuid;
	private String courseid;
 	private String coursename;

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	private double basescore;
	private double testscore;
	private double finalscore;
	private String adddate;
	private String note;

	public String getMarkid() {
		return markid;
	}

	public void setMarkid(String markid) {
		this.markid = markid;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public double getBasescore() {
		return basescore;
	}

	public void setBasescore(double basescore) {
		this.basescore = basescore;
	}

	public double getTestscore() {
		return testscore;
	}

	public void setTestscore(double testscore) {
		this.testscore = testscore;
	}

	public double getFinalscore() {
		return finalscore;
	}

	public void setFinalscore(double finalscore) {
		this.finalscore = finalscore;
	}

	public String getAdddate() {
		return adddate;
	}

	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "stumarkinfo [markid=" + markid + ",stuid=" + stuid + ",courseid=" + courseid + ",basescore=" + basescore
				+ ",testscore=" + testscore + ",fianlscore=" + finalscore + ",adddate=" + adddate + ",note=" + note
				+ "]";

	}

}
