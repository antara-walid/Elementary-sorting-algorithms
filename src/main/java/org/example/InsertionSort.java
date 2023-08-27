package org.example;

public class InsertionSort {
    public static void sort(Comparable[] arr)
    {
        for(int i = 0 ; i < arr.length ; i++)
        {

            for(int j = i ; j>0 ;j--)
            {
                if(less(arr[j] , arr[j-1]))
                    swap(arr,j,j-1);
                else
                    break;
            }

        }
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

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,9,4,2,6};

        InsertionSort.sort(arr);
        for (int nbr:arr) {
            System.out.print(nbr+" ");
        }
    }
}
