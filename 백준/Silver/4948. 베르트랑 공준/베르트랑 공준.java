import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean [] isPrimeNumber = new boolean[123_456 * 2 + 1];

        Arrays.fill(isPrimeNumber, true);

        for (int i = 2 ; i < Math.sqrt(isPrimeNumber.length) ; i++) {
            for (int j = i + i ; j <= 123_456 * 2 ; j += i) {
                isPrimeNumber[j] = false;
            }
        }

        int [] dp = new int[123_456 * 2 + 1];

        for (int i = 1 ; i < 123_456 * 2 + 1 ; i++) {
            if (isPrimeNumber[i]) dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i - 1];
        }

        int N = Integer.parseInt(br.readLine());

        while (N != 0) {
            sb.append(dp[N * 2] - dp[N]).append("\n");
            N = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }
}