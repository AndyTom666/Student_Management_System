package com.yanzhuang.database;

import java.lang.reflect.Field;

import java.sql.ResultSet;

public class ORMUtil 
{
	public static Object toObject(ResultSet rs,Class clz)
	{
		if(rs==null||clz==null) return null;
		Object object=null;
		try{
		    object=clz.newInstance();
		    int cols=rs.getMetaData().getColumnCount();//寰楀埌澶氭暟鍒�
		    for(int i=0;i<cols;i++)
		    {
		    	String fieldName=rs.getMetaData().getColumnName(i+1);//寰楀埌瀛楁鍚�;
		    	Object value=rs.getObject(fieldName);//寰楀埌瀛楁鐨勫�硷紱
		    	Field field=clz.getDeclaredField(fieldName);//寰楀埌PO绫荤殑灞炴�у悕
		    	field.setAccessible(true);
		    	field.set(object, value);
		    }
		      
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return object;
	}

	
	public static Object[] toInsert(StringBuffer stf,Object object)
	{
		Class clz=object.getClass();
		//ArrayStack3 as=new ArrayStack3();
		Field[] fields=clz.getDeclaredFields();
		Object[] params=new Object[fields.length];
		String tableName=clz.getSimpleName();//绫诲悕鍗充负琛ㄥ悕
		stf.append("insert into ").append(tableName).append("(");
		try{
		for(int i=0;i<fields.length;i++)
		{
		    fields[i].setAccessible(true);
		    params[i]=fields[i].get(object);
		    stf.append(fields[i].getName()).append(",");
		    
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		int index=stf.lastIndexOf(",");
		stf.replace(index, index+1, ")values(");
		for(int i=0;i<fields.length;i++)
		   stf.append("?,");
	    index=stf.lastIndexOf(",");
		stf.replace(index, index+1, ")");
		//as.push(stf);
		//as.push(params);
		
		return params;
	}
}

