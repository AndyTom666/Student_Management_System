package com.yanzhuang.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yanzhuang.database.DBConnection;
import com.yanzhuang.mapper.TeacherServiceMapper;
import com.yanzhuang.po.Login;
import com.yanzhuang.po.Student;
import com.yanzhuang.po.Teacher;
import com.yanzhuang.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Resource
	private TeacherServiceMapper teacherServiceMapper;
	@Resource
	private DBConnection dbcon ;//= new DBConnection();

	@Override
	public Teacher login(String teacherid, String pwd) {
		// TODO Auto-generated method stub
		// StudentVO studentVo=new StudentVO();
		String sql = "select * from teacher where teacherid=?";
		// System.out.println("进来了");
		Object[] params = { teacherid };
		List<Object> lists = dbcon.executeQuery(sql, params, new Student());
		Teacher teacher = null;
		if (lists.size() == 0) {
			return teacher;
		}
		else {
			teacher = (Teacher) lists.get(0);
			if(!teacher.getPwd().equals(pwd))
				{
				return null;
				}
		}
		return teacher;
	}

	@Override
	public List<Object> queryAll() {
		// TODO Auto-generated method stub
		//String sql="select * from teacher";
		//return dbcon.executeQuery(sql, new Teacher());
		return teacherServiceMapper.queryAll();
	}
	@Override
	public List<Object> querySelectedUser(String teacherid) {
		// TODO Auto-generated method stub
		//String sql="select * from teacher where teacherid='"+teacherid+"'";
		//return dbcon.executeQuery(sql,new Teacher());
		return teacherServiceMapper.querySelectedUser(teacherid);
	}

	@Override
	public int getMaxTeachid() {
		String maxid = teacherServiceMapper.getMaxTeachid();
		if(maxid == null || "".equals(maxid)) return 0;
		String teachid = maxid.substring(5); // change from 2 to 5 to skip 'teach'
		return Integer.parseInt(teachid) + 1; // increment the teachid
	}

	@Override
	public boolean saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		//return dbcon.save(teacher);
		return teacherServiceMapper.saveTeacher(teacher);
	}

	@Override
	public boolean deleteAccount(String teacherid) {
		// TODO Auto-generated method stub
		//String sql="delete from teacher where teacherid=?";
		//Object[]params={teacherid};
		//return dbcon.executeUpdate(sql, params)>0;
		return teacherServiceMapper.deleteAccount(teacherid);
		
	}

	@Override
	public boolean updateAccount(Teacher teacher) {
		// TODO Auto-generated method stub
		//String sql="update teacher set teachername=?,pwd=?,professionid=?,role=? where teacherid=?";
		//Object[] params={teachername,pwd,professionid,role,teacherid};
		//return dbcon.executeUpdate(sql, params)>0;
		return teacherServiceMapper.updateAccount(teacher);
	}
}
