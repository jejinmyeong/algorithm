import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;

        int [][] dp = new int[N][M];

        for (int i = 1 ; i < N ; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1 ; i < M ; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1 ; i < N ; i++) {
            for (int j = 1 ; j < M ; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        if (K == -1) {
            System.out.println(dp[N - 1][M - 1]);
            return;
        }

        int x = K / M;
        int y = K % M;

        System.out.println(dp[x][y] * dp[N - x - 1][M - y - 1]);

    }
}