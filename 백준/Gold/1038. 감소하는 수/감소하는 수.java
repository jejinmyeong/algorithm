import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Long> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N <= 10) {
            System.out.println(N);
            return;
        } else if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        list = new ArrayList<>();

        for (int i = 0 ; i <= 9 ; i++) {
            dfs(i);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
    }

    static void dfs (long n) {
        list.add(n);

        long remainder = n % 10;

        if (remainder == 0) return;

        for (long i = remainder - 1 ; i >= 0 ; i--) {
            long next = n * 10 + i;
            dfs(next);
        }
    }
}
