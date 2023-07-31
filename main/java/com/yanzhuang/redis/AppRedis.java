package com.yanzhuang.redis;

import redis.clients.jedis.Jedis;

public class AppRedis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Jedis jedis = new Jedis("192.168.1.5");
		  //jedis.auth("root");
		   System.out.println( jedis.ping());
	        //System.out.println("我来也");
	        //锟斤拷锟斤拷 redis 锟街凤拷锟斤拷锟斤拷锟斤拷
	       jedis.set("ef", "wwwaffa");
	        // 锟斤拷取锟芥储锟斤拷锟斤拷锟捷诧拷锟斤拷锟�
	       System.out.println("redis:  "+ jedis.get("ef"));
	       // System.out.println("删除: "+ jedis.del("ef"));
	}

}

