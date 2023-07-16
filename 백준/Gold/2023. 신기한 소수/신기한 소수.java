import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static StringBuffer sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());

        dfs(0, 0);

        System.out.print(sb);
    }

    static void dfs (int c, int num) {
        if (c == N) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1 ; i < 10 ; i++) {
            int next = num * 10 + i;
            if (isPrime(next)) dfs(c + 1, next);
        }
    }

    static boolean isPrime (int num) {
        if (num == 1) return false;

        int sqrt = (int) Math.sqrt(num);

        for (int i = 2 ; i <= sqrt ; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}