package com.yanzhuang.test_datastructure2;

public class lc283 {
    public static void moveZeroes(int[] nums)
    {
        int n=nums.length;
        if(n==0) return ;
        int slowpointer=0,fastpointer=0;
        for (int i = 0; i < n; i++)
        {
            if(nums[slowpointer]!=0&&slowpointer<n-1)
            {
                slowpointer++;
            }
            if(nums[fastpointer]==0&&fastpointer<n-1)
            {
                fastpointer++;
            }
            nums[slowpointer]=nums[fastpointer];
            if(fastpointer<n-1)
                fastpointer++;

        }

    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(nums);
    }
}
