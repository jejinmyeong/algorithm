import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [] T = new int[N + 2];
        int [] P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[N + 2];
        int max = 0;

        for (int i = 1; i < N + 2; i++) {

            max = Math.max(dp[i], max);

            int day = i + T[i];
            if(day < N + 2)
                dp[day] = Math.max(dp[day], max + P[i]);

        }

        System.out.println(max);
    }
}