import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long [][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (map[i][j] == 0 || dp[i][j] == 0) continue;
                if (i + map[i][j] < N) {
                    dp[i + map[i][j]][j] += dp[i][j];
                }
                if (j + map[i][j] < N) {
                    dp[i][j + map[i][j]] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}