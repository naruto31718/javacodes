import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> phonebook = new LinkedHashMap<>();
        phonebook.put("xxxx",1234);
        phonebook.put("yyyy",1111);
        phonebook.put("zzzz",2222);
        phonebook.put("kkkk",3333);
        for(Map.Entry<String,Integer> entry:phonebook.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        Set<Map.Entry<String, Integer>> entryset = phonebook.entrySet();

        Iterator it = entryset.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
