import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [][] dp = new int[2][N];

        dp[0][0] = 1;
        dp[1][0] = 1;

        int ans = 1;

        for (int i = 1 ; i < N ; i++) {
            if (arr[i - 1] <= arr[i]) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = 1;
            }

            if (arr[i - 1] >= arr[i]) {
                dp[1][i] = dp[1][i - 1] + 1;
            } else {
                dp[1][i] = 1;
            }

            ans = Math.max(ans, Math.max(dp[0][i], dp[1][i]));
        }

        System.out.println(ans);

    }
}