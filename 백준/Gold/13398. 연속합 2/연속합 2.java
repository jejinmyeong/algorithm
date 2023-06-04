import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [][] dp = new int[N][2];

        dp[0][0] = dp[0][1] = Integer.parseInt(st.nextToken());

        int ans = dp[0][0];

        for (int i = 1 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.max(dp[i - 1][0] + num, num);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + num);

            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(ans);
    }
}