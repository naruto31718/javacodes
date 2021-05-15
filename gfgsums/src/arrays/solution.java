package arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class solution {
    static Scanner ip = new Scanner(System.in);

    static void sum(long[][] arr, long n, long m, long s, long[][] queries) {
        long t = queries[0].length;
        int q = 0;
        while (t-- > 0) {
            long ans = 0;
            long l = queries[q][0];
            long r = queries[q][1];
            for (int i = 0; i < n; i++) {
                long sum_row = 0;
                for (int j = 0; j < m; j++) {
                    sum_row += arr[i][j];
                }
                if (sum_row >= l && sum_row <= r) {
                    ans += 1;
                }
            }
            for (int i = 0; i < m; i++) {
                long sum_col = 0;
                for (int j = 0; j < n; j++) {
                    sum_col += arr[j][i];
                }
                if (sum_col >= l && sum_col <= r) {
                    ans += 1;
                }
            }
            System.out.println(ans);
            q++;
        }
    }

    static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    static String solve(int A) {
        BigInteger res = BigInteger.ONE;

        for (int i = A; i > 1; --i) {
            res = res.multiply(new BigInteger(String.valueOf(i)));
        }
        return String.valueOf(res);
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> arr) {
        int i, j = -1, k = -1, r = 0;
        long p = 0, q = Integer.MIN_VALUE;
        for (i = 0; i < arr.size(); ++i) {
            if (arr.get(i) >= 0) {
                p += arr.get(i);
                if (p == q) {
                    if (k - j < i - r) {
                        q = p;
                        j = r;
                        k = i;
                    }
                } else if (p > q) {
                    q = p;
                    j = r;
                    k = i;
                }
            } else {
                p = 0;
                r = i + 1;
            }
        }
        ArrayList nums = new ArrayList();
        if (j >= 0) {
            for (i = j; i <= k; ++i) {
                nums.add(arr.get(i));
            }
        }
        return nums;
    }

    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
//        for (int i=0;i<3;i++) {
//            A.add(i,new ArrayList<>());
//        }
//        for (int i=0;i<4;i++){
//        A.get(0).add(i,i+1);
//        }
//        for (int i=0;i<4;i++){
//            A.get(1).add(i,i+5);
//        }
//        for (int i=0;i<4;i++){
//            A.get(2).add(i,i+9);
//        }
//        ArrayList<ArrayList<Integer>> B = performOps(A);
//        for (int i = 0; i < B.size(); i++) {
//            for (int j = 0; j < B.get(i).size(); j++) {
//                System.out.print(B.get(i).get(j) + " ");
//            }
//        }
//        String ans = solve(100);
//        System.out.println(ans);
        ArrayList<Integer> A = new ArrayList<>();
        A.add(10);
        A.add(-1);
        A.add(2);
        A.add(3);
        A.add(-4);
        A.add(100);
        ArrayList<Integer> ans = maxset(A);
        System.out.println(ans);
    }
}
