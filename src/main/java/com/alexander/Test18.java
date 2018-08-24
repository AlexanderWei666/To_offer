package com.alexander;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class Test18 {
    public static void main(String[] args) {
        //牛客ac
    }

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if(root1 != null && root2 != null){
            //判断根节点
            if(root1.val == root2.val) {
                //匹配root1和root2
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result){
                //搜索root1左子树root2根节点
                result = hasSubtree(root1.left, root2);
            }
            if(!result){
                //搜索root1右子树root2根节点
                result = hasSubtree(root1.right, root2);
            }
        }

        return result;

    }

    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if(root2 == null)
            return true;

        if (root1 == null)
            return false;

        if(root1.val != root2.val)
            return false;

        //递归匹配左右子树
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }

}
