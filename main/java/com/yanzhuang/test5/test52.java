package com.yanzhuang.test5;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class test52 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int x3 = in.nextInt();
            int y3 = in.nextInt();
            test52 t = new test52();
            System.out.println(t.sol(n,m,x1,y1,x2,y2,x3,y3));
        }
    }
    public int sol(int n,int m,int x1,int y1,int x2,int y2,int x3,int y3)
    {
        int route1 = 0, route2 = 0;
        if(x1==1||x1==n||y1==1||y1==m)
        {
            if(x2==1||x2==n||y2==1||y2==m)
            {
                if(x1==x2||y1==y2)
                {
                    route1 =1;
                }else
                {
                    route1=Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
                }

            }
            else
            {
                route1 = Math.abs(x2-x1)+Math.abs(y2-y1);
            }
        }
        if(x2==1||x2==n||y2==1||y2==m)
        {
            if(x3==1||x3==n||y3==1||y3==m)
            {
                if(x2==x3||y2==y3)
                {
                    route2 =1;
                }else
                {
                    route2=Math.max(Math.abs(x3-x2),Math.abs(y3-y2));
                }

            }
            else
            {
                route2 = Math.abs(x3-x2)+Math.abs(y3-y2);
            }
        }
        return route1+route2;

    }
}
