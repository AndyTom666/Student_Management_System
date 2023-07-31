package com.yanzhuang.test4;

import java.util.HashSet;
import java.util.Scanner;

public class Test40
{
    public static boolean find(int[][]ints,int num)
    {
        HashSet hashSet=new HashSet();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<4;j++)
            {
                hashSet.add(ints[i][j]);
            }
        }
        if(hashSet.contains(num))
        {
            return true;
        }else
        {
            return false;
        }
    }
    public static void main(String[] args)
    {
        int[] int1=new int[]{1,2,8,9};
        int[] int2=new int[]{2,4,9,12};
        int[] int3=new int[]{4,9,10,13};
        int[][]x=new int[][]{int1,int2,int3};
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        char[] chars=s.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<chars.length;i++)
        {
            if(chars[i]>=48&&chars[i]<=57)
            {
                stringBuilder.append(chars[i]);
            }
        }
        int n=Integer.parseInt(stringBuilder.toString());
        System.out.println(find(x,n));
        scanner.close();
    }
}
