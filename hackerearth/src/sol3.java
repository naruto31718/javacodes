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

public class sol3 {
    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
         int ans = 0;
         return ans;
    }


    public static List<String> active_customer(List<String> customer,int n){
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> trade = new HashMap<>();
        Iterator<String> it = customer.iterator();
        for (String s:customer){
            if (!trade.containsKey(s)){
                trade.put(s,1);
            }else {
                trade.put(s,trade.get(s)+1);
            }
        }
        for (Map.Entry<String,Integer> entry : trade.entrySet()){
            if ((entry.getValue()*100)/n>=5){
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        List<String> cus = new ArrayList<>();
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("A");
        cus.add("O");
        cus.add("B");
        List<String> ans = active_customer(cus,20);
        System.out.println(ans);
    }
}
