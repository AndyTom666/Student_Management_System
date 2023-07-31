package com.yanzhuang.test2;

import java.util.Scanner;

public class Test15 {
    public static int calcu(int num)
    {
        int sum = 0;
        int count = 0;
        int left = 1, i = 1;
        while(i < num)
        {
            if(sum == num)
            {
                count++;
                sum -= left;
                left++;
                continue;
            }
            if(sum < num)
            {
                sum += i;
                i++;
                continue;
            }
            if(sum > num)
            {
                sum -= left;
                left++;
                continue;
            }
        }
        count++;
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt())
        {
            int num = in.nextInt();
            System.out.println(calcu(num));
        }
        in.close();
    }

}
