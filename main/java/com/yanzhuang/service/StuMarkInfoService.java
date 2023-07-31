package com.yanzhuang.service;

import java.util.List;

import com.yanzhuang.po.StuMarkInfo;

public interface StuMarkInfoService 
{
	//public StudentVO login(String sno,String pwd);
	public List<Object> queryAll();
	//public boolean clearCount(String sno,String count,String logintime);
	List<Object> querySelectedStuMarkInfo(String markid);
	boolean getTotalScore();
	boolean deleteStuMarkInfo(String markid);
	boolean saveStuMarkInfo(StuMarkInfo stumarkinfo);
	boolean updateStuMarkInfo(StuMarkInfo stumarkinfo);
	public int getMaxMarkid();
	public int getCount();
	public boolean deleteMany(String[] tobedelete);
	public List<Object> getSelectedCourse(String stuid);
}
