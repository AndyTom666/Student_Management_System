package com.yanzhuang.util;

public class App {

	public static void main(String[] args) {

		//String json="{\"x\":\"mm\",\"y\":4.0}";
	    // Point point=(Point)JSONUtil.toObject(json, Point.class);
	     
	    // System.out.println(point.toString());
	     Point point=new Point("mm",4);
	       //JSONObject json=JSONObject.fromObject(point);
	       System.out.println(JSONUtil.toJson(point));

	}

}
