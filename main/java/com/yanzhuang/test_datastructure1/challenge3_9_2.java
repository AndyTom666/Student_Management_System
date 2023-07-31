package com.yanzhuang.test_datastructure1;
import java.util.Scanner;

public class challenge3_9_2
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        String flag="";
        for (int i = 1; i <=n ; i++)
        {
            int k=1+(i-1)*2;
            if(i%2!=0)
            {
                flag="*";
            }else
            {
                flag="$";
            }
            while(k>0)
            {
                System.out.print(flag);
                k--;
            }
            System.out.println("");
        }

    }
}
