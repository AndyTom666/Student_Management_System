package com.yanzhuang.util;


import javax.annotation.Resource;

import com.yanzhuang.po.ClickButton;
import com.yanzhuang.po.MiniprogramButton;
import com.yanzhuang.po.ViewButton;
import com.yanzhuang.serviceimpl.LoginServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
 
public class MenuMain {
	@Resource
 	 LoginServiceImpl lsi;
	public void xxa()
	{
		System.out.println(lsi.getallButtons().toString());
		
	}
		
    public static void main(String[] args) {
    	
        /*ClickButton cbt=new ClickButton();
        
        
        cbt.setKey("V1001_TODAY_MUSIC");
        cbt.setName("每日音乐");
        cbt.setType("click");
        
        
        MiniprogramButton mbt=new MiniprogramButton();
        
          
        mbt.setUrl("http://mp.weixin.qq.com");
        mbt.setAppid("wx286b93c14bbf93aa");
        mbt.setPagepath("pages/lunar/index");
        mbt.setType("miniprogram");
        mbt.setName("万年历");
        
        ViewButton vbt1=new ViewButton();
        
        vbt1.setUrl("http://www.qq.com");
        vbt1.setName("QQ");
        vbt1.setType("view");
        
         
         
        ViewButton vbt=new ViewButton();
        
        vbt.setUrl("http://www.baidu.com");
        vbt.setName("博客");
        vbt.setType("view");
         
        JSONArray sub_button=new JSONArray();
        //sub_button.add(vbt1);
        sub_button.add(vbt);
        //sub_button.add(cbt);
        //sub_button.add(mbt);
         
         
        JSONObject buttonOne=new JSONObject();
        buttonOne.put("name", "菜单");
        buttonOne.put("sub_button", sub_button);
         
        JSONArray button=new JSONArray();
        button.add(vbt);
        button.add(buttonOne);
        //button.add(cbt);
        button.add(mbt);
        button.add(vbt1);*/
        ClickButton cbt=new ClickButton();
        cbt.setKey("rselfmenu_2_0");
        cbt.setName("获取地址");
        cbt.setType("location_select");
        ClickButton cbt1=new ClickButton();
        cbt1.setKey("V1001_TODAY_MUSIC"); 
        cbt1.setName("每日音乐");
        cbt1.setType("click");
        ViewButton vbt=new ViewButton();
        vbt.setUrl("http://www.biying.com");
        vbt.setName("搜索");
        vbt.setType("view");
        
        MiniprogramButton mbt=new MiniprogramButton();
        
        
        mbt.setUrl("http://mp.weixin.qq.com");
        
        mbt.setPagepath("pages/lunar/index");
        mbt.setType("miniprogram");
        mbt.setName("万年历");
        mbt.setAppid("wx286b93c14bbf93aa");
         
        JSONArray sub_button=new JSONArray();
        sub_button.add(cbt);
        sub_button.add(vbt);
        sub_button.add(mbt);
        sub_button.add(cbt1);
        
         
        JSONObject buttonOne=new JSONObject();
        buttonOne.put("name", "菜单");
        buttonOne.put("sub_button", sub_button);
         
        JSONArray button=new JSONArray();
        button.add(vbt);
        button.add(buttonOne);
        button.add(cbt);
        //button.add(mbt);
         
        JSONObject menujson=new JSONObject();
        menujson.put("button", button);
        System.out.println(menujson);
        //new MenuMain().xxa();
        
        
        //这里为请求接口的url   +号后面的是token，这里就不做过多对token获取的方法解释
        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+
        "24_O5aYJTeEgmSKL9eKWUaLT89HHK1MP2uwcqLKug3E3HawEz_0LFVKmnAEhI1h6b8dC5qXdLrNfSDJxEYY4wb5H7n830XaCnol2PVvNNQWSGSaUEC86krPRYLuPR6RXGkDij-ugEk8umG_BPRBIXIaAFAVKV";
        /* 
        try{
        	String rs=HttpUtils.sendPostBuffer(url, menujson.toString());
            System.out.println(rs);
        }catch(Exception e){
            System.out.println("请求错误！");
        }*/
     
    }
 
}
