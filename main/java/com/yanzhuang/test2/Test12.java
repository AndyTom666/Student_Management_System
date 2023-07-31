package com.yanzhuang.test2;

import java.util.Scanner;

public class Test12 {
    public static int transmit(String word1, String word2)
    {
        int count = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == len2)
        {
            count = change(word1, word2);
            return count;
        }
        if(len1 < len2)
        {
            count = insert(word1, word2);
            return count;
        }
        if(len1 > len2)
        {
            count = delete(word1, word2);
            return count;
        }
        return count;
    }

    public static int change(String word1, String word2)
    {
        int count = 0;
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        for(int i = 0; i < c1.length; i++)
        {
            if(c1[i] == c2[i])
                continue;
            if(c1[i] != c2[i])
            {
                c1[i] = c2[i];
                count++;
            }
        }
        return count;
    }

    public static int insert(String word1, String word2)
    {
        int count = 0;
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        char[] c3 = new char[c2.length];
        int i = 0;
        for(; i < c1.length; i++)
        {
            if(c1[i] == c2[i])
            {
                c3[i] = c2[i];
                continue;
            }

            if(c1[i] != c2[i])
            {
                c3[i] = c2[i];
                count++;
            }
        }
        for(; i < c3.length; i++)
        {
            c3[i] = c2[i];
            count++;
        }
        return count;
    }

    public static int delete(String word1, String word2)
    {
        int count = 0;
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        char[] c3 = new char[c2.length];
        int i = 0;
        for(; i < c2.length; i++)
        {
            if(c1[i] == c2[i])
            {
                c3[i] = c2[i];
                continue;
            }
            if(c1[i] != c2[i])
            {
                c3[i] = c2[i];
                count++;
            }
        }
        for(; i < c1.length; i++)
        {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String word1 = in.next();
            String word2 = in.next();
            System.out.println(transmit(word1, word2));
        }
        in.close();
    }

}

