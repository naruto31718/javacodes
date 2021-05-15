import java.util.*;
public class sol {
        public  static void  swap(int i,int j){
            int temp=i;
            i=j;
            j=temp;
        }

    public static List<Long> getRow(int rowIndex) {
        List<Long> prev = new ArrayList<>();
        prev.add(1L);
        for (int i = 1; i <= rowIndex; i++) {
            List<Long> curr = new ArrayList<>();
            for (int j = 0; j <= prev.size(); j++) {
                if (i==j || i==0 || j==0) {
                    curr.add(1L);
                } else {
                    long val = prev.get(j-1) + prev.get(j);
                    curr.add(val);
                }
            }
            prev = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        List<Long> ans = new ArrayList<>();
        ans = getRow(10);
        System.out.println(ans);
    }
}
