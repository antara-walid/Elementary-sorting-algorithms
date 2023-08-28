package org.example;

public class ShellSort {
    public static void sort(Comparable[] arr)
    {
        int h = 1;
        while(h< arr.length/3)
            h = 3*h+1;
        while(h > 0)
        {
            for(int i = h ; i< arr.length ; i++)
            {
                for(int j = i ;j>h && less(arr[j],arr[j-h]) ;j -=h )
                {
                    swap(arr,j,j-h);
                }
            }
            h=h/3;
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

        ShellSort.sort(arr);
        for (int nbr:arr) {
            System.out.print(nbr+" ");
        }
    }
}
