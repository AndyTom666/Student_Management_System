package com.yanzhuang.serviceimpl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yanzhuang.database.DBConnection;
import com.yanzhuang.database.ORMUtil;
import com.yanzhuang.mapper.LoginServiceMapper;
import com.yanzhuang.mapper.StudentServiceMapper;
import com.yanzhuang.po.Student;
import com.yanzhuang.service.StudentService;
import com.yanzhuang.service.StudentVO;

@Service
public class StudentServiceImpl implements StudentService
{
	 @Resource
     private DBConnection dbcon;//=new DBConnection();
	 @Resource
	 private StudentServiceMapper studentServiceMapper;
	@Override
	public StudentVO login(String stuid, String pwd) {
		// TODO Auto-generated method stub
		StudentVO studentVo=new StudentVO();
		String sql="select * from student where stuid=?";
		//System.out.println("进来了");
		Object[] params={stuid};
		List<Object> lists=dbcon.executeQuery(sql, params,new Student());
		if(lists.size()==0) studentVo.setMessage("用户名不存在");
		
		else  {
			Student stu=(Student)lists.get(0);
		     studentVo.setStudent(stu);
		     studentVo.setMessage("success");
		  }
		return studentVo;
	}

	@Override
	public List<Object> queryAll() {
		
		List<Object> lists=studentServiceMapper.queryAll();
		
		
		//System.out.println(lists.get(3));
		return lists;
		// TODO Auto-generated method stub
		//String sql="select * from student";
		 //return dbcon.executeQuery(sql,new Student());
		
	}
	@Override
	public Student querySelectedUser(String stuid)
	{
		return studentServiceMapper.querySelectedUser(stuid);
		//String sql="select * from student where stuid='"+stuid+"'";
		//return dbcon.executeQuery(sql,new Student());
	}
	public List<Object> queryStuid()
	{
		String sql="select * from student where stuid=(select max(stuid) from student)";
		return dbcon.executeQuery(sql,new Student());
	}

	@Override
	public boolean saveStudent(Student stu) 
	{
		// TODO Auto-generated method stub
		//StringBuffer stf=new StringBuffer(100);
		//Object[] params=(Object[]) ORMUtil.toInsert(stf, stu).pop();
		//String sql=(String) ORMUtil.toInsert(stf, stu).pop();
		//dbcon.executeUpdate(, )
		/*String sql="insert into student(stuid,stuname,pwd,professionid,role,date,sex,idnum,totalscore,photo,note)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";*/
		/*Object[] params={stu.getStuid(),stu.getStuname(),stu.getPwd(),stu.getProfession(),stu.getDate(),stu.getSex(),stu.getIdnum()
				,stu.getTotalscore(),stu.getIdnum(),stu.getTotalscore(),stu.getNote()};	*/	
		//return dbcon.save(stu);
		return studentServiceMapper.saveStudent(stu);
	}

	@Override
	/*public boolean clearCount(String sno,String count, String logintime) {
		// TODO Auto-generated method stub
		String sql="update student set count=?,logintime=? where sno=?";
		Object[] params={count,logintime,sno};
	    return dbcon.executeUpdate(sql, params)>0;
	}*/
	public boolean updateAccount(Student stu) {
		// TODO Auto-generated method stub
		//String sql="update student set stuname=?,pwd=?,professionid=?,date=?,sex=?,idnum=?,totalscore=?,photo='',photo='',note='' where stuid=?";
		//Object[] params={stuname,pwd,professionid,date,sex,idnum,totalscore,stuid};
	    //return dbcon.executeUpdate(sql, params)>0;
		return studentServiceMapper.updateAccount(stu);
	}
	@Override
	public boolean deleteAccount(String stuid) {
		// TODO Auto-generated method stub
		//String sql="delete from student where stuid=?";
		//Object[] params={stuid};
	    return studentServiceMapper.deleteAccount(stuid);
	}

	@Override
	public int getMaxStuid() {
		String temp = studentServiceMapper.getMaxStuid();
		if(temp == null || "".equals(temp)) return 0;
		String stuid = temp.substring(5); // change from 2 to 5 to skip 'stuid'
		return Integer.parseInt(stuid) + 1; // increment the stuid
	}


	@Override
	public List<Object> queryAllByProfessionid(String professionid) {
		// TODO Auto-generated method stub
		//String sql="select * from student where professionid='"+professionid+"'";
		//return dbcon.executeQuery(sql, new Student());
		return studentServiceMapper.queryAllByProfessionid(professionid);
	}

	@Override
	public List<Object> queryVagueUser(String stuname) {
		// TODO Auto-generated method stub
		//String sql="select * from student where stuname like'%"+stuname+"%'";
		//return dbcon.executeQuery(sql,new Student());
		return studentServiceMapper.queryVagueUser(stuname);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return studentServiceMapper.getCount();
	}

	@Override
	public Student querySelectedStudent(String stuid) {
		// TODO Auto-generated method stub
		return studentServiceMapper.querySelectedStudent(stuid);
	}

	

}
