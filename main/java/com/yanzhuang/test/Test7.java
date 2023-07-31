package com.yanzhuang.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Test7 {
    public static String checkjson(Scanner sc) {
        String[] strs = new String[100];
        int i = 0;
        double yinhao = 0;
        double huakuohao = 0;
        double zhongkuohao = 0;
        double douhao = 0;
        boolean a=false;
        boolean b=false;
        boolean c=false;
        boolean d=false;
        while (sc.hasNextLine()) {
            strs[i++] = sc.nextLine();
            if (sc.nextLine().equals("exit")) {
                sc.close();
                break;
            }
        }
        for (int j = 0; j < i; j++) {
            byte[] bytes = strs[j].getBytes();
            for (int z = 0; z < bytes.length; z++) {
                if (bytes[z] == '"') yinhao++;
                if (bytes[z] == '{') huakuohao++;
                if (bytes[z] == '[') zhongkuohao++;
                if (bytes[z] == ',') douhao++;
            }
        }
        if(yinhao/2-(int)(yinhao/2)!=0) {
            c=true;
        }
        if(huakuohao/2-(int)(huakuohao/2)!=0) {
            b=true;
        }
        if(zhongkuohao/2-(int)(zhongkuohao/2)!=0) {
            a=true;
        }
        if(douhao/2-(int)(douhao/2)!=0) {
            d=true;
        }
        if(a||b||c)
        {
            if(a&&!b&&!c)
            {
                return "1";
            }
            if(b&&!a&&!c)
            {
                return "2";
            }
            if(c&&!a&&!b)
            {
                return "3";
            }
            if(a&&b&&!c)
            {
                return "12";
            }
            if(a&&!b&&c)
            {
                return "13";
            }
            if(!a&&b&&c)
            {
                return "23";
            }
            if(a&&b&&c) return "123";
        }else
        {
            return "0";
        }
        return "0";
    }
    public static void main(String args[])
    {
        System.out.println(checkjson(new Scanner(System.in)));
    }
}
