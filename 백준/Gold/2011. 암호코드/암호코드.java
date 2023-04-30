import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 맨 앞 값이 0인경우
        if (input.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int [] dp = new int[input.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1 ; i < input.length() ; i++) {
            int now = input.charAt(i) - '0';
            int before = input.charAt(i - 1) - '0';

            // 현재 값이 0이면서 이전 값이 0이거나 2보다 큰 경우
            if (now == 0 && (before == 0 || before > 2)) {
                System.out.println(0);
                return;
            }

            // 현재 값이 0인 경우
            if (now == 0) {
                dp[i + 1] = dp[i - 1];
            } 
            // 이전 값이 0이거나 현재 값이 6보다 크고 이전 값이 1보다 큰경우 -> 26보다 큰 경우거나 이전 값이 2보다 큰 경우
            else if (before == 0 || (now > 6 && before > 1) || before > 2) dp[i + 1] = dp[i];
            else dp[i + 1] = (dp[i - 1] + dp[i]) % 1000000;
        }

        System.out.println(dp[input.length()]);
    }
}