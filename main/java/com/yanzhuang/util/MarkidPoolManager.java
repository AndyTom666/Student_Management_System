package com.yanzhuang.util;

import java.util.*;


import javax.servlet.http.HttpSession;



import com.yanzhuang.po.StuMarkInfo;
import com.yanzhuang.serviceimpl.StudentServiceImpl;

public class MarkidPoolManager 
{
	private static Hashtable<String,MarkidNode> markidpools=
			new Hashtable<String,MarkidNode>();
	public static int max=-1;
	private String changeMarkid()
	{
		max++;
		if(max<10) return "m000"+max;
		if(max<100) return "m00"+max;
		if(max<1000) return "m0"+max;
		return "m"+max;
	}
	synchronized
	public String getMarkid(String sessionID)
	{
		MarkidNode node=markidpools.get(sessionID);
		long current=System.currentTimeMillis();
		//1、避免恶意刷号
		if(node!=null&&(current-node.allocateTime)<5*60*1000)
		{
			node.allocateTime=current;
			return node.markid;
		}
		//2、利用已失效的学号
		Iterator<String> keys=markidpools.keySet().iterator();
		while(keys.hasNext())
		{
			MarkidNode node2=markidpools.get(keys.next());
			if((current-node2.allocateTime)>5*60*1000)
			{
				node2.session=sessionID;
				node2.allocateTime=current;
				return node2.markid;
			}
		}
		//上述都不行就创建一个新的学号节点
		String markid=changeMarkid();
		MarkidNode p=new MarkidNode(markid, sessionID, current);
		markidpools.put(sessionID, p);
		return markid;
	}
	
	synchronized
	public boolean removeStuid(String sessionID)
	{
		return markidpools.remove(sessionID)!=null;
	}

}
