package com.yanzhuang.serviceimpl;

import java.util.List;

import com.yanzhuang.database.DBConnection;
import com.yanzhuang.po.Profession;
import com.yanzhuang.service.ProfessionService;

public class ProfessionServiceImpl implements ProfessionService
{	private DBConnection dbcon=new DBConnection();
	@Override
	public List<Object> queryAll() 
	{
		// TODO Auto-generated method stub
		String sql="select * from profession";
		 return dbcon.executeQuery(sql,new Profession());
	}
}
