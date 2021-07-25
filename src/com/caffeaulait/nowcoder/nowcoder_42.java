package com.caffeaulait.nowcoder;

public class    nowcoder_42 {
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean [][] visited = new boolean[rows][cols];
        return countSteps(threshold,rows,cols,0,0, visited);
    }

    public int countSteps(int threshold, int rows, int cols, int r, int c, boolean[][] visited){
        if (r<0||r>=rows||c<0||c>=cols||visited[r][c]||sumOfNum(r)+sumOfNum(c)>threshold)
            return 0;
        visited[r][c] = true;
        return  1
                + countSteps(threshold,rows,cols,r,c-1,visited)
                + countSteps(threshold,rows,cols,r,c+1,visited)
                + countSteps(threshold,rows,cols,r-1,c,visited)
                + countSteps(threshold,rows,cols,r+1,c,visited);
    }

    public int sumOfNum(int t){
        int count = 0;
        while (t!=0){
            count+=t%10;
            t/=10;
        }
        return count;
    }
}
