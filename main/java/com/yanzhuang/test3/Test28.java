package com.yanzhuang.test3;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.TreeSet;

public class Test28
{
    public static String getMin(String a,String b)
    {
        String s=a+b;
        BigInteger numa=new BigInteger(a);
        BigInteger numb=new BigInteger(b);
        BigInteger numc=null;
        BigInteger min=new BigInteger(s);
        StringBuilder stb=new StringBuilder();
        char[] charsofA=a.toCharArray();
        char[] charsofB=b.toCharArray();
        int lena=a.length();
        int higha=lena-1;
        int lenb=b.length();
        int highb=lenb-1;
        for(int i=0;i<lena+lenb;i++)
        {
            /*while(higha==0&&highb!=0)
            {
                stb.append(charsofB[highb]);
                if(highb>0) highb--;
                continue;
            }
            while(highb==0&&higha!=0)
            {
                stb.append(charsofA[higha]);
                if(higha>0) higha--;
                continue;
            }*/
            if(charsofA[higha]>charsofB[highb]&&higha!=0||highb==0)
            {
                stb.append(charsofA[higha]);
                if(higha>0) higha--;
            }else if(charsofA[higha]==charsofB[highb]&&higha*highb>0)
            {
                if(charsofA[higha-1]>charsofB[highb-1])
                {
                    stb.append(charsofA[higha--]);
                }else
                {
                    stb.append(charsofB[highb--]);
                }

            }
            else if(charsofA[higha]<charsofB[highb]&&highb!=0||higha==0)
            {
                stb.append(charsofB[highb]);
                if(highb>0) highb--;
            }
        }
        String string=stb.reverse().toString();
        return string;


    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        System.out.println(getMin(a,b));
        scanner.close();
    }
}
