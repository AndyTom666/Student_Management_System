package com.yanzhuang.redis;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import redis.clients.jedis.Jedis;

public class RedisUtil 
{
	private String host;
	private Integer port;
	private String password;
	private static Jedis jredis=null;
	
	public RedisUtil()
	{
		if(jredis==null)
		{
			RedisUtil.jredis=new Jedis(host,port);
			if(!(password==null||"".equals(password)))
				jredis.auth(password);
		}
	}
	
	public boolean setString(String key,String value)
	{
		if(key==null||value==null) return false;
		return "OK".equals(RedisUtil.jredis.set(key, value));
	}
	
	public boolean setSingleObject(String key,Object value)
	{
		if(key==null||value==null) return false;
		JSONObject josnobject=JSONObject.fromObject(value);
		String json=josnobject.toString();
		return "OK".equals(RedisUtil.jredis.set(key, json));
	}

	public boolean setList(String key,List<Object> value)
	{
		if(key==null||value==null) return false;
		JSONArray josnobject=JSONArray.fromObject(value);
		String json=josnobject.toString();
		return "OK".equals(RedisUtil.jredis.set(key, json));
	}
	
	public String getString(String key)
	{
		return RedisUtil.jredis.get(key);
	}

	public Object getObject(String key,Object object)
	{
		if(key==null||object==null) return null;
		String json=RedisUtil.jredis.get(key);
		JSONObject josnobject=JSONObject.fromObject(json);
		return JSONObject.toBean(josnobject,object.getClass());
	}
	
	public List<Object> getList(String key,Object object)
	{
		if(key==null||object==null) return null;
		String json=RedisUtil.jredis.get(key);
		JSONArray josnobject=JSONArray.fromObject(json);
		List<Object> lists=new ArrayList<Object>();
		Object[] data=josnobject.toArray();
		for (Object object2 : data) 
		{
			 JSONObject tobject=(JSONObject)object2;
			 tobject=JSONObject.fromObject(json);//没看懂
			 lists.add(JSONObject.toBean(tobject,object.getClass()));
		}
		return lists;
	}
	
	public boolean removeKey(String key)
	{
		if(key==null||"".equals(key)) return false;
		return RedisUtil.jredis.del(key)>0;
	}
	
	
}

