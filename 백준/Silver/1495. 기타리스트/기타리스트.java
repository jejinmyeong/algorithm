import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] dp = new int[M + 1];
        Arrays.fill(dp, -1);

        dp[S] = 0;

        for (int i = 1 ; i <= N ; i++) {
            int V = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0 ; j <= M ; j++) {
                if (dp[j] == i - 1) {
                    if (j + V >= 0 && j + V <= M) {
                        set.add(j + V);
                    }
                    if (j - V >= 0 && j - V <= M) {
                        set.add(j - V);
                    }
                }
            }

            for (Integer n : set) {
                dp[n] = i;
            }
        }

        int max = -1;

        for (int i = M ; i >= 0 ; i--) {
            if (dp[i] == N) {
                max = i;
                break;
            }
        }

        System.out.println(max);
    }
}