package com.yanzhuang.test4;

import java.util.Scanner;

public class Test43
{
    public static long getNumber(long min,long max)
    {
        long sum=0;
        for(long i=max;i>=min;i--)
        {
            sum+=getOneNumber(i);
        }
        return sum;

    }
    public static int getOneNumber(long min)
    {
        int r;
        long zero=0;
        long one=0;
        int i=0;
        int[] ints=new int[100];
        do
        {
            if(min%2==1)
            {
                r=1;
                one++;
            }else
            {
                r=0;
                zero++;
            }
            ints[i]=r;
            min/=2;
            i++;
        }
        while (min>0);
        if(zero>=one)
        {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String[] strings=string.split(",");
        long min=Long.parseLong(strings[0]);
        long max=Long.parseLong(strings[1]);
        System.out.println(getNumber(min,max));
        scanner.close();
    }
}
