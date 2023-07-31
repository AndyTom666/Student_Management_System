package com.yanzhuang.http;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.yanzhuang.po.AccessToken;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;

import com.yanzhuang.po.Student;
import com.yanzhuang.service.StudentService;
import com.yanzhuang.serviceimpl.StudentServiceImpl;

import net.sf.json.*;


public class HttpTest {

	
	public static void getMethod(String testUrl) throws Exception {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(testUrl);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				System.out.println(EntityUtils.toString(entity));
			
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}
	
	public static void postMethod(String testUrl) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(testUrl);
		    StringEntity ent = new StringEntity("{\"stuid\":\"te0001\",\"pwd\":\"123\"}");
	    	httpPost.setEntity(ent);
		    CloseableHttpResponse response = httpclient.execute(httpPost);
		   try {
			    System.out.println(response.getStatusLine());
		        HttpEntity entity = response.getEntity();
		        System.out.println(EntityUtils.toString(entity));
		     } finally {
		       response.close();
		    }
		} finally {
			httpclient.close();
		}   
		}

    public static void post2(String url,String user,String pwd)
    {
    	try{
    	 Content con=Request.Post(url).bodyForm(
    			Form.form().add("stuid", user).add("pwd", pwd).build()).execute().returnContent();
    	System.out.println(con.toString());
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	
    public static String get(String url)
    {
    	try{
    	 Content con=Request.Get(url).execute().returnContent();
    	 return con.toString();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return "";
    }
	
    public static String postTwo(String url)
    {
    	try{
    	 Content con=Request.Post(url).execute().returnContent();
    	 return con.toString();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return "";
    }
    public Object[] getOut(String url)
    {
    	Student stus=new Student();
    	String jsonstring=get(url);
	    System.out.println(jsonstring);
	    //JSONArray json=JSONArray.fromObject(jsonstring);
	    JSONArray jsonArray=JSONArray.fromObject(jsonstring);
	    int size=jsonArray.size();
	    List<Object> lists=new ArrayList<Object>();
	    Object[] objs=new Object[size];
	    int i=0;
	    for (Object object : jsonArray) 
	    {
	    	objs[i]=JSONUtil.toObject(object.toString(), Studentwai.class);
	    	System.out.println(objs[i]);
	    	i++;
		}
	   
		return objs;
    }
    
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		HttpTest ht=new HttpTest();
		/*String url="https://api.weixin.qq.com/cgi-bin/token?grant_type" +
				"=client_credential&appid=wxf69722644f6d60e9&secret=fadcc3f7f35049148e31403f28c8a822";
		String json=get(url);
		JSONObject jsonObject=JSONObject.fromObject(json);
		AccessToken accessToken=(AccessToken) JSONObject.toBean(jsonObject,AccessToken.class);*/


		//ht.getOut();
      //getMethod("http://192.168.1.118:8080/webStudent/view");
	  // System.out.println(get("http://192.168.1.21:8080/EPointMVC/view.qf?page=1&count=10"));
    // postMethod("http://192.168.1.5:8080/webStudentManager/login.do");
	 /*for(int i=0;i<20;i++)
	  {
		Thread thread= new Thread(new Runnable() {
			public void run() {
				
				post2("http://192.168.1.5:8080/webStudentManager/login.do","te0001","123");
			}
		});
	  thread.start();
	  }	*/
		
    //System.out.println(get("http://192.168.1.118:8080/webStudent/view"));
		
    
    
    
	}

}
