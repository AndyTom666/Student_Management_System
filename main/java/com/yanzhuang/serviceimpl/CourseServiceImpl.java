package com.yanzhuang.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yanzhuang.database.DBConnection;
import com.yanzhuang.mapper.CourseServiceMapper;
import com.yanzhuang.po.Course;
import com.yanzhuang.po.Login;
import com.yanzhuang.po.Student;
import com.yanzhuang.po.Teacher;
import com.yanzhuang.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Resource
	private CourseServiceMapper courseServiceMapper;
	@Resource
	private DBConnection dbcon; // = new DBConnection();


	@Override
	public List<Object> queryAll() {
		// TODO Auto-generated method stub
		//String sql="select * from course";
		//return dbcon.executeQuery(sql, new Course());
		return courseServiceMapper.queryAll();
	}
	@Override
	public List<Object> querySelectedCourse(String courseid) {
		// TODO Auto-generated method stub
		//String sql="select * from course where courseid='"+courseid+"'";
		//return dbcon.executeQuery(sql,new Course());
		return courseServiceMapper.querySelectedCourse(courseid);
	}

	@Override
	public boolean saveCourse(Course course) {
		// TODO Auto-generated method stub
		//return dbcon.save(course);
		return courseServiceMapper.saveCourse(course);
	}
	@Override
	public boolean deleteCourse(String courseid) {
		// TODO Auto-generated method stub
		//String sql="delete from course where courseid=?";
		//Object[] params={courseid};
		//return dbcon.executeUpdate(sql, params)>0;
		return courseServiceMapper.deleteCourse(courseid);
	}
	@Override
	public boolean updateAccount(Course course) {
		// TODO Auto-generated method stub
		//String sql="update course set coursename=?,professionid=?,ratio=?,credit=? where courseid=?";
		//Object[] params={coursename,professionid,ratio,credit,courseid};
		//return dbcon.executeUpdate(sql, params)>0;
		return courseServiceMapper.updateAccount(course);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return courseServiceMapper.getCount();
	}
}

