import java.util.*;
import java.io.*;
import java.math.*;
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

        int [] dp = new int[N];

        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int i = 0 ; i < N ; i++) {
            if (arr[i] == 0 || dp[i] == 987654321) continue;
            for (int j = 1 ; j <= arr[i] ; j++) {
                if (i + j >= N) break;
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if (dp[N - 1] == 987654321) System.out.println(-1);
        else System.out.println(dp[N - 1]);
    }
}