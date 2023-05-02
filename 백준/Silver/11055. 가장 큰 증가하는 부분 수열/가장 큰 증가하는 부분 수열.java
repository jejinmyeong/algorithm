import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[N];

        for (int i = 0 ; i < N ; i++) {
            dp[i] = arr[i];
        }

        for (int i = 1 ; i < N ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }

        int max = 0;

        for (int i = 0 ; i < N ; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}