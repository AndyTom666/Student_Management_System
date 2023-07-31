package com.yanzhuang.test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test8 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(int[] prices, int budget)
    {
        int max=0;
        int left=0;
        int index=0;
        double number=0.0;
        for (int i = 0; i <prices.length ; i++) {
            if(prices[i]>max)
            {
                max=prices[i];
                index=i;
            }

        }
        if(budget>max) {
             number= budget / max;
            if((number-(int)number)==0)return (int)number;
            else {
                left=budget-(int)number*max;
                prices[index]=0;
                for (int i = 0; i <prices.length ; i++) {
                    if(prices[i]>max)
                    {
                        max=prices[i];
                        index=i;
                    }

                }
                number+=left/max;
                return (int)number;
            }
        }
        return (int)number;


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
