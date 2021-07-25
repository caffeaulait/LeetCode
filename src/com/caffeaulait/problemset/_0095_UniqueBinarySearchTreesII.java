package com.caffeaulait.problemset;

import com.caffeaulait.miscellaneous.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0095_UniqueBinarySearchTreesII {
    /**
     * #95
     * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
     *
     * Example:
     *
     * Input: 3
     * Output:
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * Explanation:
     * The above output corresponds to the 5 unique BST's shown below:
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     */

    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<TreeNode>();
        return generate(1,n);
    }

    public List<TreeNode> generate(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start > end)
            result.add(null);

        for (int i = start; i <= end; ++i){
            List<TreeNode> leftTrees = generate(start, i-1);
            List<TreeNode> rightTrees = generate(i+1, end);

            for (int j = 0; j<leftTrees.size();j++){
                for (int k = 0; k< rightTrees.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
