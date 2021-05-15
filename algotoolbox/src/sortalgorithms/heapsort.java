package sortalgorithms;

import java.util.Arrays;

public class heapsort {


    static void heapify(long[] arr,int n,int i){
        int largest = i;
        int l_child = 2*i;
        int r_child = (2*i)+1;

        if(l_child<n&&arr[l_child]<arr[largest]){
            largest = l_child;
        }
        if (r_child<n&&arr[r_child]<arr[largest]){
            largest = r_child;
        }

        if (largest!=i){
            long swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr,n,largest);
        }
    }

    static void sort(long[]arr){
        for (int i= arr.length/2 -1;i>=0;i--){
            heapify(arr, arr.length, i);
        }

        for (int i= arr.length-1;i>0;i--){
            long temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);
        }
    }

    public static void main(String[] args) {
        long[] arr = new long[1000];
        for (int i=0;i< arr.length;i++){
            arr[i] = i+1;
        }
        sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }
}
