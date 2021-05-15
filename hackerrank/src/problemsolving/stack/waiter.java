package problemsolving.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class waiter {
    public static List<Integer> primeNums(int q) {
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int num = 2;
        while (count != q) { // while count!= number of prime numbers entered keep searching..
            boolean prime = true;// to determine whether the number is prime or not
            for (int i = 2; i <= Math.sqrt(num); i++) { //efficiency matters
                if (num % i == 0) {
                    prime = false; // if number divides any other number its not a prime so set prime to false and break the loop.
                    break;
                }

            }
            if (prime) {
                count++;
                ans.add(num);
            }
            num++; //see if next number is prime or not.
        }
        return ans;
    }

    //solution in F:cprogramming folder

}
