package greedyalgorithms;

import java.util.Vector;

public class greedyalgo {
    public static long minrefills(long n, long l,long[] x){
        long numrefills=0;
        int currentrefill=0;
        while(currentrefill<=n){
            int lastrefill=currentrefill;
            while(currentrefill<=n&&x[currentrefill+1]-x[lastrefill]<=l){
                currentrefill=currentrefill+1;
            }
            if(currentrefill==lastrefill){
                return 0;
            }
            if(currentrefill<=n){
                numrefills=numrefills+1;
            }
        }
        return numrefills;
    }

    public static void main(String[] args) {
        long[] x={0,50,100,150,200};
        long k=minrefills(3,50,x);
        System.out.println(k);
    }
}
