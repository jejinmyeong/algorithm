import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 2) {
            System.out.println(1);
            return;
        } else if (N == 4) {
            System.out.println(2);
            return;
        } else if (N < 5) {
            System.out.println(-1);
            return;
        }

        int [] dp = new int[N + 1];

        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[2] = 1;
        dp[4] = 2;

        for (int i = 5 ; i <= N ; i++) {
            if (dp[i - 2] != -1 && dp[i - 5] != -1) {
                dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
            } else if (dp[i - 2] != -1) {
                dp[i] = dp[i - 2] + 1;
            } else if (dp[i - 5] != -1) {
                dp[i] = dp[i - 5] + 1;
            }
        }

        System.out.println(dp[N]);

    }
}