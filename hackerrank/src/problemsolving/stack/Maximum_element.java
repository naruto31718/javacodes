package problemsolving.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Maximum_element {
    public static List<Integer> getMax(List<String> operations) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> max = new Stack<>();
        int element;

        for (int i = 0; i < operations.size(); i++) {
            String task = operations.get(i);
            String[] tasks = task.split(" ");
            switch (tasks[0]) {
                case "1":
                    element = Integer.parseInt(tasks[1]);
                    if (max.isEmpty() || max.peek() <= element) {
                        max.push(element);
                    }
                    break;
                case "2":
                    element = stack.pop();
                    if (element == max.peek())
                        max.pop();
                    break;
                case "3":
                    ans.add(max.peek());
                    break;
            }
        }
        return ans;
    }
}
