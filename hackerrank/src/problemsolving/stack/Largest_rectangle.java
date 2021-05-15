package problemsolving.stack;
import java.util.*;
public class Largest_rectangle {
    public static long largestRectangle(List<Integer> h) {
          Long max = Long.MIN_VALUE;
          long area;
          int n = h.size();

          int j;
          Stack<Long> ans = new Stack<>();
          for (int i=0;i<h.size()-1;i++){
              int curr = h.get(i);
              int freq=1;
              j=i-1;
               while (j>=0){
                   if (h.get(j)>curr){
                       freq++;
                       j--;
                   }else {
                       break;
                   }
               }
               while (h.get(i+1)==curr&&i+1<n){
                   i++;
                   freq++;
               }
               j=i+1;
               while (h.get(j)>curr&&j<n){
                   j++;
                   freq++;
               }
             area = curr*freq;
             if(area>max){
                 max=area;
             }
          }
          return max;
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(8979);
        l.add(4570);
        l.add(6436);
        l.add(5083);
        l.add(7780);
        l.add(3269);
        l.add(5400);
        l.add(7579);
        l.add(2324);
        l.add(2116);
        long ans = largestRectangle(l);
        System.out.println(ans);
    }
}
