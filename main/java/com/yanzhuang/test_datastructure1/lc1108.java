package com.yanzhuang.test_datastructure1;

import java.util.ArrayList;

public class lc1108
{
    public static String defangIPaddr(String address)
    {
        ArrayList<Integer> al=new ArrayList<>();
        String result="";
        String[] strs=address.split(".");
        for(int i=0;i<strs.length-1;i++)
        {
            result=result+strs[i]+"[.]";
        }
        //result=result+strs[strs.length-1];
        return result;
    }

    public static void main(String[] args) {
        String s="1.1.1.1";
        System.out.println(defangIPaddr(s));
    }
}
