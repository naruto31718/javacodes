import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class streams {
    String author;
    String book;

    public streams(String a, String b) {
        this.author = a;
        this.book = b;
    }

    public static void main(String[] args) {
        /**List<streams> books = new ArrayList<>();
        books.add(new streams("Aw", "tcp"));
        books.add(new streams("tm", "belvd"));
        books.add(new streams("ki", "thebg"));
        books.add(new streams("ja", "thcp"));
        books.add(new streams("ja", "tchq"));
        books.add(new streams("ca", "thae"));

        books.stream().forEach(book -> System.out.println(book));

        /**books.parallelStream().filter(book -> {
            return book.getAuthor().startsWith("j");
        }).filter(book -> {
            return book.getBook().endsWith("p");
        }).forEach(System.out::println);

        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<50;i++){
            arr.add(i+1);
        }
        arr.stream().forEach(a -> System.out.println(a));**/
        //factorial(1000000);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author :" + author + " book is:" + book;
    }

    static void factorial(long n){
        BigInteger f = new BigInteger("1");
        for(long i=0;i<n;i++){
            f= f.multiply(BigInteger.valueOf(i));
        }
        System.out.println(f);
    }

    static void factorial(int n)
    {
        int res[] = new int[100000000];

        // Initialize result
        res[0] = 1;
        int res_size = 1;

        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        System.out.println("Factorial of given number is ");
        for (int i = res_size - 1; i >= 0; i--)
            System.out.print(res[i]);
    }

    // This function multiplies x with the number
    // represented by res[]. res_size is size of res[] or
    // number of digits in the number represented by res[].
    // This function uses simple school mathematics for
    // multiplication. This function may value of res_size
    // and returns the new value of res_size
    static int multiply(int x, int res[], int res_size)
    {
        int carry = 0; // Initialize carry

        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < res_size; i++)
        {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
            // 'prod' in res[]
            carry = prod/10; // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry!=0)
        {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }
}
