package com.yanzhuang.test4;

import java.util.Scanner;

public class Test45
{
    public static int getScore(String[] strs,int count)
    {
        int sumScore=0;
        StringBuilder stb1=new StringBuilder();
        StringBuilder stb2=new StringBuilder();
        for(int i=0;i<count;i++)
        {
            if(strs[i+1].equals(strs[i]))
            {
                sumScore+=3;
                i++;
                continue;
            }else if(strs[i+1].contains(strs[i]))
            {
                sumScore+=1;
                i++;
            }
        }
        return sumScore;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int count=0;
        String[] strs=new String[100];
        String temp;
        while(sc.hasNext())

        {

            temp=sc.next();
            if(temp.equals("quit"))
            {
                break;
            }
            String[] s=temp.split(",");
            strs[count++]=s[0];
            strs[count++]=s[1];
        }
        sc.close();
        System.out.println(getScore(strs,count));
    }
}
