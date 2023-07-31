package com.yanzhuang.test2;

import java.util.HashMap;
import java.util.Scanner;

public class Test20
{
     public static int getCount(String s)
     {
         HashMap<String,Integer> hm=new HashMap<>();
         String[] strings=s.split(",");
         for(String string:strings)
         {
             hm.put(string,Integer.parseInt(string));
         }
         return hm.size();

     }
     public static void main(String[] args)
     {
         Scanner scanner=new Scanner(System.in);
         while (scanner.hasNextLine())
         {
             String s=scanner.nextLine();
             if(s.equals("exit"))
             {
                 scanner.close();
                 break;
             }
             System.out.println(getCount(s));
         }
     }
}
