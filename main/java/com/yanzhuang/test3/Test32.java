package com.yanzhuang.test3;

import java.io.*;

/**
 * Welcome to vivo !
 */
public class Test32 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
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

    private static int solution(int[] input) {

        // TODO Write your code here
        int min= Integer.MAX_VALUE;
        int count=0;
        int len=input.length;
        for(int i=0;i<len;i++)
        {
            if(i==len-1)
            {
                if(count<min)
                {
                    min=count;
                    count=0;
                }
            }
            int len2=input[i];
            count++;
            i+=len2-1;

        }

        return count;
    }
}
