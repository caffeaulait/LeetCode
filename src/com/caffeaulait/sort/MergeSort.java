package com.caffeaulait.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSort {

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
        int[] L = new int[mid];
        System.arraycopy(A, 0, L, 0, mid);
        int[] R = new int[n-mid];
        if (n - mid >= 0) System.arraycopy(A, mid, R, 0, n - mid);
        merge_sort(L);
        merge_sort(R);
        merge(A,L,R);
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2){
        int n1 = list1.size();
        int n2 = list2.size();
        List<Integer> result = new ArrayList<>();
        int i =0, j=0;
        while (i<n1 && j<n2){
            if (list1.get(i)<list2.get(j)) {
                result.add(list1.get(i));
                i++;
            }else {
                result.add(list2.get(j));
                j++;
            }
        }
        while (i<n1){
            result.add(list1.get(i++));
        }
        while (j<n2){
            result.add(list2.get(j++));
        }
        return result;
    }

    public static List<Integer> mergeKArrays(List<List<Integer>> lists){
        if (lists.size()==0 || lists.get(0).size()==0)
            return new ArrayList<>();

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(o -> o.get(0)));

        for (List<Integer> list : lists){
            queue.offer(list);
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            List<Integer> minList = queue.poll();
            result.add(minList.remove(0));
            if (minList.size()!=0)
                queue.offer(minList);
        }

        return result;
    }
}
