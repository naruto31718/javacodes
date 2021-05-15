import java.util.*;
public class basic_IO {
    public static void main(String[] args) {
        Scanner ip=new Scanner(System.in);
        int n=ip.nextInt();
        String s=ip.nextLine();
        System.out.println(n*2);
        System.out.println(s);
        ip.close();
    }
}
