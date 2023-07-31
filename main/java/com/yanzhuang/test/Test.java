package com.yanzhuang.test;

import java.lang.ref.WeakReference;

public class Test {
    public static void main(String[] args)
    {
        Outer out=new Outer();
        out.fun();
        Outer.Inner in0=new Outer.Inner();
        in0.print();
        out.fun();
        WeakReference<Outer> r=new WeakReference(new Outer());
        r.get().fun();
        //Outer.Inner in=out.new Inner();
        //in.print();

    }

}
