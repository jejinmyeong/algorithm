import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            int d = Integer.parseInt(st.nextToken());

            if (d == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        
        int start = 0;
        int end = 1;

        int ans = Integer.MAX_VALUE;

        while (end <= N) {
            int cnt = dp[end] - dp[start];

            if (cnt >= K) {
                ans = Math.min(ans, end - start);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}