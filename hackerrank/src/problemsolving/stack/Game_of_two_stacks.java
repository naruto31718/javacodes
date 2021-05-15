package problemsolving.stack;
import java.util.*;
public class Game_of_two_stacks {
    public static int twoStacks(int x, List<Integer> a_arr, List<Integer> b_arr) {
        int a_index=0;
        int b_index=0;
        int count=0;
        int sum=0;
        Integer[] a = new Integer[a_arr.size()];
        a = a_arr.toArray(a);
        Integer[] b = new Integer[b_arr.size()];
        b = b_arr.toArray(b);
        while (b_index < b.length && sum + b[b_index] <= x) {
            sum += b[b_index];
            b_index++;
        }
        // loop exits only when b_index reaches end or sum > x; in both case b_index should decrease
        b_index--;
        count = b_index + 1;

        while (a_index < a.length && b_index < b.length) {
            sum += a[a_index];
            if (sum > x) {
                while (b_index >= 0) {
                    sum -= b[b_index];
                    b_index--;
                    if (sum <= x) break;
                }
                // if even no elements taken from B, but still sum greater than x, then a[a_index] should not be chosen
                // and loop terminates
                if (sum > x && b_index < 0) {
                    a_index--;
                    break;
                }
            }
            count = Math.max(a_index + b_index + 2, count);
            a_index++;
        }

        return count;
    }
}
