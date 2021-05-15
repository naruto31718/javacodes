import java.util.*;

public class fun {
    static final Scanner ip = new Scanner(System.in);
    public static void main(String[] args) {
        int n  = ip.nextInt();
        int m = ip.nextInt();
        int ans = Integer.MIN_VALUE;
        Deque<Integer> dq = new LinkedList<>();
        HashSet<Integer> track = new HashSet<>();
        for(int  i = 0;i<n;i++){
            int data = ip.nextInt();
            dq.add(data);
            track.add(data);

            if(dq.size()==m){
                if(track.size()>ans){
                    ans = track.size();
                }
                int fe = dq.remove();
                if(!dq.contains(fe)){
                    track.remove(fe);
                }
            }
        }
        System.out.println(ans);
    }
}
