package com.yanzhuang.mapper;

import java.util.List;

import com.yanzhuang.po.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseServiceMapper 
{
	public List<Object> queryAll();
	List<Object> querySelectedCourse(String courseid);
	public boolean saveCourse(Course course);
	boolean deleteCourse(String courseid);
	boolean updateAccount(Course course);
	public int getCount();
}
