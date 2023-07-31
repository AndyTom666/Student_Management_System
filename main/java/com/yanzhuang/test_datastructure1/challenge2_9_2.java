package com.yanzhuang.test_datastructure1;
import java.util.*;
public class challenge2_9_2
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 1; i <=n ; i++)
        {
          int k=1+(i-1)*2;
          while(k>0)
          {
              System.out.print("*");
              k--;
          }
            System.out.println("");
        }

    }
}
