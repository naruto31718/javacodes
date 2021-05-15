import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class sol {
    public static boolean is_permutation(int[] arr, int n) {
        Set<Integer> hash = new HashSet<Integer>();

        int maxEle = 0;

        for (int i = 0; i < n; i++) {


            hash.add(arr[i]);


            maxEle = Math.max(maxEle, arr[i]);
        }

        if (maxEle != n)
            return false;


        return hash.size() == n;
    }

    public static int change(int[] a, int n) {
        int ans = 0;
        if (is_permutation(a, n)) {
            return 0;
        }
        HashMap<Integer,
                Integer> count = new HashMap<Integer,
                Integer>();
        for (int i = 0; i < n; i++) {
            if (count.containsKey(a[i])) {
                count.put(a[i], count.get(a[i]) + 1);
            } else {
                count.put(a[i], 1);
            }
        }
        int next_missing = 1;
        for (int i = 0; i < n; i++) {
            if (count.containsKey(a[i]) &&
                    count.get(a[i]) != 1 ||
                    a[i] > n || a[i] < 1) {
                count.put(a[i], count.get(a[i]) - 1);


                while (count.containsKey(next_missing)) {
                    next_missing++;
                }

                if (next_missing > a[i]) {
                    a[i] = next_missing;
                    count.put(next_missing, 1);
                    ans++;
                }
            }
        }
        if (is_permutation(a, n)) {
            return ans;
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] a = {2, 3, 2, 1, 3};
        int ans = change(a, 5);
        System.out.println(ans);
    }
}
