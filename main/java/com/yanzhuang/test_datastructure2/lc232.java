package com.yanzhuang.test_datastructure2;

import java.util.Stack;

class MyQueue {
    Stack<Integer> result;
    public MyQueue() {
        result=new Stack<Integer>();
    }

    public void push(int x) {
        result.push(x);

    }

    public int pop() {
        Stack<Integer> tmp=new Stack<>();
        while(!result.isEmpty())
        {
            tmp.push(result.pop());
        }
        result=tmp;
        int r=result.pop();
        return r;

    }

    public int peek() {
        Stack<Integer> tmp=new Stack<>();
        while(!result.isEmpty())
        {
            tmp.push(result.pop());
        }
        result=tmp;
        int r=result.peek();
        return r;

    }

    public boolean empty() {
        if(result.isEmpty())
        {
            return true;
        }else
        {
            return false;
        }

    }
}
public class lc232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
