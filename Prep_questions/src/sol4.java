import java.util.*;

public class sol4 {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i=0;i<n;i++){
            arr.add(i,new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
        int lastAns = 0;
        for (int i=0;i<queries.size();i++){
            List<Integer> query = queries.get(i);
            if (query.get(0)==1){
                int index = (query.get(1)^lastAns)%n;
                arr.get(index).add(query.get(2));
            }else {
                int adding = (query.get(1)^lastAns)%n;
                List<Integer> l = arr.get(adding);
                lastAns = l.get(query.get(2)%l.size());
                ans.add(lastAns);
            }
        }
        return ans;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
           List<Integer> ans = new ArrayList<>();
           int rotating_point;
           if (d>arr.size()){
               rotating_point = d% arr.size();
           }else {
               rotating_point = d;
           }
           int stop = rotating_point;
           int i=0;
           while (rotating_point<arr.size()){
               ans.add(i,arr.get(rotating_point));
               i++;
               rotating_point++;
           }
           rotating_point = 0;
           while (rotating_point<stop){
               ans.add(i,arr.get(rotating_point));
               i++;
               rotating_point++;
           }
           return ans;
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
       List<Integer> ans = new ArrayList<>();
       for(int i=0;i<queries.size();i++){
           String query = queries.get(i);
           int subans = 0;
           for (int j=0;j<strings.size();j++){
               String s = strings.get(j);
               if (s.equals(query)){
                   subans++;
               }
           }
           ans.add(subans);
       }
       return ans;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
            Map<Integer,Integer> map = new HashMap<>();
            for(List<Integer> query : queries){
                int start = query.get(0);
                int end = query.get(1);
                int value = query.get(2);
                map.put(start, (map.containsKey(start) ? map.get(start) : 0) + value);
                map.put(end + 1, (map.containsKey(end + 1) ? map.get(end + 1) : 0) - value);
            }

        int max = 0;
        int value = 0;
        for (long i = 0; i <n; i++) {
            value += (map.containsKey(i + 1) ? map.get(i + 1) : 0);
            max = Math.max(max, value);
        }
         return max;
    }

    public static void main(String[] args) {
int[] a = {1,2,3,4,5};
List<Integer> arr = new ArrayList<>();
for (int i:a){
    arr.add(i);
}
        System.out.println(rotateLeft(10,arr));
    }
}
