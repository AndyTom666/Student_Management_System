package com.yanzhuang.test2;

import java.util.*;

public class Test24
{
    public static int findMax(int num,int[] array)
    {
        int maxsum=0;
        LinkedList<Integer> linkedList=new LinkedList<>();
        for (int arraynumber: array)
        {
            linkedList.add(arraynumber);
        }
        int i=0;
        while (!linkedList.isEmpty()) {
            if (i == 0) {
                i=1;
                if (linkedList.getFirst() >= linkedList.getLast()) {
                    maxsum += linkedList.removeFirst();
                    if (!linkedList.isEmpty()) {
                        linkedList.removeLast();
                    }

                } else {
                    maxsum += linkedList.removeLast();
                    if (!linkedList.isEmpty()) {
                        linkedList.removeFirst();
                    }
                }
            } else {

                if (linkedList.getFirst() <= linkedList.getLast()) {
                    maxsum += linkedList.removeFirst();
                    if (!linkedList.isEmpty()) {
                        linkedList.removeLast();
                    }

                } else {
                    maxsum += linkedList.removeLast();
                    if (!linkedList.isEmpty()) {
                        linkedList.removeFirst();
                    }
                }
            }
        }
        return maxsum;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[] array=new int[num];
        for(int i=0;i<num;i++)
        {
            array[i]=scanner.nextInt();
        }
        scanner.close();
        System.out.println(findMax(num,array));
    }
}
