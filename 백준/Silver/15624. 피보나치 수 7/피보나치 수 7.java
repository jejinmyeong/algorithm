import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        } else if (n == 1) {
            System.out.println(1);
            return;
        }

        long [] dp = new long[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2 ; i <= n ; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_007;
        }

        System.out.println(dp[n]);
    }
}