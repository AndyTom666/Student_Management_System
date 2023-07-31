package com.yanzhuang.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yanzhuang.database.DBConnection;
import com.yanzhuang.mapper.StuMarkInfoServiceMapper;
import com.yanzhuang.mapper.StudentServiceMapper;
import com.yanzhuang.po.StuMarkInfo;
import com.yanzhuang.po.StudentScore;
import com.yanzhuang.service.StuMarkInfoService;

@Service
public class StuMarkInfoServiceImpl implements StuMarkInfoService

{	
	@Resource
	private StuMarkInfoServiceMapper stuMarkInfoServiceMapper;
	@Resource
	private StudentServiceMapper studentServiceMapper;
	@Resource
	private DBConnection dbcon;//=new DBConnection();

	@Override
	public List<Object> queryAll() {
		// TODO Auto-generated method stub
		//String sql="select * from stumarkinfo";
		//return dbcon.executeQuery(sql,new StuMarkInfo());
		return stuMarkInfoServiceMapper.queryAll();
	}

	@Override
	public boolean saveStuMarkInfo(StuMarkInfo stumarkinfo) {
		// TODO Auto-generated method stub
		//return dbcon.save(stumarkinfo);
		return stuMarkInfoServiceMapper.saveStuMarkInfo(stumarkinfo);
	}

	@Override
	public boolean updateStuMarkInfo(StuMarkInfo stumarkinfo) 
	{
		// TODO Auto-generated method stub
		//String sql="update stumarkinfo set stuid=?,courseid=?,basescore=?,testscore=?,finalscore=?,adddate=?,note=? where markid=?";
		//Object[] params={stuid,courseid,basescore,testscore,finalscore,adddate,note,markid};
	    //return dbcon.executeUpdate(sql, params)>0;
		return stuMarkInfoServiceMapper.updateStuMarkInfo(stumarkinfo);
	}

	@Override
	public List<Object> querySelectedStuMarkInfo(String markid) {
		// TODO Auto-generated method stub
		//String sql="select * from stumarkinfo where markid='"+markid+"'";
		//return dbcon.executeQuery(sql,new StuMarkInfo());
		return stuMarkInfoServiceMapper.querySelectedStuMarkInfo(markid);
	}

	@Override
	public boolean deleteStuMarkInfo(String markid) {
		// TODO Auto-generated method stub
		//String sql="delete from stumarkinfo where markid=?";
		//Object[] params={markid};
	    //return dbcon.executeUpdate(sql, params)>0;
		return stuMarkInfoServiceMapper.deleteStuMarkInfo(markid);
	}

	@Override
	public boolean getTotalScore() {
		// TODO Auto-generated method stub
		//String sql="select stuid,sum(finalscore)as totalscore from stumarkinfo group by stuid";
		//List<Object> objs=dbcon.executeQuery(sql,new StudentScore());
		List<Object> objs=stuMarkInfoServiceMapper.getTotalScore();
		int count=0;
		for (Object object : objs) {
			StudentScore stus=(StudentScore)object;
			
			//sql="update student set totalscore=? where stuid=?";
			//Object[] params={sts.getTotalscore(),sts.getStuid()};
			//dbcon.executeUpdate(sql, params);
			if(studentServiceMapper.updateTotalScore(stus))
			count++;
		}
		return count==objs.size();
	}

	@Override
	public int getMaxMarkid() {
		// TODO Auto-generated method stub
		//String sql="select max(markid)from stumarkinfo";
		//Object[] temp=dbcon.executeSingleQuery(sql, null);
		String temp=stuMarkInfoServiceMapper.getMaxMarkid();
		if(temp==null) return 0;
		String markid=temp;
		if(markid==null||"".equals(markid)) return 0;
		markid=markid.substring(2);
		return Integer.parseInt(markid);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return stuMarkInfoServiceMapper.getCount();
	}

	@Override
	public boolean deleteMany(String[] tobedelete) {
		// TODO Auto-generated method stub
		return stuMarkInfoServiceMapper.deleteMany(tobedelete);
	}
	@Override
	public List<Object> getSelectedCourse(String stuid)
	{
		return stuMarkInfoServiceMapper.getSelectedCourse(stuid);
	}
	
}
