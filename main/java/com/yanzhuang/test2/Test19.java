package com.yanzhuang.test2;

import java.util.Scanner;

public class Test19
{
    public static String yasuo(String s)
    {
        int count=0;
        char[] chars=s.toCharArray();
        char temp;
        StringBuffer stb=new StringBuffer();
        int j=1;
        int i=0;
        for (;i<chars.length;i++) {
            if (j <chars.length ) {
                if (chars[i] == chars[j++]) {
                    count++;
                } else {
                    if (count == 0)
                    {
                        stb.append(chars[i]);
                        //j++;
                    } /*else if (j==chars.length-1)
                    {
                        stb.append(chars[j]);
                    }*/
                    else
                    {
                        stb.append(count+1).append(chars[i]);
                        count = 0;
                    }

                }
            }
        }
        if(count!=0)
        {
            stb.append(count+1).append(chars[chars.length-1]);
        }else
        {
            stb.append(chars[chars.length-1]);
        }
        return stb.toString();

    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine())
        {
            String s=scanner.nextLine();
            System.out.println(yasuo(s));
        }
    }
}
