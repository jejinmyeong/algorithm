import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        long [] sum = new long[1000001];

        for (int j = 1 ; j <= 1000000 ; j++) {
            for (int k = j ; k <= 1000000 ; k += j) {
                sum[k] += j;
            }
        }

        long [] dp = new long[1000001];

        for (int i = 1 ; i <= 1000000 ; i++) {
            dp[i] = dp[i - 1] + sum[i];
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }
}