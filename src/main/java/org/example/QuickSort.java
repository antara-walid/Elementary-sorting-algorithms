package org.example;

import java.util.*;

public class QuickSort {
    private static final int constant = 10;

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,9,4,2,6};

        QuickSort.sort(arr);
        for (int nbr:arr) {
            System.out.print(nbr+" ");
        }
    }

    public static void sort(Comparable[] arr)
    {
        // shuffle the array for better performance
        // to avoid the worst case (sorted array or reverse sorted array)
        shuffle(arr);
        sort(arr,0, arr.length -1);
    }

    private static void sort(Comparable[] arr , int start  ,int end)
    {
        if(start>=end)
            return;
        if(end-end+1 < constant)
            InsertionSort.sort(arr,start,end);
        int partitionIndex = partition(arr,start,end);
        sort(arr,start,partitionIndex-1);
        sort(arr,partitionIndex+1,end);
    }
    private static int partition(Comparable[] arr , int start, int end)
    {
        int i = start;
        int j = end+1;
        while(true)
        {
            while(less(arr[++i],arr[start])) // repeat until we find an element bigger than our partition
                if(i>=end) break;
            while(less(arr[start],arr[--j])) // repeat until we find an element smaller than our partition
                if(j<=start) break;

            if(j<=i)
                break;
            swap(arr,i,j);
        }
        swap(arr,j,start);
        return j;
    }

    private static boolean less(Comparable a,Comparable b )
    {
        if(a.compareTo(b) < 0)
            return true;

        return false;
    }

    private static void swap(Comparable[] arr , int i , int j)
    {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void shuffle(Comparable[] arr ){
        List<Comparable> temp = Arrays.asList(arr);
        Collections.shuffle(temp);
        arr = (Comparable[])temp.toArray(new Comparable[arr.length]);
    }
}
