package com.yanzhuang.test;

import java.util.Scanner;

public class Test3 {
    public static int getTime(String a, String b) {
        int count = 0;
        int al = a.length();
        int bl = b.length();
        for (int i = 0; i <al - bl-3; i++) {
            if (a.substring(i, i + al).equals(b)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            String b = in.nextLine();
            System.out.println(getTime(a, b));
        }
    }
}
