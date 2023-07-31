package com.yanzhuang.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class App {

    private static Map<String,String> map=new HashMap<String,String>();
    public static boolean hasAdd(String code)
    {
        char[] temp=code.toCharArray();
        for(int i=0;i<temp.length;i++)
            if(temp[i]=='+') return false;
        return true;
    }
    public static String Test1(int n)
    {
        String code=null;
        Scanner reader=new Scanner(System.in);
        for(int i=n;i>0;--i)
        {
            code=reader.nextLine();
            code=code.replace(" ", "");
            //System.out.println(code);
            Test2(code);
        }
        String[] m=code.split("=");
        String re=map.get(m[0]);
        if(re==null) return "NA";
        return re;

    }
    public static String Test2(String code)
    {
        int m=0;
        String[] code2=code.split("=");
        if(hasAdd(code2[1]))
        {
            map.put(code2[0], code2[1]);
        }
        else
        {
            String[] value=code2[1].split("\\+");
            for(int i=0;i<value.length;++i)
            {
                char[] temp=value[i].toCharArray();
                if(temp[0]>='0'&&temp[0]<='9')
                {
                    m+=Integer.parseInt(value[i]);
                }
                else
                {
                    String value2=map.get(value[i]);
                    if(value2==null) return "NA";
                    m+=Integer.parseInt(value2);
                }
            }
            map.put(code2[0], String.valueOf(m));
        }
        return "yes";
    }
    public static void main(String[] args)
    {
        int x=4;
        System.out.println(Math.sqrt(x));
        //Scanner reader=new Scanner(System.in);
        //int n=reader.nextInt();
        //System.out.println(Test1(n));


    }

}
