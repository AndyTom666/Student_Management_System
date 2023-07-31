package com.yanzhuang.service;

import java.util.List;

import com.yanzhuang.po.Login;
import com.yanzhuang.po.LoginVO;
import com.yanzhuang.po.Student;

public interface LoginService 
{
	public LoginVO login(String stuid, String pwd);
	public boolean saveLogin(Login login);
	public List<Object> getallButtons();
	public List<Object> getMenu();
}
