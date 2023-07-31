package com.yanzhuang.test3;

import java.util.*;

public class Test38
{
    public static int getCount(long[] longs)
    {
        int count=0;
        int len=longs.length;
        int index=0;
        long temps[]=new long[len];
        long max=0;
        TreeSet<Long> treeSet=new TreeSet<>();
        for(int i=0;i<len;i++)
        {
            if(longs[i]>max)
            {
                max=longs[i];
                index=i;
            }
        }
        while (true)
        {
            if(longs[index]<len) break;
            for(int i=0;i<len;i++)
            {
                longs[i]+=1;
            }
            longs[index]-=len+1;
            for(int i=0;i<len;i++)
            {
                if(longs[i]>max)
                {
                    max=longs[i];
                    index=i;
                }
            }
            count++;
        }
        /*for(int i=0;i<len;i++)
        {
            treeSet.add(longs[i]);
        }*/
        /*while (true)
        {
            if(treeSet.last()<len) break;
            Iterator iterator=treeSet.iterator();
            for(int i=0;i<len;i++)
            {
                temps[i]=(long)iterator.next()+1;
            }
            temps[len-1]-=len+1;
            treeSet.clear();
            for(int i=0;i<len;i++)
            {
                treeSet.add(temps[i]);
            }
            count++;

        }*/
        return count;


    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        long[] longs=new long[m];
        for(int i=0;i<m;i++)
        {
            longs[i]=scanner.nextLong();
        }
        scanner.close();
        System.out.println(getCount(longs));

    }
}