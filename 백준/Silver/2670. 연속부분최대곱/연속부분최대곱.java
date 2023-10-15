import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        double [] dp = new double[N];

        dp[0] = Double.parseDouble(br.readLine());

        double ans = dp[0];

        for (int i = 1 ; i < N ; i++) {
            double now = Double.parseDouble(br.readLine());
            dp[i] = Math.max(now, dp[i - 1] * now);

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(String.format("%.3f", ans));

    }
}
