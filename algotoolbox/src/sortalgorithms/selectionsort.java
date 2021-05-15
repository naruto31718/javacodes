package sortalgorithms;

import java.util.Arrays;

public class selectionsort {
    static void sort(int[] arr){
        for(int i=0;i<arr.length;i++) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[50];
        for (int i=0;i< arr.length;i++){
            arr[i] = arr.length-i;
        }
        sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }
}
