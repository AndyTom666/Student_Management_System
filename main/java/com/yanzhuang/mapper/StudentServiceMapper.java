package com.yanzhuang.mapper;

import java.util.List;
import com.yanzhuang.po.Student;
import com.yanzhuang.po.StudentScore;
import com.yanzhuang.service.StudentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentServiceMapper 
{
	StudentVO login(String stuid, String pwd);
	public List<Object> queryAll();
	public List<Object> queryAllByProfessionid(String professionid);
	public boolean saveStudent(Student stu);
	//public boolean clearCount(String sno,String count,String logintime);
	boolean updateAccount(Student stu);
	Student querySelectedUser(String stuid);
	List<Object> queryVagueUser(String stuname);
	boolean deleteAccount(String stuid);
	public String getMaxStuid();
	public int getCount();
	public boolean updateTotalScore(StudentScore stus);
	Student querySelectedStudent(String stuid);

}
