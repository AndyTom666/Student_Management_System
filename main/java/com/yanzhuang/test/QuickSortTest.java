package com.yanzhuang.test;

public class QuickSortTest
{
    public static void main(String[] args)
    {
        int data[]={1,8,56,5,3,7,6,99,88,77,55,66};
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort2(data,0,data.length-1);
        for (int da:data)
        {
            System.out.println(da);
        }
    }


}
