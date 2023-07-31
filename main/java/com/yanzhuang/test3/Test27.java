package com.yanzhuang.test3;

import java.util.ArrayList;
class Cache
{
    int value;
    int count;
    int index;
    public Cache()
    {
        this.value=0;
        this.count=0;
        this.index=0;
    }
}
class LFUCache
{
    Cache[] ints;
    int[] indexs;
    int currentindex;
    int min;
    int changeindex;
    public LFUCache(int number)
    {
        this.currentindex=0;
        this.min=Integer.MAX_VALUE;
        this.changeindex=0;
        ints=new Cache[number];
        for(int i=0;i<number;i++)
        {
            ints[i]=new Cache();
        }
        this.indexs=new int[number];
    }
    public void set(int index0,int value)
    {
        int fresh=value;
        if(ints[ints.length-1].value==0)
        {
            //System.out.println(ints.length);

            indexs[currentindex]=index0;
            //System.out.println(indexs[currentindex]);
            ints[currentindex].index=index0;
            ints[currentindex].count++;
            ints[currentindex].value=value;
            if(currentindex<ints.length-1)
            {
                currentindex++;
            }

        }else
        {
            for(int i=0;i<ints.length;i++)
            {
                if(ints[i].count<min)
                {
                    changeindex=i;
                }
            }
            indexs[changeindex]=index0;
            ints[changeindex].index=index0;
            ints[changeindex].value=value;
            ints[changeindex].count=1;

        }
    }
    public void get(int index)
    {
        int now=-1;
        for(int i=0;i<indexs.length;i++)
        {
            if(index==indexs[i])
            {
                now=index;
                break;
            }
        }
        if(now==-1)
        {
            System.out.println(now);
        }
        else
        {
            for(int i=0;i<ints.length;i++)
            {
                if(index==ints[i].index)
                {
                    ints[i].count++;
                    System.out.println(ints[i].value);
                    break;
                }
            }
        }
    }
}
public class Test27
{

    public static void main(String[] args)
    {
        LFUCache lfuCache=new LFUCache(3);
        lfuCache.set(2,2);
        lfuCache.set(1,1);
        lfuCache.get(2);
        lfuCache.get(1);
        lfuCache.get(2);
        lfuCache.set(3,3);
        lfuCache.set(4,4);
        lfuCache.get(3);
        lfuCache.get(2);
        lfuCache.get(1);
        lfuCache.get(4);


    }
}
