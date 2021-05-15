import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        String s = "[a-z]";
        String to_match = "i am in the in of the lningin bat.";
        Pattern  p = Pattern.compile(s);
        Matcher m = p.matcher(to_match);
        while (m.find()){
            System.out.print(to_match.substring(m.start(),m.end()));
        }
    }
}
