package com.yanzhuang.test_datastructure1;
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 递归求深度
     *
     * @param root
     * @return
     */
    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的深度
        int left = treeDepth(root.left);
        // 计算右子树的深度
        int right = treeDepth(root.right);
        // 树root的深度=路径最长的子树深度 + 1
        return left >= right ? (left + 1) : (right + 1);
    }

    public class Tree
    {

        public TreeNode createBinaryTree(int[][] descriptions)
        {
            return null;
            

        }
    }
}
