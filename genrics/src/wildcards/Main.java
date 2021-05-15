package wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<office> li1 = new ArrayList<>();
        li1.add(new office());
        li1.add(new office());
        printbuildings(li1);

        List<house> li2 = new ArrayList<>();
        li2.add(new house());
        li2.add(new house());
        printbuildings(li2);
    }
    static void printbuildings(List<? extends building> list){
       for (building item:list){
           System.out.println(item);
       }
    }
}
