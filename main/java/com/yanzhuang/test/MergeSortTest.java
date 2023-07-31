package com.yanzhuang.test;

public class MergeSortTest
{
    public static void main(String[] args)
    {
        int data[]={1,8,56,5,3,7,6,99,88,77,55,66,44};
        MergeSort mergeSort=new MergeSort();
        mergeSort.mergeSort(data);
        for (int da:data)
        {
            System.out.println(da);
        }
    }
}
