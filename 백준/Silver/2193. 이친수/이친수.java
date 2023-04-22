import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(1);
            return;
        }

        long [] dp = new long[N + 1];

        dp[1] = 1L;
        dp[2] = 1L;

        for (int i = 3 ; i <= N ; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[N]);

    }
}