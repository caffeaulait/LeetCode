package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class _0257_BinaryTreePaths {
    /**
     * Given a binary tree, return all root-to-leaf paths.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Input:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * Output: ["1->2->5", "1->3"]
     *
     * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root==null) return result;
        dfs(result, "", root);
        return result;
    }

    public void dfs(List<String> result, String path, TreeNode root){
        if (root.left == null && root.right == null){
            path += root.val;
            result.add(path);
            return;
        }
        if (root.left!=null) dfs(result, path + (root.val +"->"), root.left);
        if (root.right!=null) dfs(result, path + (root.val +"->"), root.right);
    }
}
