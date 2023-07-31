package com.yanzhuang.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test9 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^   1(2(3,4(,5)),6(7,))     3245176
    ******************************开始写代码******************************/
    static String solution(String input)
    {
        int left=0;
        int right=0;
        byte second=0;
        StringBuffer stringBuffer=new StringBuffer();
        byte[] bytes=input.getBytes();
        for (int i = 0; i <bytes.length ; i++)
        {
                if(bytes[i]=='(') {
                        left++;
                        }
                if (left==1)
                {
                    second=bytes[i+1];
                }
                if (left==2)
                {
                    stringBuffer.append(bytes[i+1]).append(second);
                }
                if (left==3)
                {
                    stringBuffer.append(bytes[i-1]);
                }
                if(left==4)
                {
                    stringBuffer.append(bytes[i+1]).append(bytes[i-1]);
                    break;
                }


            if(bytes[i]==')')
            {
                right=right+1;
                if(right==1)
                {
                    stringBuffer.append(bytes[i-1]).append(bytes[0]);
                }
            }


        }
        String string=stringBuffer.toString();
        return string;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e)
        {
            _input = null;
        }
        res = solution(_input);
        System.out.println(res);
    }
}
