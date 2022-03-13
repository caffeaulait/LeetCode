package com.caffeaulait.sort;

import java.util.*;

import static com.caffeaulait.sort.BubbleSort.bubble_sort;
import static com.caffeaulait.sort.InsertionSort.insertion_sort;
import static com.caffeaulait.sort.MergeSort.mergeKArrays;
import static com.caffeaulait.sort.MergeSort.merge_sort;
import static com.caffeaulait.sort.QuickSort.quick_sort;

public class Sorting {


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

        System.out.println();

        int[] k1 = {1,3,5,7,9};
        int[] k2 = {2,4,6,8,10};
        int[] k3 = {11,12,13,14,15};

        List<Integer> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();
        List<Integer> list3= new ArrayList<>();

        for (int i = 0; i <k1.length;i++){
            list1.add(k1[i]);
            list2.add(k2[i]);
            list3.add(k3[i]);
        }

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);


        List<Integer> result = mergeKArrays(lists);

        for (int i : result){
            System.out.print(i+" ");
        }

    }

}
