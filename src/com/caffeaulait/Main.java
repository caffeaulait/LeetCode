package com.caffeaulait;

import java.util.*;

public class Main {


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

//    public static int partition(int[] arr, int left, int right){
//
//    }

    public static void insertion_sort(int[] arr){
        int n = arr.length;
        for(int i = 1;i < n;i++){
            int temp = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void merge(int[] A, int[] L, int[] R){
        int leftCount = L.length;
        int rightCount = R.length;
        int i, j, k;
        i = j = k = 0;
        while (i<leftCount && j< rightCount){
            if (L[i] < R[j])
                A[k++] = L[i++];
            else
                A[k++] = R[j++];
        }
        while (i < leftCount)
            A[k++] = L[i++];
        while (j < rightCount)
            A[k++] = R[j++];
    }

    public static void merge_sort(int[] A){
        int n = A.length;
        if (n < 2) return;
        int mid = n/2;
        int L[] = new int[mid];
        for (int i = 0; i < mid ; i++){
            L[i] = A[i];
        }
        int R[] = new int[n-mid];
        for (int j = mid; j < n; j++){
            R[j-mid] = A[j];
        }
        merge_sort(L);
        merge_sort(R);
        merge(A,L,R);
    }

    public static int partition(int[] arr, int left, int right){
        int i = left + 1;
        int j = right;
        int pivot = arr[left];
        while (i <= j){
            while (i <= right && arr[i] < pivot){
                i++;
            }
            while (j <= right && arr[j] > pivot){
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

    public static void quick_sort(int arr[], int left, int right){
        if (left > right) return;
//        System.out.println(left+" & "+right);
        int p = partition(arr,left,right);
        quick_sort(arr,left,p-1);
        quick_sort(arr,p+1,right);
    }

    public static void main(String[] args) {
	// write your code here
        int[] arr1 = {3,6,7,1,2,9,5,10,4,8};
        int[] arr2 = {3,6,7,1,2,9,5,10,4,8};
        int[] arr3 = {3,6,7,1,2,9,5,10,4,8};
        int[] arr4 = {3,6,7,1,2,9,5,10,4,8};
        System.out.println("Bubble sort: ");
        bubble_sort(arr1);
        for (int i : arr1){
            System.out.print(i+" ");
        }

        System.out.println("\nquick sort: ");
        quick_sort(arr2,0,9);
        for (int i : arr2){
            System.out.print(i+" ");
        }

        System.out.println("\nmerge sort: ");
        merge_sort(arr3);
        for (int i : arr3) {
            System.out.print(i + " ");
        }

        System.out.println("\ninsertion sort: ");
        insertion_sort(arr4);
        for(int i : arr4){
            System.out.print(i+" ");
        }

    }
}
