package com.caffeaulait;

public class _0052_N_QueensII {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
     *
     *
     *
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     *
     * Example:
     *
     * Input: 4
     * Output: 2
     * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
     * [
     *  [".Q..",  // Solution 1
     *   "...Q",
     *   "Q...",
     *   "..Q."],
     *
     *  ["..Q.",  // Solution 2
     *   "Q...",
     *   "...Q",
     *   ".Q.."]
     * ]
     */
    int count = 0;

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        for (int i = 0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j] = false;
            }
        }
        backTrack(board,0);
        return count;
    }

    public void backTrack(boolean[][] board, int row){
        if (row == board.length) {
            count++;
            return;
        }
        for (int col = 0; col < board.length; col++){
            if (isValid(board,row,col)){
                board[row][col] = true;
                backTrack(board,row+1);
                board[row][col] = false;
            }
        }
    }

    public boolean isValid(boolean[][] board, int x, int y){
        for (int i = 0; i<x;i++){
            for (int j=0;j<board.length;j++){
                if (board[i][j] && (j==y || Math.abs(x-i)==Math.abs(y-j))){
                    return false;
                }
            }
        }
        return true;
    }
}
