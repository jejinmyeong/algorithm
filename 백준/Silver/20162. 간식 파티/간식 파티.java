import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [] arr= new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int [] dp = Arrays.copyOf(arr, N);

        int res = 0;

        for (int i = 0 ; i < N ; i++) {
            res = Math.max(res, arr[i]);
            for (int j = i + 1 ; j < N ; j++) {
                if (arr[i] < arr[j] && dp[i] + arr[j] > dp[j]) {
                    dp[j] = dp[i] + arr[j];
                    res = Math.max(res, dp[j]);
                }
            }
        }

        System.out.println(res);
    }
}
