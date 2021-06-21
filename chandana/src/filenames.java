import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class filenames {
    static Scanner ip = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> fileNames = new ArrayList<>();
        for(int i=0;i<5;i++){
            fileNames.add(ip.nextLine());
        }
        Collections.sort(fileNames);
        String concatinated = "";
        for(int i=0;i<5;i++){
            concatinated+=fileNames.get(i);
        }
        int count = 0;
        for(int i=0;i<concatinated.length();i++){
            if(concatinated.charAt(i)=='a'){
                count++;
            }
        }
        System.out.println(count);
    }
}
