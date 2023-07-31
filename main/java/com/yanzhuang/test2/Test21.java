package com.yanzhuang.test2;

import java.util.Scanner;

public class Test21
{
    public static int getCookieNumber(Scanner scanner)
{
    int num=0;
    int sum=0;
    if (scanner.hasNextLine())
    {
        String numberofChildren=scanner.nextLine();
        num=Integer.parseInt(numberofChildren);
    }
    int[] ints=new int[num];
    int[] ints2=new int[num];
    for(int i=0;i<num;i++)
    {
        ints[i]=Integer.parseInt(scanner.nextLine());
    }
    for(int i=0;i<num;i++)
    {
        ints2[i]=1;
    }
    for(int i=0;i<num;i++)
    {
        if(i-1>=0&&i+1<num)
        {
            if(ints[i]>ints[i-1]||ints[i]>ints[i+1])
            {
                if(ints[i]>ints[i-1]&&ints[i]>ints[i+1])
                {
                    ints2[i]=Math.max(ints2[i-1],ints2[i+1])+1;
                }else if(ints[i]>ints[i-1])
                {
                    ints2[i]=ints2[i-1]+1;
                }else if(ints[i]>ints[i+1])
                {
                    ints2[i]=ints2[i+1]+1;
                }

            }
        }else if(i-1<0&&i+1<num)
        {
            if(ints[i]>ints[i+1]) ints2[i]=ints2[i+1]+1;
        }else if(i+1>=num&&i-1>=0)
        {
            if(ints[i]>ints[i-1]) ints2[i]=ints2[i-1]+1;
        }
    }
    for(int value:ints2)
    {
        sum+=value;
    }
    return sum;

}
    public static void main(String []args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println(getCookieNumber(scanner));
    }
}
