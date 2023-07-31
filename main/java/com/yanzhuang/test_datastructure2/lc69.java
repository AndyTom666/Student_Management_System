package com.yanzhuang.test_datastructure2;

public class lc69
{
    public static int mySqrt(int x)
    {
        int left=0,right=x,mid=-1,ans=-1;
        while(left<=right)
        {
            mid = left+ ((right-left)>>1);
            long product=(long)mid*mid;
            if((long)mid*mid>x)
            {
                right=mid-1;
            }else
            {
                ans=mid;
                left = mid+1;
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

}
