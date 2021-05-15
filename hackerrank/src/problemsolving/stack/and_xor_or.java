package problemsolving.stack;

import java.util.List;
import java.util.Stack;

public class and_xor_or {
    public static int andXorOr(List<Integer> a) {
        Stack<Integer> s = new Stack<>();
        int max = 0, min;
        int[] v = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            v[i] = a.get(i);
        }
        for (int i = 0; i < v.length; i++) {
            while (!s.empty()) {
                min = v[i] ^ s.peek();
                if (min > max)
                    max = min;
                if (v[i] < s.peek())
                    s.pop();
                else {
                    break;
                }
            }
            s.push(v[i]);
        }
        return max;
    }
}

