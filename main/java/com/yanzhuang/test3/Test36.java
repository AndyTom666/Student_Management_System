package com.yanzhuang.test3;

import java.util.Scanner;

public class Test36
{
    public static int[] getMoney(String str)
    {
        String[] strs=str.split(",");
        StringBuilder stb=new StringBuilder();
        StringBuilder sts=new StringBuilder();
        for(String string:strs)
        {
            stb.append(string);
        }
        String result=stb.toString();
        int results=Integer.parseInt(result)+1;
        String res=results+"";
        String[] strings=res.split("");
        int len=strings.length;
        int[] ints=new int[len];
        for(int i=0;i<len;i++)
        {
            ints[i]=Integer.parseInt(strings[i]);

        }
        return  ints;


    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int[] ints=getMoney(scanner.nextLine());
        scanner.close();
        for(int i=0;i<ints.length;i++)
        {
            if(i!=ints.length-1)
            {
                System.out.print(ints[i]+",");
            }else
            {
                System.out.print(ints[i]);
            }
        }
    }
}
