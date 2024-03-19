import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N + 1][M + 1];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [][] dp = new int[N + 1][M + 2];
        dp[1][1] = map[1][1];

        for (int i = 2 ; i <= M ; i++) dp[1][i] = map[1][i] + dp[1][i - 1];

        for (int i = 2 ; i <= N ; i++) {
            int [][] temp = new int[2][M + 2];

            temp[0][0] = dp[i - 1][1];
            for (int j = 1 ; j <= M ; j++) {
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + map[i][j];
            }


            temp[1][M + 1] = dp[i - 1][M];
            for (int j = M ; j >= 1 ; j--) {
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + map[i][j];
            }

            for (int j = 1 ; j <= M ; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[N][M]);
    }
}