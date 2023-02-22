package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_9465_스티커 {
    static int [][] sticker;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            N = Integer.parseInt(br.readLine());

            sticker = new int[2][N];

            for (int i = 0 ; i < 2 ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < N ; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int [][] dp = new int[2][N];

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];

            if (N > 1) {
                dp[0][1] = dp[1][0] + sticker[0][1];
                dp[1][1] = dp[0][0] + sticker[1][1];
            }

            if (N > 2)
                for (int j = 2 ; j < N ; j++) {
                    for (int i = 0 ; i < 2 ; i++) {
                        dp[i][j] = Math.max(dp[(i + 1) % 2][j - 1], dp[(i + 1) % 2][j - 2]) + sticker[i][j];
                    }
                }

            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append("\n");
        }
        System.out.print(sb);
    }
}
