package com.yanzhuang.util;

import java.util.*;
import javax.servlet.http.HttpSession;
import com.yanzhuang.po.Student;
import com.yanzhuang.serviceimpl.StudentServiceImpl;

public class StuidPoolManager 
{
	private static Hashtable<String,StuidNode> stuidpools=
			new Hashtable<String,StuidNode>();
	public static int max=-1;
	private String changeStuid()
	{
		max++;
		if(max<10) return "stuid0000"+max;
		if(max<100) return "stuid000"+max;
		if(max<1000) return "stuid00"+max;
		return "stuid"+max;
	}
	synchronized
	public String getStuid(String sessionID)
	{
		StuidNode node=stuidpools.get(sessionID);
		long current=System.currentTimeMillis();
		//1、避免恶意刷号
		if(node!=null&&(current-node.allocateTime)<5*60*1000)
		{
			node.allocateTime=current;
			return node.stuid;
		}
		//2、利用已失效的学号
		Iterator<String> keys=stuidpools.keySet().iterator();
		while(keys.hasNext())
		{
			StuidNode node2=stuidpools.get(keys.next());
			if((current-node2.allocateTime)>5*60*1000)
			{
				node2.session=sessionID;
				node2.allocateTime=current;
				return node2.stuid;
			}
		}
		//上述都不行就创建一个新的学号节点
		String stuid=changeStuid();
		StuidNode p=new StuidNode(sessionID, stuid, current);
		stuidpools.put(sessionID, p);
		return stuid;
	}
	
	synchronized
	public boolean removeStuid(String sessionID)
	{
		return stuidpools.remove(sessionID)!=null;
	}
	public void stuidPool(){
		StudentServiceImpl ssi=new StudentServiceImpl();
		List<Object> lists=ssi.queryStuid();
		Student stu=(Student)lists.get(0);
		if(stu==null) return ;
		String max=stu.getStuid();
		String stuid0=max.substring(2, max.length());
		String stuid1=stuid0.substring(0,4);
		int num=Integer.parseInt(stuid1);
		
		
	}
}
