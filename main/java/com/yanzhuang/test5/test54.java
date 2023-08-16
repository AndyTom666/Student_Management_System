package com.yanzhuang.test5;

import java.text.NumberFormat;

public class test54 {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(4);
        nf.setMinimumFractionDigits(2);
        String a = "3.1415926";
        String b = "2";
        nf.format(a);
        nf.format(b);
        System.out.println(a);
        System.out.println(b);

    }
}
