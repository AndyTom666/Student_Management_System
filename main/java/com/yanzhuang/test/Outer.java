package com.yanzhuang.test;

public class Outer {
    private static String str="wai";
    static class Inner{
        private String inStr="nei";
        static int nm=100;
        public static void sh()
        {
            System.out.println("nmsl");
        }
        public void print()
        {
            System.out.println(str);
        }
    }
    public void fun()
    {
        final int dashabi=100;
        class shabi
        {
            private double num;
            public void a()
            {
                System.out.println("nidaye");
                System.out.println(dashabi);
            }
        }
        Inner in=new Inner();
        in.print();
        Inner.sh();
        in.sh();
        shabi s=new shabi();
        s.a();
    }
}
