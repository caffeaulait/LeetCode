package com.caffeaulait.problemset;

import java.util.PriorityQueue;
import java.util.Queue;

public class _0378_KthSmallestElementInASortedMatrix {
    /**
     * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
     *
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     *
     * Example:
     *
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     *
     * return 13.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ n2.
     */

    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> queue = new PriorityQueue<>((a, b) -> (matrix[a.row][a.col]-matrix[b.row][b.col]));
        for (int i = 0; i < k && i < matrix.length; i++){
            queue.offer(new Node(i, 0));
        }
        int num = 0;
        for (int i = 0; i < k; i++) {
            Node node = queue.poll();
            num = matrix[node.row][node.col];
            node.col++;
            if (node.col < matrix[0].length) queue.offer(node);
        }
        return num;
    }

    class Node {
        int row;
        int col;

        public Node(int r, int c){
            row = r;
            col = c;
        }
    }
}
