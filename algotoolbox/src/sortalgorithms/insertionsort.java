package sortalgorithms;

import java.util.Arrays;

public class insertionsort {
    static void sort(int[] arr){
        for (int i=1;i< arr.length;i++){
            int key = arr[i];
            int j = i-1;
            while (j>=0&&arr[j]>key){
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i=0;i< arr.length;i++){
            arr[i] = arr.length-i;
        }
        sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }
}
