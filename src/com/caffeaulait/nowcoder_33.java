package com.caffeaulait;

public class nowcoder_33 {
    /**
     *请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;
        return symmetricalTree(pRoot.left,pRoot.right);
    }

    boolean symmetricalTree(TreeNode tree1, TreeNode tree2){
        if (tree1 == null) return (tree2==null);
        if (tree2 == null) return false;
        return tree1.val == tree2.val && symmetricalTree(tree1.left,tree2.right) && symmetricalTree(tree1.right, tree2.left);
    }
}
