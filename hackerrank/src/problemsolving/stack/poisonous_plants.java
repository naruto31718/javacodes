package problemsolving.stack;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class poisonous_plants {
    public static int poisonousPlants(List<Integer> p) {
        int N = p.size();
        int[] P = new int[N + 2];
        int[] prev = new int[N + 2];
        int[] next = new int[N + 2];
        next[0] = 1;
        prev[N + 1] = N;
        for (int i=0;i<N;i++){
            P[i] = p.get(i);
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        ArrayList<Integer> k = new ArrayList<>();
        for (int i = 1; i < N; ++i) {
            if (P[i] < P[i + 1]) {
                k.add(i);
            }
        }
        int day = 0;
        while (!k.isEmpty()) {
            ++day;
            ArrayList<Integer> nk = new ArrayList<>();
            for (int i = k.size() - 1; i >= 0; --i) {
                int ki = k.get(i);
                int killed = next[ki];
                prev[next[killed]] = ki;
                next[ki] = next[killed];
                if (!nk.isEmpty() && nk.get(nk.size() - 1) == killed) nk.remove(nk.size() - 1);
                if (next[ki] <= N && P[ki] < P[next[ki]]) {
                    nk.add(ki);
                }
            }
            Collections.reverse(nk);
            k = nk;
        }
        return day;
    }

    public static void main(String[] args) {

    }
}
