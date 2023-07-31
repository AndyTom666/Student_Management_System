package com.yanzhuang.test2;

import java.util.Scanner;

public class Test18
{
    public static String BigIntegerAdd(String a,String b)
    {
        Long longa=Long.parseLong(a);
        Long longb=Long.parseLong(b);
        Long sum=longa+longb;
        String sumof=sum.toString();
        return sumof;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        boolean token=false;
        while(scanner.hasNextLine())
        {
            String a=scanner.nextLine();
            String b=scanner.nextLine();
            token=true;
            if(token)
            {
                System.out.println(BigIntegerAdd(a,b));
            }
        }
    }
}
