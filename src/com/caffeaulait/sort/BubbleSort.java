package com.caffeaulait.sort;

public class BubbleSort {

    public static void bubble_sort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; ++i){
            for (int j = 0; j < n - i - 1;++j){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
