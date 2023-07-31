package com.yanzhuang.test5;

import java.util.*;
class test50 {
    public long sol(long n, int m,long k,long[][] ranges)
    {
        long max = 0;
        for (int i = 0; i < m; i++)
        {
            long range = ranges[i][1] - ranges[i][0];
            if(k<range)
            {
                max = k;
                break;
            }else
            {
                if(range>max)
                {
                    max = range;
                }
            }
        }
        return max;
    }
}
class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        long n,k;
        int m;
        while(cin.hasNextLong())
        {
            n = cin.nextLong();
            m = (int)cin.nextLong();
            k = cin.nextLong();
            long[][] ranges = new long[m][2];
            for (int i = 0; i < m; i++)
            {
                ranges[i][0] = cin.nextLong();
                ranges[i][1] = cin.nextLong();
            }
            test50 s = new test50();
            long c = s.sol(n,m,k,ranges);
            System.out.println(c);
        }
    }
}
