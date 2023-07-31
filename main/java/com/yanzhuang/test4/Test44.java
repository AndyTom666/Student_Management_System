package com.yanzhuang.test4;

import java.util.Scanner;

public class Test44
{
    public static int[] getArray(int num)
    {
        int[] array=new int[num+1];
        int res=0;
        for(int i=0;i<=num;i++)
        {
            int j=i;
            if(j%2!=0)
            {
                res++;
            }
            while(j>1)
            {
                j/=2;
                res++;
            }

            array[i]=res;
            res=0;
        }
        array[1]=1;
        return array;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[] array=getArray(num);
        int len=array.length;
        for(int i=0;i<len;i++)
        {
            if(i<len-1)
                System.out.print(array[i]+",");
            else
                System.out.print(array[i]);
        }
    }
}
