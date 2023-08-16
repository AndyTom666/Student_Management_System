package com.yanzhuang.test5;

import java.util.Scanner;

public class mihayo_q3 {

    private static double[] tmp = new double[181];
    private static double p;

    public static void wai(double cur, int index) {
        for (int i = 1; i < 90; i++) {
            tmp[index + i] += cur * p;
            cur = cur * (1 - p);
        }
        tmp[index + 90] += cur;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        p = scanner.nextDouble();

        double cur = 1;
        for (int i = 1; i < 90; i++) {
            tmp[i] += cur * p / 2;
            wai(cur * p / 2, i);
            cur = cur * (1 - p);
        }
        tmp[90] += cur / 2;
        wai(cur / 2, 90);

        double result = 0;
        for (int i = 0; i < tmp.length; i++) {
            result += i * tmp[i];
        }
        System.out.println(result);
    }
}
/*
3 没触发大保底，p/2概率当期五星，p/2概率常驻五星，1-p概率不是五星

90次小保底，必中五星，一半概率是当期五星

触发小保底歪了后，p概率当期五星，1-p概率不是五星

180次必是当期五星

抽中当期五星的次数期望值是？
 */
