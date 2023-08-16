package com.yanzhuang.test5;

import java.text.NumberFormat;

public class test54 {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(4);
        nf.setMinimumFractionDigits(2);

        double numA = Double.parseDouble("3.1415926");
        double numB = Double.parseDouble("2");

        String formattedA = nf.format(numA);
        String formattedB = nf.format(numB);

        System.out.println(formattedA);
        System.out.println(formattedB);
    }
}
