package com.yanzhuang.test;

public class CountDice
{
    public static void main(String args[])
    {
        CountDice.count();

    }

    public static void count(){
        double [][] dice=new double[100][600];
        dice[1][1]=0.167;
        dice[1][2]=0.167;
        dice[1][3]=0.167;
        dice[1][4]=0.167;
        dice[1][5]=0.167;
        dice[1][6]=0.167;
        //for(i)
        for(int i=2;i<=3;i++)
        {
            for(int j=i;j<=6*i;j++)
            {
                if (j==i)
                    dice[i][j]= dice[i-1][j-1]*(0.167);
                else if (j==i+1)
                    dice[i][j]= (dice[i-1][j-2]+dice[i-1][j-1])*(0.167);
                else if (j==i+2)
                    dice[i][j]=(dice[i-1][j-3]+dice[i-1][j-1]+dice[i-1][j-1])*(0.167);
                else if (j==i+3)
                    dice[i][j]=(dice[i-1][j-4]+dice[i-1][j-3]+dice[i-1][j-2]+dice[i-1][j-1])*(0.167);
                else if (j==i+4)
                    dice[i][j]=(dice[i-1][j-5]+dice[i-1][j-4]+dice[i-1][j-3]+dice[i-1][j-2]+dice[i-1][j-1])*(0.167);
                else if(j>=i+5)
                    dice[i][j]=(dice[i-1][j-6]+dice[i-1][j-5]+dice[i-1][j-4]+dice[i-1][j-3]+dice[i-1][j-2]+dice[i-1][j-1])*(0.167);
                }
        }
        for(int i=1; i<=3;i++)
        {
            for(int j=i;j<=6*i;j++)
            {
                System.out.print(dice[i][j]+" ");
            }
            System.out.println();
        }
       // System.out.println(dice[2][2]);
    }

}
