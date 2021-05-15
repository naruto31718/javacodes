import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

abstract class Calculator {
    abstract int add(int a, int b);
}

class Adder extends Calculator {
    public Adder() {
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

public class sol1 {

    public static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    public static int heightChecker(int[] heights) {
        int ans = 0;
        int i = 0;
        while (i < heights.length) {
            int j = 0;
            while (j < heights.length) {
                if (heights[i] > heights[j]) {
                    swap(heights[i], heights[j]);
                    ans++;
                }
                j++;
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();

        combine(n, 1, k, 0, res, cur);
        return res;
    }

    public static void combine(int n, int start, int k, int size, List<List<Integer>> res, List<Integer> cur) {
        if (size == k) {
            res.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        if (start == n + 1) {
            cur.remove(cur.size() - 1);
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);

            combine(n, i + 1, k, size + 1, res, cur);

            if (i == n && cur.size() != 0) {
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean isBalenced(String s) {
        Deque<Character> stack
                = new ArrayDeque<Character>();


        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }


            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        return (stack.isEmpty());
    }
}
