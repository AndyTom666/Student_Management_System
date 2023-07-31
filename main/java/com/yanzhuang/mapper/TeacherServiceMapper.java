package com.yanzhuang.mapper;

import java.util.List;

import com.yanzhuang.po.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherServiceMapper 
{
	public Teacher login(String teacherid, String pwd);
	public List<Object> queryAll();
	List<Object> querySelectedUser(String teacherid);
	public boolean saveTeacher(Teacher teacher);
	boolean deleteAccount(String teacherid);
	boolean updateAccount(Teacher teacher);
	public String getMaxTeachid();
}
