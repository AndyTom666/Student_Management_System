package com.yanzhuang.test;

public class Solution
{
    public String getMinVersion(String[] list) {
        // 在这里编写代码
        double min=Integer.MAX_VALUE;
        int sum=0;

        for (String str:list
                ) {
            int major=0;
            int minor=0;
            int patch=0;
            int ext=0;
            if(!str.contains(".")) {
                sum=Integer.parseInt(str)*1000;
            }
            else
            {
            String sts[] = str.split("\\.");
            //System.out.println(sts[0]);
            for(int i=0;i<sts.length;i++)
            {

                if(i==0) major=Integer.parseInt(sts[i])*1000;
                if(i==1) minor=Integer.parseInt(sts[i])*100;
                if(i==2) patch=Integer.parseInt(sts[i])*10;
                if(i==3) ext=Integer.parseInt(sts[i])*1;
            }
            sum=major+minor+patch+ext;
           // System.out.println(sum);

            }
            if(sum<min) min=sum;
        }
        String result0=min+"";
        System.out.println(result0);
        String result="";
        for(int j=0;j<result0.length()-2;j++)
        {
            result+=result0.substring(j,j+1)+".";
        }
        result=result.substring(0,7);
        return result;
    }
    public static void main(String args[])
    {
        String[] list={"3","4.3.5.4","2.10.3" , "2.4"};
        Solution solution=new Solution();
        System.out.println(solution.getMinVersion(list));
    }

}
