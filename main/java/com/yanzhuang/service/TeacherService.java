package com.yanzhuang.service;

import java.util.List;

import com.yanzhuang.po.Login;
import com.yanzhuang.po.Teacher;

public interface TeacherService 
{
	public Teacher login(String teacherid, String pwd);
	public List<Object> queryAll();
	List<Object> querySelectedUser(String teacherid);
	public boolean saveTeacher(Teacher teacher);
	boolean deleteAccount(String teacherid);
	boolean updateAccount(Teacher teacher);
	public int getMaxTeachid();
}
