package com.yanzhuang.test4;

public class test49
{
    public int smallestArray(int n,int k)
    {
        int sum = 0;
        for (int i = 1; i <= n; i++)
        {
            sum+= i*k;
        }
        return sum;
    }
}
