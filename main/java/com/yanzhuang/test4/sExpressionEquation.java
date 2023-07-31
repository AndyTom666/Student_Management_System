package com.yanzhuang.test4;

import java.util.*;

public class sExpressionEquation
{
    public static int sExpression(String s)
    {
        s = s.substring(1, s.length() - 1);
        int index = s.indexOf(' ');
        char op = s.charAt(0);
        s = s.substring(index + 1);

        List<Integer> nums = new ArrayList<>();
        while (s.length() > 0)
        {
            if (s.charAt(0) == '(')
            {
                int count = 0;
                index = -1;
                for (int i = 0; i < s.length(); i++)
                {
                    if (s.charAt(i) == '(')
                    {
                        count++;
                    } else if (s.charAt(i) == ')')
                    {
                        count--;
                    }
                    if (count == 0)
                    {
                        index = i;
                        break;
                    }
                }
                String sub = s.substring(0, index + 1);
                nums.add(sExpression(sub));
                s = s.substring(index + 1).trim();
            } else
            {
                index = s.indexOf(' ');
                if (index == -1)
                {
                    nums.add(Integer.parseInt(s));
                    break;
                } else
                {
                    nums.add(Integer.parseInt(s.substring(0, index)));
                    s = s.substring(index + 1);
                }
            }
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++)
        {
            if (op == '+')
            {
                result += nums.get(i);
            } else if (op == '-')
            {
                result -= nums.get(i);
            } else if (op == '*')
            {
                result *= nums.get(i);
            }
        }
        return result;
    }


    public static void main(String[] args)
    {
        String s1 = "(* (- (* (+ 2 3) 5) 9 1) 2)";
        System.out.println(sExpression(s1));
        String s2 = "(+ (* (- 300 (- 90 12 3) 1 2 3) 12 2) 1)";
        System.out.println(sExpression(s2));
        String s3 = "(- 890 18 23 (* 1 2 3 (+ 1288 32)))";
        System.out.println(sExpression(s3));
    }
}
