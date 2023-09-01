package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeWayQuickSort {


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,9,4,2,6};
        ThreeWayQuickSort.sort(arr);
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

    public static void sort(Comparable[] arr ,int start, int end)
    {
        if(start>=end)
            return;
        int i = start;
        int lt = start;
        int gt = end;
        Comparable partition = arr[start];

        while(i<=gt)
        {
            int temp= arr[i].compareTo(partition);
            if(temp<0)
                swap(arr,lt++,i++);
            else if(temp>0)
                swap(arr,i,gt--);
            else
                i++;
        }
        sort(arr,start,lt-1);
        sort(arr,gt+1,end);
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
