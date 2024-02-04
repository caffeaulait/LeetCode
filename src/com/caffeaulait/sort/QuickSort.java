package com.caffeaulait.sort;

public class QuickSort {

    public static int partition(int[] arr, int left, int right){
        int i = left + 1;
        int j = right;
        int pivot = arr[left];
        while (i <= j){
            while (i <= right && arr[i] < pivot){
                i++;
            }
            while (j >= left && arr[j] > pivot){
                j--;
            }
            //if not crossed, exchange
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        int temp = arr[j];
        arr[j] = arr[left];
        arr[left] = temp;
        return j;
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left > right) return;
        int p = partition(arr,left,right);
        quickSort(arr,left,p-1);
        quickSort(arr,p+1,right);
    }
}
