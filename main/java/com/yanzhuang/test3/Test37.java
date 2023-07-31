package com.yanzhuang.test3;

import java.util.Scanner;

public class Test37 {

    public static int getDiffer(int m)
    {
        return m*(m-1)-1;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println(getDiffer(scanner.nextInt()));
        scanner.close();
    }

}
