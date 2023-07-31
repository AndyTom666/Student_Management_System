package com.yanzhuang.test3;
class TreeNode
{
    int value;
    TreeNode left,right;
    public TreeNode(int value)
    {
        this.value=value;
    }
}
public class Test26
{

    public static int getLongest(TreeNode root)
    {
        int count=0;
        TreeNode left0=root,right0=root;
        while (left0.left!=null)
        {
            left0=left0.left;
            count++;
        }
        while (right0.right!=null)
        {
            right0=right0.right;
            count++;
        }
        return count;
    }
    public static void main(String[] args)
    {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        System.out.println(getLongest(treeNode1));
    }
}
