import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[N + 1];
        int [] dp = new int[N + 1];

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            for (int j = i - 1 ; j >= 1 ; j--) {
                ans = Math.max(ans, Math.abs(arr[i] - arr[j]) + dp[j - 1]);
            }

            dp[i] = ans;
        }

        System.out.println(dp[N]);
    }
}

