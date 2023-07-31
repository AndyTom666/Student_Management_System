package com.yanzhuang.mapper;

import java.util.List;

import com.yanzhuang.po.Login;
import com.yanzhuang.po.LoginVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginServiceMapper 
{
	public Login login(String stuid);
	public boolean saveLogin(Login login);
	public List<Object> getButtons();
	public List<Object> getMenu();
	
	
}
