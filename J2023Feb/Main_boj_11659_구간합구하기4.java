package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] map = new int[N];

        st = new StringTokenizer(br.readLine());

        map[0] = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i < N ; i++) {
            map[i] = map[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;

            sb.append(map[e] - (s == 0 ? 0 : map[s - 1])).append("\n");
        }

        System.out.print(sb);
    }
}
