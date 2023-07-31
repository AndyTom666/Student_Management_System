package com.yanzhuang.test;

public class Test10
{

    public static String calc(String A,int DA,String B,int DB)
    {
        byte[] bytesofA=A.getBytes();
        byte[] bytesofB=B.getBytes();
        StringBuffer sta=new StringBuffer();
        StringBuffer stb=new StringBuffer();
        int countA=0;
        int countB=0;
        DA+='0';  //DA+=48;
        DB+='0';
        for (byte byteA:bytesofA)
        {
            if((int)byteA==DA) countA++;
        }
        for (byte byteB:bytesofB)
        {
            if((int)byteB==DB) countB++;
        }
        DA-=48;
        DB-=48;
        for(int i=0;i<countA;i++)
        {
            sta.append(DA);
        }
        for(int i=0;i<countB;i++)
        {
            stb.append(DB);
        }
        System.out.println(countA);
        System.out.println(countB);
        String stringa=sta.toString();
        String stringb=stb.toString();
        int sum=Integer.parseInt(stringa)+Integer.parseInt(stringb);
        String result=sum+"";
        return result;
    }
    public static void main(String[] args)
    {
        String A="51065664";
        int DA=6;
        String B="989876646";
        int DB=9;
        System.out.println(calc(A,DA,B,DB));
    }

}
