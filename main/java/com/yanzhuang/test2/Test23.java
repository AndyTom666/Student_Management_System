package com.yanzhuang.test2;

import java.util.*;

public class Test23
{

    public static int findNum(int num,int[] array,int symbol)
    {


        /*TreeSet<Integer> sortedSet=new TreeSet<Integer>();
        int count=0;
        int i=0;
        for(;i<num-2;i++)
        {
            if(array[i]+array[i+1]+array[i+2]<symbol)
            {
                count++;
            }else
            {
                break;
            }
        }
        for(;i>=0;i--)
        {
            for(int j=i+1;j<num-2;j++)
            {
                if(array[i]+array[j]+array[j+1]<symbol)
                {
                    count++;
                    if(array[i]+array[j]+array[j+2]<symbol) count++;
                }else
                {
                    continue;
                }
            }
        }
        return count;
        for(int arraynumber:array)
        {
            sortedSet.add(arraynumber);
        }
        Iterator iterator=sortedSet.iterator();
        while (iterator.hasNext())
        {

        }*/
        ArrayList<Integer> arrayList=new ArrayList<>();
        Arrays.sort(array);
        int count=0;
        int i=0;
        for(;i<num-2;i++)
        {
            for(int j=i+1;j<num-1;j++)
            {
                for(int k=j+1;k<num;k++)
                {
                    if(array[i]+array[j]+array[k]<symbol) count++;
                }
            }
        }
        return count;
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
        int symbol=scanner.nextInt();
        scanner.close();
        System.out.println(findNum(num,array,symbol));
    }
}
