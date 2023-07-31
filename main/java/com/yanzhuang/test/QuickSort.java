package com.yanzhuang.test;

import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.Queue;

public class QuickSort
{
    private static int quickOne(int[] data,int low,int high)
    {
        int key=data[low];
        while(low<high)
        {
            while(low<high&&data[high]>=key) high--;
            data[low]=data[high];
            while(low<high&&data[low]<key) low++;
            data[high]=data[low];
        }
        data[low]=key;
        return low;
    }
    public static void quickSort2(int data[],int left,int right)
    {
        if(data==null) return ;
        Queue<Integer> queue=new PriorityQueue();
        queue.add(left);
        queue.add(right);
        while(!queue.isEmpty())
        {
            int low=queue.poll();
            int high=queue.poll();
            int mid=quickOne(data,low,high);
            if(low<mid-1)
            {
                queue.add(low);
                queue.add(mid-1);
            }
            if(mid+1<high)
            {
                queue.add(mid+1);
                queue.add(high);
            }

        }
    }


}
