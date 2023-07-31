package com.yanzhuang.test_datastructure2;

public class lc844
{
    public static boolean backspaceCompare(String s, String t)
    {
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        s = cleanString(cs);
        t = cleanString(ct);
        System.out.println(s);
        System.out.println(t);
        if(s.equals(t))
        {
            return true;
        }else
        {
            return false;
        }

    }
    public static String cleanString(char[] c)
    {
        int slow=0,quick=c.length-1;
        StringBuffer sb=new StringBuffer();
        while(slow<=quick)
        {
            if(c[quick]!='#')
            {
                quick--;
            }
            else if(c[slow]!='#')
            {
                slow++;
                continue;
            }
            else
            {
                c[quick]=c[--slow]=0;
                if(slow>0)
                {
                    slow--;
                }
            }




        }
        for (int i = 0; i < c.length; i++)
        {
            if(c[i]!='#'&&c[i]!='0')
            {
                sb.append(c[i]);
            }


        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s="ab##";
        String t="c#d#";
        System.out.println(backspaceCompare(s,t));

    }
}

