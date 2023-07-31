package com.yanzhuang.test3;

import java.util.*;

public class Test30
{
    public static String betterCompression(String s)
    {
        // Write your code here
        int count=-1;
        int countof=0;
        int sum=0;
        String so=null;
        String s2="";
        StringBuilder stb=new StringBuilder("");
        StringBuilder sts=new StringBuilder();
        HashSet<String> hashSet = new HashSet<>();
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        ArrayList<String>arrayList=new ArrayList<>();
        int temp=0;
        String[] str = s.split("");
        for (int i = 0; i < 10; i++)
        {
            hashSet.add(i + "");
        }
        for (String string:str)
        {
            countof++;
            if(!hashSet.contains(string))
            {
                if(!s2.equals(""))
                {
                    treeMap.put(arrayList.get(count),Integer.parseInt(s2));
                    s2="";
                }
                if(temp!=0&&!s2.equals(""))
                {
                    temp+=Integer.parseInt(s2);
                    treeMap.put(so,temp);
                    temp=0;
                }
                //sum=Integer.parseInt(stb.toString());
                if(treeMap.get(string)==null)
                {
                    arrayList.add(string);
                    treeMap.put(string,0);
                    count++;
                }else
                {
                    temp=treeMap.get(string);
                    so=string;
                }
            }else
            {
                /*if(temp!=0)
                {
                    temp+=Integer.parseInt(string);
                    //stb.append(temp+Integer.parseInt(string));
                    treeMap.put(so,temp);
                    temp=0;
                    continue;
                }*/
                s2+=string;
                if(countof==str.length)
                {
                    if(temp!=0)
                    {
                        temp += Integer.parseInt(s2);
                        //stb.append(temp+Integer.parseInt(string));
                        treeMap.put(so, temp);
                        temp = 0;
                        continue;
                    }
                    treeMap.put(arrayList.get(count),Integer.parseInt(s2));
                }
            }

        }
        Iterator iterator=treeMap.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String,Integer> entry=(Map.Entry<String,Integer>)iterator.next();
            sts.append(entry.getKey());
            sts.append(entry.getValue());
        }
        String result=sts.toString();
        return result;



    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(betterCompression(str));
    }
}
