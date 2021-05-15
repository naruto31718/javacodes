package sortalgorithms;

import java.util.Arrays;

public class quicksort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr,int low,int high){
        int pivot = arr[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            if (arr[j] < pivot)
            {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr,int low,int high){
        if (low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i=0;i< arr.length;i++){
            arr[i] = arr.length-i;
        }
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }

}
