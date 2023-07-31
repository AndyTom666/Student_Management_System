package com.yanzhuang.test;

import java.util.HashMap;
import java.util.Scanner;

public class Test6
{
    public static int getfinalsum(Scanner sc)
    {
        HashMap<String,Integer> hm=new HashMap<>();
        String[] strs=new String[100];
        int i=0;
        int finalsum=0;
        while(sc.hasNextLine())
        {

            strs[i++]=sc.nextLine();
            if(sc.nextLine().equals("exit"))
            {
                sc.close();
                break;
            }
        }
        int lines=Integer.parseInt(strs[0]);
        for(int j=1;j<lines;j++)
        {
            StringBuffer stb=new StringBuffer();
            byte[] bytes=strs[j].getBytes();
            for(int z=0;z<bytes.length;z++)
            {
                if(bytes[z]!=' ') stb.append(bytes[z]);
            }
            String temp=stb.toString();
            String temparray[]=temp.split("=");
            int tempnum=0;
            if(hm.get(temparray[0])==null)
            {
                if(temparray[1]!=null) {
                    String[] temparray2 = temparray[1].split("\\+");

                    for (int k = 0; k < temparray2.length; k++) {
                        if (hm.get(temparray2[k]) == null) {
                            tempnum += Integer.parseInt(temparray2[k]);
                        } else {
                            tempnum += hm.get(temparray2[k]);
                        }

                    }
                    hm.put(temparray[0], tempnum);
                    tempnum = 0;
                }else {
                    tempnum += Integer.parseInt(temparray[1]);
                }
            }else
            {
                String[] temparray2=temparray[1].split("\\+");
                for(int k=0;k<temparray2.length;k++)
                {
                    if(hm.get(temparray2[k])==null)
                    {
                        tempnum+=Integer.parseInt(temparray2[k]);
                    }else
                    {
                        tempnum+=hm.get(temparray2[k]);
                    }

                }
                hm.put(temparray[0],tempnum);
                tempnum=0;
            }



        }
        String str1=strs[lines];
        StringBuffer stb2=new StringBuffer();
        byte[] bytes2=str1.getBytes();
        for(int z=0;z<bytes2.length;z++)
        {
            if(bytes2[z]!=' ') stb2.append(bytes2[z]);
        }
        String temp3=stb2.toString();
        String temparray3[]=temp3.split("=");
        String temparray4[]=temparray3[1].split("\\+");
        for(int q=0;q<temparray4.length;q++) {
            if (hm.get(temparray4[q]) == null)
            {
                finalsum+=Integer.parseInt(temparray4[q]);
            }else
            {
                finalsum+=hm.get(temparray4[q]);
            }
        }
        return finalsum;

    }
    public static void main(String args[])
    {
        System.out.println(getfinalsum(new Scanner(System.in)));
    }
}
