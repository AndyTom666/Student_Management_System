package com.yanzhuang.test5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test51 {
    public static void main(String[] args) {
        String a ="abc*def";
        String b ="abc"+"*def";
        String c = "abc"+new String("*def");
//        System.out.println(a==b);
//        System.out.println(b==c);
//        System.out.println(b.equals(c));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println(System.currentTimeMillis());
    }
}
