import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int [][] dp = new int[T + 1][W + 1];

        for (int i = 1 ; i <= T ; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 0 ; j <= W ; j++) {
                if (j == 0) {
                    if (n == 1) dp[i][j] = dp[i - 1][j] + 1;
                    else dp[i][j] = dp[i - 1][j];

                    continue;
                }

                if ((j % 2 == 0 && n == 1) || (j % 2 == 1 && n == 2)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                }
            }
        }

        int ans = 0;
        for (int i = 0 ; i <= W ; i++) {
            ans = Math.max(ans, dp[T][i]);
        }

        System.out.println(ans);
    }
}