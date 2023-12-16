import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        long [] prices = new long[n];

        for (int i = 0 ; i < n ; i++) {
            prices[i] = Long.parseLong(br.readLine());
        }

        // 코인 개수
        long byteCoin = 0;
        // 현금
        long seed = W;

        for (int i = 0 ; i < n - 1 ; i++) {
            // 오늘 보다 내일 비싸면 구매
            if (prices[i] < prices[i + 1]) {
                long cnt = seed / prices[i];

                seed -= prices[i] * cnt;
                byteCoin += cnt;
            }

            // 오늘 보다 내일 싸면 판매
            else if (prices[i] > prices[i + 1]) {
                seed += byteCoin * prices[i];
                byteCoin = 0;
            }
        }

        // 남은 코인이 있다면 다 판매
        if (byteCoin > 0) {
            seed += byteCoin * prices[n - 1];
        }

        System.out.println(seed);

    }
}