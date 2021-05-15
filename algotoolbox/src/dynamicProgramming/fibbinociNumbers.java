package dynamicProgramming;

import java.util.*;

public class fibbinociNumbers {
	static Scanner ip = new Scanner(System.in);
	static HashMap<Integer,Long> cache = new HashMap<>(); // for memorisation of repating results
	
	static long fibbinociOfaNumber(int n) {
		if( n == 0 ) return 0;
        if( n == 1 ) return 1;
		if(cache.containsKey(n)) {
			return cache.get(n);
		}else {
			cache.put(n,fibbinociOfaNumber(n-1)+fibbinociOfaNumber(n-2));
		}
		return cache.get(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int n = ip.nextInt();
         long ans = fibbinociOfaNumber(n);
         System.out.print(ans);
	}

}
