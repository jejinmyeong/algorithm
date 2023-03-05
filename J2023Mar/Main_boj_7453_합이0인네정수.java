package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int [][] map = new int[N][4];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 4 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [] left = new int[N * N];
        int [] right = new int[N * N];

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                left[i * N + j] = map[i][0] + map[j][1];
                right[i * N + j] = map[i][2] + map[j][3];
            }
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int ls = 0;
        int re = N * N - 1;

        long ans = 0;

        while (true) {
            if (ls >= N * N || re < 0) break;

            int l = left[ls];
            int r = right[re];

            if (l + r == 0) {
                long lc = 0;
                while (ls < N * N && left[ls] == l) {
                    ls++;
                    lc++;
                }

                long rc = 0;
                while (re >= 0 && right[re] == r) {
                    re--;
                    rc++;
                }

                ans += lc * rc;
            }

            if (l + r > 0) re--;
            if (l + r < 0) ls++;

        }

        System.out.println(ans);
    }
}
