import java.util.*;

public class sol2 {
    public static int unhappiness_sum(int[] C,int n){
       boolean[] time = new boolean[C.length+2];
       int min_value = 0;
        Arrays.fill(time,true);
        for (int i=0;i<C.length;i++){
              if (time[C[i]]){
                  time[C[i]]=false;
              }else {
                  int j = C[i];
                  int k=1;
                  while(true){
                      if (j-k>=1&&time[j-k]){
                          time[j-k]=false;
                           min_value+=Math.abs(j-(j-k));
                           break;
                      }else if (j+k<=C.length&&time[j+k]){
                          time[j+k] = false;
                          min_value+=Math.abs(j-(j+k));
                          break;
                      }
                      k++;
                  }
              }
        }
        return min_value;
//            Arrays.sort(coeff);
//
//            int time = 0;
//            //int min =0;
//            int uh =0;
//            for(int i=0;i<n;i++){
//                time ++;
//
//                //min++;
//                uh += Math.abs(coeff[i]-time);
//
//            }
//            return uh;
        }

    public static int sum_max(int[] arr,int n){
        Arrays.sort(arr);
        int modulus_value = 1000000007;
        int main_ans = 0;
        int k=1;
        for(int i=0;i<n;i++){
            int sub_ans=0;
            for(int j=i;j<n;j++){
                sub_ans+=arr[j]*k;
            }
            main_ans+= sub_ans;
            k++;
        }
        return main_ans%modulus_value;
    }
    public static void main(String[] args) {
      int[] a = new int[10000000];
      for(int i=0;i<a.length;i++){
          a[i]=a.length-i;
      }
      int ans = unhappiness_sum(a,a.length);
        System.out.println(ans);
    }
}
