package problemsolving.stack;
import java.util.*;
public class equal_stacks {
    public static int height(List<Integer> list){
        int height=0;
        for (int i:list){
            height+=i;
        }
        return height;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
         int height1=height(h1);
         int height2=height(h2);
         int height3 = height(h3);
         int min = Math.min(height1,Math.min(height2,height3));
         Stack<Integer> s1 = new Stack<>();
         for (int i=h1.size()-1;i>=0;i--){
             s1.push(h1.get(i));
         }
        Stack<Integer> s2 = new Stack<>();
        for (int i=h2.size()-1;i>=0;i--){
            s2.push(h2.get(i));
        }
        Stack<Integer> s3 = new Stack<>();
        for (int i=h3.size()-1;i>=0;i--){
            s3.push(h3.get(i));
        }
        while (!(height1==height2&&height2==height3)){
            if (height1>min){
                height1=height1-s1.peek();
                min=Math.min(min,height1);
                s1.pop();
            }
            if (height2>min){
                height2=height2-s2.peek();
                min=Math.min(min,height2);
                s2.pop();
            }
            if (height3>min){
                height3=height3-s3.peek();
                min=Math.min(min,height3);
                s3.pop();
            }
        }
        return height1;
    }
}
