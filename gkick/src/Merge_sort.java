import java.util.Arrays;


public class Merge_sort {

    public static void mergeSort_bottomup(int[] nums) {
        if (nums == null) {
            return;
        }

        if (nums.length > 1) {
            int mid = nums.length / 2;

            // Split left part
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = nums[i];
            }

            // Split right part
            int[] right = new int[nums.length - mid];
            for (int i = mid; i < nums.length; i++) {
                right[i - mid] = nums[i];
            }
            mergeSort_bottomup(left);
            mergeSort_bottomup(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right numss
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    nums[k] = left[i];
                    i++;
                } else {
                    nums[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while (i < left.length) {
                nums[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                nums[k] = right[j];
                j++;
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = a.length - i;
        }
        mergeSort_bottomup(a);
        System.out.println(Arrays.toString(a));
    }

    public int[] merge_sorttopdown(int[] input) {
        if (input.length <= 1) {
            return input;
        }
        int pivot = input.length / 2;
        int[] left_list = merge_sorttopdown(Arrays.copyOfRange(input, 0, pivot));
        int[] right_list = merge_sorttopdown(Arrays.copyOfRange(input, pivot, input.length));
        return merge(left_list, right_list);
    }

    public int[] merge(int[] left_list, int[] right_list) {
        int[] ret = new int[left_list.length + right_list.length];
        int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

        while (left_cursor < left_list.length &&
                right_cursor < right_list.length) {
            if (left_list[left_cursor] < right_list[right_cursor]) {
                ret[ret_cursor++] = left_list[left_cursor++];
            } else {
                ret[ret_cursor++] = right_list[right_cursor++];
            }
        }
        // append what is remain the above lists
        while (left_cursor < left_list.length) {
            ret[ret_cursor++] = left_list[left_cursor++];
        }
        while (right_cursor < right_list.length) {
            ret[ret_cursor++] = right_list[right_cursor++];
        }
        return ret;
    }
}

