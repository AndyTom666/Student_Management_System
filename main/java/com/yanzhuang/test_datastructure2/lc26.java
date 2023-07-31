package com.yanzhuang.test_datastructure2;

import java.util.HashSet;
import java.util.Iterator;

class lc26 {
    public int removeDuplicates(int[] nums)
    {
        HashSet<Integer> hs=new HashSet<>();
        int count=0;
        int slowpointer,fastpointer=0;
        for (int i = 0; i < nums.length; i++)
        {
            hs.add(nums[i]);
        }
        Iterator it=hs.iterator();
        while(it.hasNext())
        {
            nums[count++]= (int) it.next();
        }
        return count;

    }

    public static void main(String[] args)
    {

    }
}
