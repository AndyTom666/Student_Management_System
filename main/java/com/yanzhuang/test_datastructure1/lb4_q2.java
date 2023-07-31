package com.yanzhuang.test_datastructure1;

/*
import java.util.PriorityQueue;

public class lb4_q2
{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(8);
        pq.add(6);
        pq.add(4);
        pq.add(2);
        pq.add(12);
        pq.add(10);
        int[] ans=new int[4];
        for (int i = 0; i < 4; i++) {
            ans[i]=pq.poll();
        }
        for (int a:
             ans) {
            System.out.println(a);
        }
    }
}
*/

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author BianZheng
 * 2022/9/23 17:00
 */
public class lb4_q2 {
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                //a - b is min heap
                //b - a is max heap
                return b - a;
            }
        });

        int n_ele = arr.length;
        for (int i = 0; i < Math.min(k, n_ele); i++) {
            heap.add(arr[i]);
        }
        for (int i = k; i < n_ele; i++) {
            int tmp_max = heap.peek();
            if (tmp_max > arr[i]) {
                heap.poll();
                heap.add(arr[i]);
            }
        }

        return heap.peek();
    }

    public static void main(String[] arg) {
        int[] arr = {51, 22, 73, 82, 14, 67, 38, 19, 98, 25};
        int k = 4;
        int res = findKthLargest(arr, k);
        System.out.println(res);


    }
}
