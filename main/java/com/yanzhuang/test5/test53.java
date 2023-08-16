package com.yanzhuang.test5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class test53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int k = in.nextInt();
        Set<Integer> hs = new HashSet<>();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();

            if(!hs.contains(a))
            {
                hs.add(a);
                TreeNode ta = new TreeNode(a,null,null);
            }
        /*
            if(ta.left!=null)
            {
                ta.right = new TreeNode(b,null,null);
            }else
            {
                ta.left = new TreeNode(b,null,null);
            }

         */
        }
    }
}
class TreeNode
{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val,TreeNode left,TreeNode right)
    {
        this.val = val;
        this.left = left;
        this.right = right;

    }
}
