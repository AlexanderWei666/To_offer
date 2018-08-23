package com.alexander;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test06 {
    public static void main(String[] args) {
        //牛客已经ac
    }

       /* public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //递归结束条件
        if(pre == null || in == null)
            return null;

        //根节点
        int root = pre[0];

        TreeNode treeNode = new TreeNode(root);

        //判定左子树长度
        int leftLength = 0;
        for (int i = 0; i < in.length; i++) {
            if(root == in[i])
                leftLength = i;
        }

        //确定右子树长度
        int rightLength = in.length - leftLength - 1;

        //定义子树序列
        int[] leftPre;
        int[] leftIn;
        int[] rightPre;
        int[] rightIn;

        //初始化子树序列
        if(leftLength > 0) {
            leftPre = new int[leftLength];
            leftIn = new int[leftLength];
        }
        else {
            leftPre = null;
            leftIn = null;
        }
        if(rightLength > 0) {
            rightPre = new int[rightLength];
            rightIn = new int[rightLength];
        }
        else {
            rightPre = null;
            rightIn = null;
        }

        //初始化左子树
        for (int i = 0; i < leftLength; i++) {
            leftPre[i] = pre[i + 1];
            leftIn[i] = in[i];
        }
        //初始化右子树
        for (int i = 0; i < rightLength; i++) {
            rightPre[i] = pre[i + 1 + leftLength];
            rightIn[i] = in[i + 1 + leftLength];
        }

        //递归左右子树
        treeNode.left = reConstructBinaryTree(leftPre, leftIn);
        treeNode.right = reConstructBinaryTree(rightPre, rightIn);

        return treeNode;
    }*/


    //牛客更优方法：看起来更简洁，但是算法复杂度不变
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //不构建新数组，使用原数组和指针来确定子树
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }

        return root;
    }

}
