import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long [][] dp = new long[N][21];

        st = new StringTokenizer(br.readLine());

        dp[1][Integer.parseInt(st.nextToken())] = 1;
        for (int i = 2 ; i < N ; i++) {
            int now = Integer.parseInt(st.nextToken());
            for (int j = 0 ; j <= 20 ; j++) {
                if (j + now <= 20) {
                    dp[i][j + now] += dp[i - 1][j];
                }

                if (j - now >= 0) {
                    dp[i][j - now] += dp[i - 1][j];
                }
            }
        }

        int res = Integer.parseInt(st.nextToken());

        System.out.println(dp[N - 1][res]);
    }
}