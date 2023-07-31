package com.yanzhuang.util;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONObject;



public class AppStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Student1 student=new Student1();
      student.setName("njupt");
      List<Point> lists=new ArrayList<Point>();
      lists.add(new Point("3",4));
      lists.add(new Point("m",6));
      student.setPoints(lists);
      student.setHoppies(new String[]{"aa","bb","cc"});
      JSONObject json=JSONObject.fromObject(student);
      System.out.println(json.toString());
	}

}
