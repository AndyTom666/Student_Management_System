package com.yanzhuang.test2;

import java.util.Scanner;

public class Test14 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int count = 0;
        int ans = 0;
        while (in.hasNext()) {
            String word1 = in.next();
            String word2 = in.next();
            int len1 = word1.length();
            int len2 = word2.length();
            int len = Math.max(len1, len2);
            int len3 =Math.min(len1, len2);
            //System.out.println( word1.indexOf('l'));
            char[] c1 = word1.toCharArray();
            int[] arr = new int[c1.length];
            for(int i = 0; i < c1.length; i++)
                arr[i] = word2.indexOf(c1[i]);
            for(int i = 0; i < arr.length-1; i++)
            {
                if(arr[i] ==-1 || arr[i+1] ==-1)  continue;
                if(arr[i] < arr[i+1])
                    count++;
            }
            count++;
            ans=len-count;
            //ans = len + len3- 2*count;
            System.out.println(ans);
        }
        in.close();
    }
}

