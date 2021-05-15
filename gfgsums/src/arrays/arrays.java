package arrays;

import java.util.*;

public class arrays {
    public static ArrayList<Integer> duplicates(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!(freq.containsKey(arr[i]))) {
                freq.put(arr[i], 1);
            } else {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            }
        }
        for (int i : freq.keySet()) {
            if (freq.get(i) > 1) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            ans.add(-1);
        }
        Collections.sort(ans);
        return ans;
    }

    public static long largest(long[] arr, long n) {
          /*Arrays.sort(arr);
          return arr[arr.length-1];*/
        long cuurmax = arr[0];
        for (int i = 0; i < n; i++) {
            cuurmax = Math.max(cuurmax, arr[i]);
        }
        return cuurmax;
    }

    public static int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int smallest = arr[0] + k, largest = arr[n - 1] - k;
        for (int i = 0; i < n - 1; i++) {
            int min = Math.min(smallest, arr[i + 1] - k);
            int max = Math.max(largest, arr[i] + k);
            if (min < 0)
                continue;
            ans = Math.min(ans, max - min);
        }
        return ans;
    }

    public static ArrayList<Integer> findMean(int[] arr, int[] queries, int n, int q) {
        ArrayList<Integer> ans = new ArrayList<>();
        int k = 0;
        while (q-- > 0) {
            int l = queries[k];
            int r = queries[k + 1];
            int sum = 0;
            int count = 0;
            for (int i = l; i <= r; i++) {
                sum += arr[i];
                count++;
            }
            int mean = sum / count;
            ans.add(mean);
            k += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {2,6,3,4,7,2,10,3,2,1};
//        System.out.println(getMinDiff(arr,4,2));
//        int[] arr = {1, 2, 3, 2, 3};
//        int[] q = {0, 1, 1, 2, 1, 2};
//        ArrayList<Integer> ans = new ArrayList<>();
//        ans = findMean(arr, q, arr.length, 3);
//        System.out.println(ans);

    }

    public static void factors(long n, ArrayList<Integer> a) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                a.add(i);
                n = n / i;
                i--;
            }
        }
    }

    public static long countDivisorsMult(long[] arr, long n) {
//        long x = 1;
//        long count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            x *= arr[i];
//        }
//        for (int i = 1; i <= x; i++) {
//            if (x % i == 0) {
//                count++;
//            }
//        }
//        return count;
//         long x = 1;
//        long ans = 1;
//        Map<Long,Integer> prime_factors = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            x *= arr[i];
//        }
//        for (long i = 2; i < x; i++) {
//            while (x % i == 0) {
//                if (!prime_factors.containsKey(i)) {
//                    prime_factors.put(i, 1);
//                } else {
//                    prime_factors.put(i, prime_factors.get(i) + 1);
//                }
//                x /= i;
//            }
//        }
//        if (x > 2) {
//            if (!prime_factors.containsKey(x)) {
//                prime_factors.put(x, 1);
//            } else {
//                prime_factors.put(x, prime_factors.get(x) + 1);
//            }
//        }
//        for (Map.Entry<Long,Integer> set : prime_factors.entrySet()) {
//            ans *= (set.getValue() + 1);
//        }
//        return ans;
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            factors(arr[i], a);
        }
        Collections.sort(a);
        long ans = 1;
        int k = 1;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) == a.get(i - 1)) {
                k++;
            } else {
                ans = ans * (long) (k + 1);
                k = 1;
            }
        }
        ans = ans * (long) (k + 1);
        return ans;
    }

    static long maxSum(long[] arr, int n) {
        Arrays.sort(arr);
        long ans = 0;

        for (int i = 0; i < (n / 2); i++) {

            ans -= (2 * arr[i]);
            ans += (2 * arr[n - i - 1]);
        }
        return ans;
    }

    static public void pendulumArrangement(int[] a, int n) {
//        int[] ans = new int[arr.length];
//        Arrays.sort(arr);
//        int k;
//        if (arr.length % 2 == 0) {
//            k = (arr.length - 1) / 2;
//        } else {
//            k = arr.length / 2;
//        }
//        ans[k] = arr[0];
//        int j = 1, l = 1;
//        for (int i = 1; i < arr.length; i += 2) {
//            ans[k + j] = arr[i];
//            j++;
//        }
//        for (int i = 2; i < arr.length; i += 2) {
//            ans[k - l] = arr[i];
//            l++;
//        }
//        sout(ans);
        Arrays.sort(a);
        StringBuffer sb = new StringBuffer();
        if (n % 2 != 0) {
            for (int i = n - 1; i >= 0; i -= 2) {
                sb.append(a[i] + " ");
            }
            for (int i = 1; i < n - 1; i += 2) {
                sb.append(a[i] + " ");
            }
        } else {
            for (int i = n - 2; i >= 0; i -= 2) {
                sb.append(a[i] + " ");
            }
            for (int i = 1; i < n; i += 2) {
                sb.append(a[i] + " ");
            }
        }
        System.out.println(sb);
    }

    static long uneatenLeaves(long[] arr, int n, int c) {
        long count = 0;
        for (int j = 1; j < n + 1; j++) {
            int k = 0;
            while (k < c) {
                if (j % arr[k] == 0) {
                    break;
                } else k++;
            }
            if (k == c) count++;
        }
        return count;
    }

    public static ArrayList<Integer> inversePermutation(int[] arr, int n) {
        Integer[] ans = new Integer[n];
        for (int i = 0; i < n; i++) {
            ans[arr[i] - 1] = Integer.parseInt(String.valueOf(i + 1));
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(ans[i]);
        }
        return a;
    }

    public static int chocolates(int[] arr, int n) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    public static ArrayList<Integer> array(int[][] a, int[] b, int n) {
        int diag_sum = 0, max;
        for (int i = 0; i < n; i++) {
            diag_sum += a[i][i];
        }
        Arrays.sort(b);
        max = b[b.length - 1];
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(diag_sum);
        ans.add(max);
        return ans;
    }

    public static long[] countMultiples(long[] arr, long[] Q, long N, long M) {
//        Given an array of positive integers and many queries for divisibility.
//        In every query Q[i], we are given an integer K ,
//        we need to count all elements in the array which are perfectly divisible by K.
//        long[] ans = new long[Q.length]; // O(M*N)
//        int t = 0;
//        while (t<M){
//            long k = Q[t];
//            long count=0;
//           for (int i=0;i<N;i++){
//               if (A[i]%k==0){
//                   count+=1;
//               }
//           }
//           ans[t] = count;
//           t++;
//        }
//        return ans;
        long[] ans = new long[Q.length]; // O(M log(M))
        Map<Long, Long> map = new HashMap<>();
        long max = 0;
        for (int i = 0; i < N; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], (long) 1);
            max = Math.max(max, arr[i]);
        }
        int t = 0;
        for (int i = 0; i < M; i++) {
            long div = Q[i];
            if (div == 0) continue; //corner case
            long count = 0;
            for (int j = 1; j <= max / div; j++) {
                if (map.containsKey(j * div))
                    count = count + map.get(j * div);
            }
            ans[t] = count;
            t++;
        }
        return ans;
    }

    public static void update(int[] a, int n, int[] updates, int k) {

    }

    public static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
