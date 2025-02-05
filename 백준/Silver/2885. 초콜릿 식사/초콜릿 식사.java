import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int N = 1;

        int [] dp = new int[(int) Math.pow(2, 20) + 1];

        for (int i = 1 ; i < 20 ; i++) {
            for (int j = (int) Math.pow(2, i) + 1 ; j < (int) Math.pow(2, i + 1) ; j += 2){
                dp[j] = i + 1;
            }
        }

        for (int i = 4 ; i < (int) Math.pow(2, 20) + 1 ; i++) {
            int temp = i;
            while (temp % 2 == 0) {
                temp /= 2;
            }

            dp[i] = dp[temp];
        }

        while (N < K) {
            N *= 2;
        }

        System.out.println(N + " " + dp[K]);
    }
}
