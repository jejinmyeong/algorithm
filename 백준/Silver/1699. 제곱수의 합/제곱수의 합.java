import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N + 1];

        for (int i = 0 ; i <= N ; i++) {
            dp[i] = i;
        }

        for (int i = 2 ; i <= N ; i++) {
            for (int j = 1 ; j <= Math.sqrt(i) ; j++) {
                dp[i] = Math.min(dp[i], dp[i - (int) Math.pow(j, 2)] + 1);
            }
        }

        System.out.println(dp[N]);

    }
}