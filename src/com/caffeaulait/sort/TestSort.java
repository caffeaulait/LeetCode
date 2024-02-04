package com.caffeaulait.sort;

import java.util.*;

import static com.caffeaulait.sort.BubbleSort.bubbleSort;
import static com.caffeaulait.sort.HeapSort.heapSort;
import static com.caffeaulait.sort.InsertionSort.insertionSort;
import static com.caffeaulait.sort.MergeSort.mergeSort;
import static com.caffeaulait.sort.QuickSort.quickSort;

public class TestSort {


    public static void main(String[] args) {
	// write your code here
        int[] arr1 = {3,6,7,1,2,9,5,10,4,8};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        int[] arr3 = Arrays.copyOf(arr1, arr1.length);
        int[] arr4 = Arrays.copyOf(arr1, arr1.length);
        int[] arr5 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("bubble sort: ");
        bubbleSort(arr1);
        for (int i : arr1){
            System.out.print(i+" ");
        }

        System.out.println("\nquick sort: ");
        quickSort(arr2,0,9);
        for (int i : arr2){
            System.out.print(i+" ");
        }

        System.out.println("\nmerge sort: ");
        mergeSort(arr3);
        for (int i : arr3) {
            System.out.print(i + " ");
        }

        System.out.println("\ninsertion sort: ");
        insertionSort(arr4);
        for(int i : arr4){
            System.out.print(i+" ");
        }

        System.out.println("\nheap sort: ");
        heapSort(arr5);
        for(int i : arr5){
            System.out.print(i+" ");
        }

    }

}
