package com.yanzhuang.test3;

import java.math.BigInteger;
import java.util.Scanner;

public class Test29
{
    public static long getNum(long num)
    {
        long sum=1;
        for(long i=num;i>0;i--)
        {
            sum*=i;
        }
        sum/=2;
        return sum;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        long num=Long.parseLong(scanner.nextLine());
        scanner.nextLine();
        scanner.close();
        System.out.println(getNum(num));

    }
}
