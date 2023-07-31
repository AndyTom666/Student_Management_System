package com.yanzhuang.test2;

import java.util.ArrayList;
import java.util.Scanner;

public class Test25
{
    public static String getTime(int num,int[] array)
    {
        int time=1;
        int max=1;
        ArrayList<Integer> arrayList1=new ArrayList<>();
        ArrayList<Integer> arrayList2=new ArrayList<>();
        for(int i=0;i<num*2;i++)
        {
            if(i%2==0)
            {
                arrayList1.add(array[i]);
            }
            if(i%2==1)
            {
                arrayList2.add(array[i]);
            }
        }
        for(int j=0;j<num;j++)
        {
            time+=arrayList2.get(j);
        }
        for(int k=0;k<num;k++)
        {
            max+=arrayList2.get(k);
            /*if(arrayList2.get(k)+arrayList2.get(k+1)-k-1>max)
            {
                max=arrayList2.get(k)+arrayList2.get(k+1)-(k+1);
            }*/
        }
        max-=num;
        String s=time+" "+max;
        return s;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int[] array=new int[num*2];
        for(int i=0;i<num*2;i++)
        {
            array[i]=scanner.nextInt();
        }
        scanner.close();
        System.out.println(getTime(num,array));
    }
}
