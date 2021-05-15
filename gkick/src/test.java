import java.util.*;
public class test{
	public static long ans(String s,long k){
		long ans=0;
        if(!s.contains("-")){
        	ans=0;
		}

		return ans;
	}
	public static void main(String[] args) {
		Scanner ip=new Scanner(System.in);
		long t;
		t= ip.nextLong();
		long i=1;
		while (t >0){
			String s; long k;
			s=ip.nextLine();
			k=ip.nextLong();
			long an= ans(s,k);
			if (an== -1){
				System.out.println("Case #"+i+": "+"IMPOSSIBLE");
			}else {
				System.out.println("Case #"+i+": "+an);
			}
			t--;
			i++;
		}
	}
}