package com.yanzhuang.test2;

import java.util.*;

public class Test22
{
    public static String getSet(String s)
    {
        StringBuilder stb=new StringBuilder();
        LinkedHashSet<Character> linkedHashSet=new LinkedHashSet<>();
        char[] chars=s.toCharArray();
        for (char charof:chars)
        {
            linkedHashSet.add(charof);
        }
        Iterator iterator=linkedHashSet.iterator();
        while(iterator.hasNext())
        {
            stb.append(iterator.next());
        }
        return stb.toString();
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine())
        {
            String s=scanner.nextLine();
            if(s.equals("exit"))
            {
                scanner.close();
                break;
            }
            System.out.println(getSet(s));

        }
    }
}
