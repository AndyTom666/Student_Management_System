package com.yanzhuang.po;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class Storage 
{
	private static Storage storage;
	Page page;
	private static Map<String, Page> map = new HashMap<String, Page>();
	
	private Storage()
	{
		
	}
	public synchronized static Storage getStorage()
    {
        if (null == storage)
        {
        	storage = new Storage();
        }
        return storage;
    }
    public void put(String uuid, Page Page)
    {
        map.put(uuid, Page);
    }
    
    public Page get(String uuid)
    {
        return map.get(uuid);
    }
    public void remove(String uuid)
    {
    	map.remove(uuid);
    }
	
}
