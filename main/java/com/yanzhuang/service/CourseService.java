package com.yanzhuang.service;

import java.util.List;

import com.yanzhuang.po.Course;

public interface CourseService 
{
	public List<Object> queryAll();
	List<Object> querySelectedCourse(String courseid);
	public boolean saveCourse(Course course);
	boolean deleteCourse(String courseid);
	boolean updateAccount(Course course);
	public int getCount();
}
