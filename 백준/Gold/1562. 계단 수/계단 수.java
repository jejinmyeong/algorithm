import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long [][][] dp = new long[N + 1][10][1 << 10];

        for (int i = 1 ; i < 10 ; i++) {
            dp[1][i][1 << i] = 1;
        }

        final int MOD = 1_000_000_000;

        for (int i = 2 ; i <= N ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                for (int k = 0 ; k < (1 << 10) ; k++) {
                    int next = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][next] = (dp[i][j][next] + dp[i - 1][j + 1][k]) % MOD;
                    } else if (j == 9) {
                        dp[i][j][next] = (dp[i][j][next] + dp[i - 1][j - 1][k]) % MOD;
                    } else {
                        dp[i][j][next] = (dp[i][j][next] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD;
                    }
                }
            }
        }

        long sum = 0;

        for (int i = 0 ; i < 10 ; i++) {
            sum = (sum + dp[N][i][(1 << 10) - 1]) % MOD;
        }

        System.out.println(sum);

    }
}