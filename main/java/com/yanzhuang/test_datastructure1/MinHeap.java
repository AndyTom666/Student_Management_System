package com.yanzhuang.test_datastructure1;

import java.util.*;

/**
 * @author BianZheng
 * 2022/9/23 12:31
 */
public class MinHeap {

    public static void main(String args[]) {
        //declare a PriorityQueue object with default ordering
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //add element to the PriorityQueue
        pq.add(8);
        pq.add(6);
        pq.add(4);
        pq.add(2);
        pq.add(12);
        pq.add(10);
        //display the min PriorityQueue
        System.out.println("The min Priority Queue (natural ordering) contents:");
        Integer val = null;
        while ((val = pq.poll()) != null) {
            System.out.print(val + " ");
        }
    }
}