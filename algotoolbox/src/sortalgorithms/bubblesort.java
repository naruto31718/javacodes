package sortalgorithms;

import java.util.Arrays;

public class bubblesort {
    static void sort(int[] arr){
        for (int i=0;i< arr.length;i++){
            for (int j=0;j< arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
    static void countSwaps(int[] a) {
    	int count  = 0;
    	int n = a.length;
    	for (int i = 0; i < n; i++) {
    	    
    	    for (int j = 0; j < n - 1; j++) {
    	        // Swap adjacent elements if they are in decreasing order
    	        if (a[j] > a[j + 1]) {
    	            swap(a,j,j + 1);
    	            count++;
    	        }
    	    }
    	    
    	}
    	System.out.println("Array is sorted in "+count+" swaps.");
    	System.out.println("First Element: "+a[0]);
    	System.out.println("Last Element: "+a[n-1]);
    }
    public static void main(String[] args) {
//        int[] arr = new int[100];
//        for (int i=0;i< arr.length;i++){
//            arr[i] = arr.length-i;
//        }
//        sort(arr);
//        Arrays.stream(arr).forEach(i -> System.out.println(i));
    	int[] a = {3,2,1};
    	countSwaps(a);
    }

}
