package com.yanzhuang.test_datastructure1;

public class Sort
{
    public static void selectSort3(int[] data)
    {
        if(data==null) return ;
        for(int i=0;i<data.length;i++)
        {
            int min=i;
            for(int j=i+1;j<data.length;j++)
            {
                if(data[j]<data[min])
                {
                    min=j;
                }
            }
            if(min!=i)
            {
                int temp=data[i];
                data[i]=data[min];
                data[min]=temp;

            }

        }
    }
    public static void heapSort(int data[])
    {
        if(data==null) return ;
        //  int n=data.length;
        for(int n=data.length;n>1;n--)
        {
            for(int i=n/2;i>=1;i--)
            {
                if(2*i+1<=n&&data[i-1]<data[2*i])
                {
                    int t=data[i-1];
                    data[i-1]=data[2*i];
                    data[2*i]=t;
                }
                if(data[i-1]<data[2*i-1])
                {
                    int t=data[i-1];
                    data[i-1]=data[2*i-1];
                    data[2*i-1]=t;
                }
            }
            int t=data[0];
            data[0]=data[n-1];
            data[n-1]=t;
        }

    }
    public static void heapSort2(int data[])
    {
        if(data==null) return;
        int len=data.length;
        for(int i=len;i>1;i--)
        {
            for(int j=i/2;j>=1;j--)
            {
                if(2*j+1<=i&&data[j-1]<data[2*j])
                {
                    int temp=data[j-1];
                    data[j-1]=data[2*j];
                    data[2*j]=temp;
                }
                if(data[j-1]<data[2*j-1])
                {
                    int temp=data[j-1];
                    data[j-1]=data[2*j-1];
                    data[2*j-1]=temp;
                }

            }
            int temp=data[i-1];
            data[i-1]=data[0];
            data[0]=temp;
        }
    }

    public static void main(String[] args)
    {
        int [] ints={50,9,78,66,44,33,255,643,24,5,6};
        heapSort2(ints);
        for (int i:ints) {
            System.out.print(i+" ");

        }

    }
}
