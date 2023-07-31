package com.yanzhuang.test4;

import java.util.Scanner;

public class Test46
{
    public static boolean check(int num)
    {
        double nums=num;
        double result=Math.sqrt(nums);
        int results=(int) result;
        double left=result-results;
        if(left==0.0)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        sc.close();
        System.out.println(check(num));
    }
}