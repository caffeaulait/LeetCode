package com.caffeaulait.problemset;

public class _0374_GuessNumberHigherOrLower {
    /**
     * We are playing the Guess Game. The game is as follows:
     *
     * I pick a number from 1 to n. You have to guess which number I picked.
     *
     * Every time you guess wrong, I'll tell you whether the number is higher or lower.
     *
     * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
     *
     * -1 : My number is lower
     *  1 : My number is higher
     *  0 : Congrats! You got it!
     */
    public int guess(int n){
        return 0;
    }

    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) i = mid + 1;
            else j = mid - 1;
        }
        return i;
    }
}
