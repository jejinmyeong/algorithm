package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_2475_검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans = 0;

        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            ans += Math.pow(n, 2);
        }

        System.out.println(ans % 10);
    }
}
