import java.util.HashMap;
import java.util.Scanner;

public class counthash {
    public static void main(String[] args) {
        Scanner ip=new Scanner(System.in);
        String s=ip.nextLine();
        char[] sar=s.toCharArray();
        HashMap<Character,Integer> count=new HashMap<Character, Integer>();
        for(char c:sar){
            if(count.containsKey(c)){
                count.put(c,count.get(c)+1);
            }else {
                count.put(c,1);
            }
        }
        System.out.println(count);
    }
}
