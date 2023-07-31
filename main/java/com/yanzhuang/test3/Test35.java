package com.yanzhuang.test3;

import java.util.Scanner;

public class Test35 {
    public static int getCount(int numbers)
    {
        int count=0;
        int reg=numbers/2;
        int size=1;
        int s=1;
        for(int i=0;i<=reg;i++)
        {
            size=numbers-i;
            int temp=size;
            int index=i;
            for(int j=0;j<i;j++)
            {
                s*=temp;
                temp--;
                s/=index;
                index--;
            }
            count+=s;
            s=1;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println(getCount(scanner.nextInt()));
        scanner.close();
    }

}
