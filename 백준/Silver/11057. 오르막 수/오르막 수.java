import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [][] dp = new int[N + 1][10];

        Arrays.fill(dp[0], 1);

        for (int i = 1 ; i <= N ; i++) {
            dp[i][9] = dp[i - 1][9];
            for (int j = 8 ; j >= 0 ; j--) {
                dp[i][j] = (dp[i][j + 1] + dp[i - 1][j]) % 10007;
            }
        }

        System.out.println(dp[N][0]);

    }
}