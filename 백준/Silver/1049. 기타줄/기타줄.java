import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPack = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            minPack = Math.min(minPack, Integer.parseInt(st.nextToken()));
            min = Math.min(min, Integer.parseInt(st.nextToken()));
        }

        int [] dp = new int[N + 7];
        dp[1] = min;
        dp[2] = min * 2;
        dp[3] = min * 3;
        dp[4] = min * 4;
        dp[5] = min * 5;

        for (int i = 6 ; i < N + 7 ; i++) {
            dp[i] = Math.min(dp[i - 1] + min, dp[i - 6] + minPack);
        }

        int ans = dp[N];

        for (int i = N + 1 ; i < N + 7 ; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
