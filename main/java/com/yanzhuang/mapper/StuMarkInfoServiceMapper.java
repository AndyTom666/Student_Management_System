package com.yanzhuang.mapper;

import java.util.List;

import com.yanzhuang.po.StuMarkInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuMarkInfoServiceMapper 
{
	//public StudentVO login(String sno,String pwd);
		public List<Object> queryAll();
		//public boolean clearCount(String sno,String count,String logintime);
		List<Object> querySelectedStuMarkInfo(String markid);
		List<Object> getTotalScore();
		boolean deleteStuMarkInfo(String markid);
		boolean saveStuMarkInfo(StuMarkInfo stumarkinfo);
		boolean updateStuMarkInfo(StuMarkInfo stumarkinfo);
		public String getMaxMarkid();
		public int getCount();
		public boolean deleteMany(String[] tobedelete);
		public List<Object> getSelectedCourse(String stuid);
}
