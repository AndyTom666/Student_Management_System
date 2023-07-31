package com.yanzhuang.http;

import java.lang.reflect.Field;
import java.util.HashMap;

public class JSONUtil 
{
	public static String toJson(Object obj)
	{
		if(obj==null) return null;
		Class clz=obj.getClass();
		String tojson=null;
		Object object=null;
		StringBuffer stb=new StringBuffer(300);
		stb.append("{");
		try{
			//object=clz.newInstance();
			Field[] fileds=clz.getDeclaredFields();
			for (Field field : fileds) {
				String fieldName=field.getName();
				stb.append("\"");
				stb.append(fieldName);
				stb.append("\":");
				field.setAccessible(true);
				Object value=field.get(obj);
				if(field.getType()==Integer.class||field.getType()==Integer.TYPE)
					stb.append(Integer.parseInt(value.toString())).append(",");
				else if(field.getType()==Double.class||field.getType()==Double.TYPE)
					stb.append(Double.parseDouble(value.toString())).append(",");
				else if(field.getType()==Boolean.class||field.getType()==Boolean.TYPE)
					stb.append(value.toString()).append(",");
				else
					stb.append("\""+value.toString()+"\",");
				/*stb.append(Double.parseDouble(value.toString()));
				stb.append(",");*/
			}
			int index=stb.lastIndexOf(",");
			stb.replace(index, index+1, "}");
		    /*for(int i=0;i<clz.getDeclaredFields().length;i++)
		    {
		    	
		    	String fieldName=fileds[i].getName();
		    	stb.append(fieldName);
		    	stb.append("\":");
		    	Field field=clz.getDeclaredField(fieldName);
		    	field.setAccessible(true);
		    	stb.append(Double.parseDouble(field.get(fieldName).toString()));
		    }*/
		      
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return stb.toString();
		
	}
	public static Object toObject(String json,Class clz)
	{
		if(json==null||"".equals(json)||clz==null) return null;
		String stf=json.substring(1,json.length()-1);
		String kv[]=stf.split(",");
		Object object=null;
		if(kv.length==0) return null;
		HashMap<String, String> maps=new HashMap<String,String>();
		for(int i=0;i<kv.length;i++)
		{
			String temp[]=kv[i].split(":");
			if(temp[1].contains("\"")) temp[1]=temp[1].substring(1, temp[1].length()-1);
			temp[0]=temp[0].substring(1, temp[0].length()-1);
			maps.put(temp[0],temp[1]);
		}
		Field[] fields=clz.getDeclaredFields();
		try
		{
			object=clz.newInstance();
			for (Field field : fields) 
			{
				field.setAccessible(true);
				String value=maps.get(field.getName());
				if(null==value)continue;
				if(field.getType()==Integer.class||field.getType()==Integer.TYPE)
			    	 field.set(object, Integer.parseInt(value));
			     else if(field.getType()==Double.class||field.getType()==Double.TYPE)
			    	   field.set(object, Double.parseDouble(value));
			     else if(field.getType()==Boolean.class||field.getType()==Boolean.TYPE)
			    	 field.set(object, Boolean.parseBoolean(value));
			     else
			    	 field.set(object, value); 
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return object;
		/*if(json==null) return null;
		try {
			Object object=clz.newInstance();
			char[] b=new char[json.length()];
			json.getChars(0, json.length()-1, b, 0);
			for (char c : b) {
				if(c!='"'||c!=':')
				{
					
				}
			}
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;*/
	}
}
