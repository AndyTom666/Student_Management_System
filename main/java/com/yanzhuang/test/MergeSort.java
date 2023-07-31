package com.yanzhuang.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSort
{
    public static void mergeOne(int[] data,int left,int mid,int right)
    {
        if(data==null) return ;
        if(data[mid]<=data[mid+1]) return ;
        for(int i=mid+1;i<=right;i++)
            for(int j=i;j>left;j--)
                if(data[j]<data[j-1])
                {
                    int t=data[j];
                    data[j]=data[j-1];
                    data[j-1]=t;
                }else
                {
                    left=j;
                    break;
                }
    }
    public static void mergeSort(int data[])
    {
        if(data==null) return ;
        Queue<Integer> queue=new PriorityQueue<Integer>();
        for(int i=0;i<data.length;i++)
        {
            queue.add(i);
            queue.add(i);
        }
        while(queue.size()>2)
        {
            int left1=queue.poll();
            int right1=queue.poll();
            int left2=queue.poll();
            int right2=queue.poll();
            if(right1!=left2-1)
            {
                queue.add(left1);
                queue.add(right1);
                left1=left2;
                right1=right2;
                left2=queue.poll();
                right2=queue.poll();
            }
            mergeOne(data,left1,right1,right2);
            queue.add(left1);
            queue.add(right2);
        }

    }



}
