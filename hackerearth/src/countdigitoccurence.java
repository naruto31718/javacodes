import java.util.HashMap;
import java.util.Scanner;

public class countdigitoccurence {
    public static void main(String[] args) {
        Scanner ip=new Scanner(System.in);
         String s=ip.nextLine();
         char[] sar=s.toCharArray();
         int zero=0,one=0,two=0,three=0,four=0,five=0,six=0,sev=0,ei=0,nine=0;
         for(int i=0;i<sar.length;i++){
             if(sar[i]=='0'){
                 zero++;
             }
             if(sar[i]=='1'){
                 one++;
             }if(sar[i]=='2'){
                 two++;
             }if(sar[i]=='3'){
                 three++;
             }if(sar[i]=='4'){
                 four++;
             }if(sar[i]=='5'){
                 five++;
             }if(sar[i]=='6'){
                 six++;
             }if(sar[i]=='7'){
                 sev++;
             }if(sar[i]=='8'){
                 ei++;
             }if(sar[i]=='9'){
                 nine++;
             }
         }
        System.out.println(0+" "+zero);
        System.out.println(1+" "+one);
        System.out.println(2+" "+two);
        System.out.println(3+" "+three);
        System.out.println(4+" "+four);
        System.out.println(5+" "+five);
        System.out.println(6+" "+six);
        System.out.println(7+" "+sev);
        System.out.println(8+" "+ei);
        System.out.println(9+" "+nine);
    }
}
