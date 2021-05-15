import java.util.*;

interface b1{
    void method();
}

class b implements b1{
    @Override
    public void method() {
        System.out.println("b");
    }
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name);//alphabetically
        } else {
            return b.score - a.score;//decreasing
        }
    }
}

class point{
    int x;
    int y;
    public point(int x,int y){
       this.x=x;
       this.y=y;
    }
    static int slope(point p1,point p2){
         return p1.y - p2.y/p1.x - p2.x;
    }

    static boolean isonsameline(point p1,point p2,point p3){
        return slope(p1,p2)==slope(p2,p3);
    }

}
class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class A extends b implements b1 {

    static Scanner ip = new Scanner(System.in);

    static int sockMerchant(int n, int[] ar) {
        Set<Integer> colors = new HashSet<>();
        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (!colors.contains(ar[i])) {
                colors.add(ar[i]);
            } else {
                pairs++;
                colors.remove(ar[i]);
            }
        }
        return pairs;
    }

    public static int countingValleys(int steps, String path) {
        int num_valleys = 0;
        int level = 0;
        char[] hiker = path.toCharArray();
        for (char c : hiker) {
            if (c == 'U') {
                level += 1;
            } else if (c == 'D') {
                level -= 1;
            }
            if (level == 0 && c == 'U') {
                num_valleys += 1;
            }
        }
        return num_valleys;
    }

    static int jumpingOnClouds(int[] c) {
        int num_jumps = 0;
        int curr_position = 0;
        while (curr_position < c.length - 2) {
            if (c[curr_position + 2] == 1) {
                curr_position += 1;
            } else if (c[curr_position + 2] == 0) {
                curr_position += 2;
            }
            num_jumps += 1;
        }
        if (curr_position != c.length - 1) {
            num_jumps += 1;
        }
        return num_jumps;
    }


    static long repeatedString(String s, long n) {
        long size = s.length(), repeated = n / size;
        long left = n - (size * repeated);
        int extra = 0;

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == 'a') {
                ++count;
            }
        }

        for (int i = 0; i < left; i++) {
            if (s.charAt(i) == 'a') {
                ++extra;
            }
        }

        repeated = (repeated * count) + extra;

        return repeated;
    }

    public static void common(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                System.out.print(a[i] + "  ");
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
    }

    static int hourglassSum(int[][] arr) {
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
            }
        }
        return Collections.max(sum);
    }

    static boolean isAnagram(String a, String b) {
        HashMap<Character, Integer> count = new
                HashMap<>();
        a = a.toLowerCase(Locale.ROOT);
        b = b.toLowerCase(Locale.ROOT);
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (!count.containsKey(c)) {
                count.put(c, 1);
            } else {
                int f = count.get(c);
                count.put(c, f++);
            }
        }
        for (int i = 0; i < a.length(); i++) {
            char c = b.charAt(i);
            if (!count.containsKey(c)) {
                return false;
            } else {
                int freq = count.get(c);
                if (freq == 0) {
                    return false;
                } else {
                    count.put(c, --freq);
                }
            }
        }
        return true;
    }

    static int negativesubarrays(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum < 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static void printnuminlist() {
        int n = ip.nextInt();
        int d, q, x, y;
        ArrayList<ArrayList<Integer>> set = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            d = ip.nextInt();
            ArrayList<Integer> toadd = new ArrayList();
            for (int j = 0; j < d; j++) {
                toadd.add(j, ip.nextInt());
            }
            set.add(toadd);
        }
        q = ip.nextInt();
        for (int i = 0; i < q; i++) {
            x = ip.nextInt();
            y = ip.nextInt();
            try {
                System.out.println(set.get(x - 1).get(y - 1));
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
    }

    public static boolean canWin(int leap, int[] game) {
        return isSolvable(leap, game, 0);
    }

    private static boolean isSolvable(int m, int[] arr, int i) {
        if (i < 0 || arr[i] == 1) return false;
        if ((i == arr.length - 1) || i + m > arr.length - 1) return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }


    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push('(');
            else if (s.charAt(i) == '{')
                stack.push('{');
            else if (s.charAt(i) == '[')
                stack.push('[');
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
            } else if (s.charAt(i) == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '{') return false;
            } else if (s.charAt(i) == ']') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public void fizz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (n % 3 == 0 && !(n % 5 == 0)) {
            System.out.println("Fizz");
        } else if (!(n % 3 == 0) && n % 5 == 0) {
            System.out.println("Buzz");
        } else if (!(n % 3 == 0 && n % 5 == 0)) {
            System.out.println(n);
        }
    }

    static long arrayManipulation(int n, int[][] queries) {
          int[] a = new int[n];
          for(int i=0;i<n;i++){
              a[i]=0;
          }
          int m = ip.nextInt();
          for(int i=0;i<m;i++){
              for(int j=0;j<2;j++){
                  queries[i][j] = ip.nextInt();
              }
          }
          int i=0;
          while (i<queries.length){
              for(int j=queries[i][0]-1;j<=queries[i][1]-1;j++){
                  a[j]+=queries[i][2];
              }
              i++;
          }
          return Arrays.stream(a).max().getAsInt();
    }

    public static void main(String[] args) {

    }
}
