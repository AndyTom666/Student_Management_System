package com.yanzhuang.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yanzhuang.database.DBConnection;
import com.yanzhuang.mapper.LoginServiceMapper;
import com.yanzhuang.po.Login;
import com.yanzhuang.po.LoginVO;
import com.yanzhuang.po.Student;
import com.yanzhuang.po.Teacher;
import com.yanzhuang.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{
	@Resource
	private LoginServiceMapper loginServiceMapper;
	@Resource
	private DBConnection dbcon; //= new DBConnection();
	public LoginVO login(String stuid,String pwd)
	{
		//String sql = "select * from login where stuid=?";
		// System.out.println("进来了");
		//Object[] params = { stuid };
		LoginVO loginVo=new LoginVO();
		
		//List<Object> lists = dbcon.executeQuery(sql, params, new Login());
		//System.out.println(stuid);
		Login log = loginServiceMapper.login(stuid);
		//System.out.println(log.getStuid());
		if (log==null) {
			loginVo.setLog(new Login());
			loginVo.setMessage("notexist");
			return loginVo;
		}
		if(!log.getPwd().equals(pwd))
				{
			loginVo.setLog(new Login());
			loginVo.setMessage("wrong pwd");
			return loginVo;
				}
		if(log.getRole()==1) loginVo.setMessage("welcome student");
		if(log.getRole()==2) loginVo.setMessage("welcome teacher");
		loginVo.setLog(log);
		
		return loginVo;
	}
	@Override
	public boolean saveLogin(Login login) {
		// TODO Auto-generated method stub
		 //return dbcon.save(login);
		return loginServiceMapper.saveLogin(login);
	}
	@Override
	public List<Object> getallButtons() {
		// TODO Auto-generated method stub
		return loginServiceMapper.getButtons();
	}
	@Override
	public List<Object> getMenu() {
		// TODO Auto-generated method stub
		return loginServiceMapper.getMenu();
	}
	
	 
}
