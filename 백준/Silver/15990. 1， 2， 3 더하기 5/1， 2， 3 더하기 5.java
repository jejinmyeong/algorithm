import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long [][] dp = new long[3][100001];
        dp[0][1] = 1;
        dp[1][2] = 1;
        dp[2][3] = 1;
        dp[0][3] = 1;
        dp[1][3] = 1;

        for (int i = 4 ; i <= 100000 ; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % 1_000_000_009;
            dp[1][i] = (dp[0][i - 2] + dp[2][i - 2]) % 1_000_000_009;
            dp[2][i] = (dp[0][i - 3] + dp[1][i - 3]) % 1_000_000_009;
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            
            long ans = (dp[0][N] + dp[1][N] + dp[2][N]) % 1_000_000_009;

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
