package com.yanzhuang.test;

import java.util.Scanner;
public class Test5
{
    public static int getNailNumber(int n)
    {

            int min=Integer.MAX_VALUE;
            Double i,j;
            for(i=0.0;i<=n/4;i++)
            {
                j=(n-4*i)/9;
                if((j-j.intValue())==0)
                {
                    if((int)(i+j)<min) {
                        min = (int) (i + j);
                    }
                }
            }
            if(min==Integer.MAX_VALUE) return -1;
            else return min;




    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            System.out.println(getNailNumber(n));
        }
    }

}
