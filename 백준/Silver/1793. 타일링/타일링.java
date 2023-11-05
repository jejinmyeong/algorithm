import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger [] dp = new BigInteger[251];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for (int i = 3 ; i <= 250 ; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));
        }

        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);

            sb.append(dp[N]).append("\n");
        }

        System.out.print(sb);

    }
}