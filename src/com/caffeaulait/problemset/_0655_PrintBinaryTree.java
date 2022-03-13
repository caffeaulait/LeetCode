package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0655_PrintBinaryTree {
    /**
     * Print a binary tree in an m*n 2D string array following these rules:
     *
     * The row number m should be equal to the height of the given binary tree.
     * The column number n should always be an odd number.
     * The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
     * Each unused space should contain an empty string "".
     * Print the subtrees following the same rules.
     *
     * Input:
     *       1
     *      / \
     *     2   5
     *    /
     *   3
     *  /
     * 4
     * Output:
     *
     * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
     *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
     *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
     *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
     */

    public List<List<String>> printTree(TreeNode root) {
        List<List<String >> result = new ArrayList<>();

        if (root == null) return result;
        int rows = getHeight(root);
        int cols = (int)Math.pow(2, rows) - 1;

        for (int i = 0; i < rows; i++){
            List<String> l = new ArrayList<>();
            for (int j = 0; j < cols; j++) l.add("");
            result.add(l);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Pair<Integer>> indices = new LinkedList<>();
        queue.offer(root);
        indices.offer(new Pair<>(0, cols-1));

        int size;
        int row = -1;

        while (!queue.isEmpty()){
            row++;
            size = queue.size();
            for (int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                Pair<Integer> pair = indices.poll();
                if (node == null) {
                    continue;
                }else{
                    int left = pair.first;
                    int right = pair.second;
                    int mid = left + (right-left)/2;
                    result.get(row).set(mid, String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                    indices.offer(new Pair<>(left, mid - 1));
                    indices.offer(new Pair<>(mid+1, right));
                }
            }
        }
        return result;
    }

    private int getHeight(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    class Pair<T>{
        private T first;
        private T second;

        public Pair(T first, T second){
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }
    }
}
