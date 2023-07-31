package com.yanzhuang.test3;

import java.util.Iterator;
import java.util.List;

public class Test31
{
    public static int getMinimumMoves(List<Integer> arr)
    {
        // Write your code here
        int count=0;
        Iterator iterator=arr.iterator();
        int size=arr.size();
        for(int i=0;i<size-1;i++)
        {
            if(arr.get(i)>arr.get(i+1)) count++;
        }
        return count;

    }
}
