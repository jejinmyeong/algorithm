import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int [] arr =  new int[N];

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(dp[y] - dp[x - 1]).append("\n");
        }

        System.out.println(sb);
    }
}