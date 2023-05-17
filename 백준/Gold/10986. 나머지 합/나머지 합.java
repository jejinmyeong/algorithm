 import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum = 0;

        st = new StringTokenizer(br.readLine());
        int [] cnt = new int[M];

        long ans = 0;

        for (int i = 0 ; i < N ; i++) {
            sum = (sum + Integer.parseInt(st.nextToken())) % M;

            if (sum == 0) ans++;

            cnt[sum]++;
        }


        for (int i = 0 ; i < M ; i++) {
            if (cnt[i] > 1) {
                ans += (long) cnt[i] * (cnt[i] - 1) / 2;
            }
        }

        System.out.println(ans);
    }


}