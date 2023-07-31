package com.yanzhuang.service;

import java.util.List;
import com.yanzhuang.po.Student;

public interface StudentService
{
	public StudentVO login(String stuid, String pwd);
	public List<Object> queryAll();
	public List<Object> queryAllByProfessionid(String professionid);
	public boolean saveStudent(Student stu);
	//public boolean clearCount(String sno,String count,String logintime);
	boolean updateAccount(Student stu);
	Student querySelectedUser(String stuid);
	Student querySelectedStudent(String stuid);
	List<Object> queryVagueUser(String stuname);
	boolean deleteAccount(String stuid);
	public int getMaxStuid();
	public int getCount();
}
