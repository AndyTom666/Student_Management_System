package com.yanzhuang.util;

import java.util.Hashtable;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

public class AccountPoolManager 
{
	private static Hashtable<String,AccountNode> accountpools=
			new Hashtable<String,AccountNode>();
	synchronized
	public boolean checkDuplicateStuid(String stuid,HttpSession session)
	{
		boolean token=false;
		AccountNode node=accountpools.get(stuid);
		if(node!=null)
		{
			if(!node.getSession().isNew())
			{
			     //node.getSession().invalidate();
			     node.getSession().removeAttribute("log");
			     token=true;
			}
			node.setSession(session);
		}
		AccountNode p=new AccountNode(stuid,session);
		accountpools.put(stuid, p);
		return token;
	}
	
	synchronized
	public boolean removeStuid(String stuid)
	{
		return accountpools.remove(stuid)!=null;
	}
}
