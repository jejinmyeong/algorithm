import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        BigInteger [] dp = new BigInteger[N + 1];

        dp[1] = new BigInteger("1");
        for (int i = 2 ; i <= N ; i++) {
            dp[i] = dp[i - 1].multiply(new BigInteger("2")).add(new BigInteger("1"));
        }

        System.out.println(dp[N]);

        if (N <= 20 ) {
            hanoi(N, 1, 2, 3);
            System.out.print(sb);
        }
    }

    static void hanoi (int n, int from, int base, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, to, base);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, base, from, to);
    }
}