import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] prices = new int[N + 1];
        int [] dp = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
            dp[i] = prices[i];
        }


        for (int i = 2 ; i <= N ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }

        System.out.println(dp[N]);
    }
}
