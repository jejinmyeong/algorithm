package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_boj_17626_FourSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] dp = new int[N + 1];

        Arrays.fill(dp, 4);

        dp[0] = 0;

        for (int i = 0 ; i <= N ; i++) {
            int idx = 1;
            while (true) {
                int next = i + (int) Math.pow(idx, 2);

                if (next > N) break;

                dp[next] = Math.min(dp[next], dp[i] + 1);
                idx++;
            }
        }

        System.out.println(dp[N]);
    }
}
