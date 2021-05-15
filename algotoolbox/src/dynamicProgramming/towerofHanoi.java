package dynamicProgramming;

public class towerofHanoi {
	
	static void toh(int n,String source,String intermediate,String destination) {
		if(n==1) {
			System.out.println("Moved "+1+" from "+source+" to "+destination);
			return;
		}
		toh(n-1,source,intermediate,destination);
		System.out.println("Moved "+n+" from "+source+" to "+destination);
		toh(n-1,intermediate,destination,source);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        toh(4,"a","b","c");
	}
	
}
