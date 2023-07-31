package com.yanzhuang.test3;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Welcome to vivo !
 */

public class Test33
{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        String output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static String solution(int[] input) {

        // TODO Write your code here
        int len=input[0];
        int reg=input[1];
        LinkedList<Integer> linkedList=new LinkedList<>();
        Stack<Integer> tobeClean=new Stack<>();
        StringBuilder stb=new StringBuilder();
        for(int i=reg;i<=len;i++)
        {
            linkedList.add(i);
        }

        while(linkedList.size()!=0)
        {
            Iterator iterator=linkedList.listIterator();
            while(iterator.hasNext())
            {
                int count=0;
            int temp=(Integer)iterator.next();
            count++;
            if(temp%reg==0)
            {
                stb.append(temp);
                tobeClean.push(count);
            }
            }
            while (!tobeClean.isEmpty())
            {
                int count=0;
                int te=tobeClean.pop();
                count++;
                linkedList.remove(te-count);

            }
        }
        for(int i=reg-1;i>0;i--)
        {
            stb.append(i);
        }
        String result=stb.toString();
        return result;
    }

}
