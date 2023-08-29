package org.example;

public class MergeSort {

    public static void sort(Comparable[] arr)
    {
        Comparable temp[] = new Comparable[arr.length];
        sort(arr,temp,0, arr.length-1);
    }
    private static void sort(Comparable[] arr ,Comparable[] temp , int start , int end)
    {
        if(start>=end)
            return;
        int mid = start + (end -start)/2;
        sort(arr,temp,start,mid); // sort first half
        sort(arr,temp,mid+1,end); // sort second half
        merge(arr,temp,start,mid,end); // merge sorted halves
    }
    private static void merge(Comparable[] arr ,Comparable[] temp , int start ,int mid, int end)
    {
        for(int i = start ; i<=end ; i++)
            temp[i] = arr[i]; // copy elements to temp array

        int i = start;
        int j = mid+1;

        for(int k = start ; k <=end ; k++)
        {
            if(i>mid)
            {
                arr[k] = temp[j];
                j++;
            }
            else if(j>end)
            {
                arr[k] = temp[i];
                i++;
            }
            else if(less(temp[i],temp[j]))
            {
                arr[k] = temp[i];
                i++;
            }else {
                arr[k] = temp[j];
                j++;
            }

        }

    }
    private static boolean less(Comparable a,Comparable b )
    {
        if(a.compareTo(b) < 0)
            return true;

        return false;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,9,4,2,6};

        MergeSort.sort(arr);
        for (int nbr:arr) {
            System.out.print(nbr+" ");
        }
    }
}