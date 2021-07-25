package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.List;

public class _0051_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        char[][] chs = new char[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                chs[i][j]='.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backTracking(chs,0,res);
        return res;
    }

    public void backTracking(char[][] chs, int row, List<List<String>> res){
        int n = chs[0].length;
        if (row == n){
            res.add(chsToList(chs));
            return;
        }

        for(int col=0;col<n;col++){
            if(isValid(chs,row,col)){
                chs[row][col] = 'Q';
                //递归
                backTracking(chs,row+1,res);
                //回溯
                chs[row][col]='.';
            }
        }
    }

    public List<String> chsToList(char[][] chs){
        List<String> list = new ArrayList<>();
        for(int i =0;i<chs.length;i++){
            list.add(new String(chs[i]));
        }
        return list;
    }

    //判断当前位置(x,y)能否放置queen，与之前的queen比较
    public boolean isValid(char[][] chs, int x, int y){
        for(int i = 0;i<x;i++){
            for(int j =0; j<chs.length;j++){
                if (chs[i][j]=='Q' && (j==y||Math.abs(x-i)==Math.abs(y-j))){
                    return false;
                }
            }
        }
        return true;
    }
}
