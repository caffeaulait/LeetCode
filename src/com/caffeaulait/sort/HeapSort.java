package com.caffeaulait.sort;

public class HeapSort {

    //https://blog.csdn.net/weixin_56223966/article/details/126439780

    public static void heapSort(int[] arr) {
        initHeap(arr);
        for (int i = arr.length-1; i >=0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public static void initHeap(int[] arr) {
        //the index of the parent node of last node.
        int start = ((arr.length - 1) - 1) / 2;
        for (int i = start; i >=0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    public static void heapify(int[] arr, int len, int k) {
        if (k >= len) return;
        int root = k;
        int l = 2*k + 1;
        int r = 2*k + 2;
        if (l < len && arr[root] < arr[l]) {
            root = l;
        }
        if (r < len && arr[root] < arr[r]) {
            root = r;
        }
        if (root != k) {
            swap(arr, root, k);
            heapify(arr, len, root);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
