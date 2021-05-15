package problemsolving.stack;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class Balenced_brackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        String ans = "YES";
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '{'||c=='['||c=='('){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return "NO";
                }
                char check = stack.pop();
                if (check=='{'&&c!='}'){
                    return "NO";
                }
                if (check=='['&&c!=']'){
                    return "NO";
                }
                if (check=='('&&c!=')'){
                    return "NO";
                }
            }
        }
        if (!stack.isEmpty()){
            return "NO";
        }
        return ans;
    }

}
