package com.yanzhuang.test4;

import java.util.Scanner;

public class Test42
{
    public static double getShape(long number)
    {
        double result=1.0;
        for(long i=2*number;i>0;i--)
        {
            result*=i;
        }
        for(long i=number;i>0;i--)
        {
            result/=i;
            result/=i;
        }
        return result/=(number+1);

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println((long)getShape(scanner.nextLong()));
        scanner.close();
    }
}
