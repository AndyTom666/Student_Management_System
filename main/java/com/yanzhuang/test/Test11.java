package com.yanzhuang.test;
import java.util.Scanner;

public class Test11
{

    public static int getShortestChange(String[] string)
    {
        int alength=0;
        int blength=0;
        alength=string[0].length();
        blength=string[1].length();
        char[] charsofA=string[0].toCharArray();
        char[] charsofB=string[1].toCharArray();
        //byte[] bytesofA=string[0].getBytes();
        //byte[] bytesofB=string[1].getBytes();
        int [][]vertex=new int[blength+1][alength+1];

        for(int j=0;j<=alength;j++)
        {
            vertex[0][j]=j;
        }
        for(int j=0;j<=alength;j++)
        {
            vertex[j][0]=j;
        }
        int x=1;
        int y=1;
        int cost;
        char temp1,temp2;
        for(;y<=alength;y++)
        {
            temp1=charsofA[y-1];
            for(;x<=blength;x++)
            {
                temp2=charsofB[x-1];
                if(temp1==temp2)
                {
                    cost=0;
                }
                else
                 {
                    cost=1;
                }
                vertex[y][x]=Math.min(Math.min(vertex[y-1][x-1]+cost,vertex[y-1][x]+1),vertex[y][x-1]+1);
            }
        }
        /*for(int k=0;k<alength*blength;k++)
        {
            if(bytesofA[x-1]==bytesofB[y-1])
            {
                int min=Integer.MAX_VALUE;
                int min1=vertex[y-1][x-1];
                int min2=vertex[y-1][x]+1;
                int min3=vertex[y][x-1]+1;
                vertex[y][x]=getMin(min,min1,min2,min3);
                if(x<alength)
                {
                    x++;
                }
                else
                    {
                    if(y<blength)
                    {
                        y++;
                    }
                        x = 1;

                }

            }else
            {
                int min=Integer.MAX_VALUE;
                int min1=vertex[y-1][x-1]+1;
                int min2=vertex[y-1][x]+1;
                int min3=vertex[y][x-1]+1;
                vertex[y][x]=getMin(min,min1,min2,min3);
                if(x<alength)
                {
                    x++;
                }
                else {
                    if(y<blength){
                        y++;
                    }
                        x = 1;

                }

            }
        }*/
        return vertex[blength][alength];
    }
    public static int getMin(int min,int min1,int min2,int min3)
    {
        if(min1<min)
        {
            min=min1;
            if(min2<min)
            {
                min=min2;
            }
            if(min3<min)
            {
                min=min3;
            }
        }
        return min;
    }
    public static void main(String[] args)
    {
        int i=0;
        Scanner sc = new Scanner(System.in);
        String[] string=new String[2];
        while(sc.hasNextLine()&&i<2)
        {
            string[i++]=sc.nextLine();
            if(i==2)
            {
                sc.close();
                break;
            }
        }

        System.out.println(getShortestChange(string));
        }

}
