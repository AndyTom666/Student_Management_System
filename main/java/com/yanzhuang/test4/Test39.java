package com.yanzhuang.test4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Test39
{
    public static int getMax(String[] strings,int[] ints)
    {
        int max=0;
        int len=strings.length;
        int lena=ints.length;
        int[] temps=new int[lena];
        ArrayList<Character>[] arrayLists=new ArrayList[lena];
        for(int i=0;i<lena;i++)
        {
            arrayLists[i]=new ArrayList<Character>();
        }
        for(int k=0;k<lena;k++)
        {
            temps[k]=1;
        }
        char[] chars=new char[lena];
        for(int i=0;i<len;i++)
        {
            chars=strings[i].toCharArray();
            int lenof=chars.length;
            for(int j=0;j<lenof;j++)
            {
                if(!arrayLists[j].contains(chars[j]))
                {
                    arrayLists[j].add(chars[j]);
                }
                else
                {
                    int temp=temps[j]+1;
                    temps[j]=temp;
                }
            }
        }
        for(int i=0;i<lena;i++)
        {
            max+=ints[i]*temps[i];
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        //System.out.println(x+" "+y);
        String[] strings=new String[x];
        int[] ints=new int[y];
        scanner.nextLine();
        for(int i=0;i<x;i++)
        {
            strings[i]=scanner.nextLine();
        }
        //scanner.nextLine();
        /*String num=scanner.nextLine();
        String[] nums=num.split(" ");
        for(String s:nums)
        {
            System.out.println(s);
        }
        for(int i=0;i<y;i++)
        {
            ints[i]=Integer.parseInt(nums[i]);
        }*/
        for(int i=0;i<y;i++)
        {
            ints[i]=scanner.nextInt();
        }
        scanner.close();
        System.out.println(getMax(strings,ints));

    }
}
