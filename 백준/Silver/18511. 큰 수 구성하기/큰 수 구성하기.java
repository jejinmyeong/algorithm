import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int [] num;
    static int N, K, ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[K];

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < K ; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);
    }

    static void dfs(int now) {
        if (now > N) {
            return;
        }

        ans = Math.max(ans, now);

        for (int i = 0 ; i < K ; i++) {
            int next = now * 10 + num[i];
            dfs(next);
        }
    }
}