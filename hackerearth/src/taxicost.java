import java.util.Scanner;

public class taxicost {
    public static void main(String[] args) {
        Scanner ip=new Scanner(System.in);
        long olfare,offare;
        long D=ip.nextLong();
        long oc=ip.nextLong();
        long of=ip.nextLong();
        long od=ip.nextLong();
        long cs=ip.nextLong();
        long cb=ip.nextLong();
        long cm=ip.nextLong();
        long cd=ip.nextLong();
        olfare= oc+((D-of)*od);
        offare= cb+(long) ((D/cs)*cm)+D*cd;
        if (olfare>offare){
            System.out.println("Classic Taxi");
        }else {
            System.out.println("Online Taxi");
        }
    }
}
