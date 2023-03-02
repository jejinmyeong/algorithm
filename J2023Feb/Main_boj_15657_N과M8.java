package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_15657_N과M8 {
    static StringBuilder sb;
    static int N, M;
    static int [] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        nums = new int[N];

        for (int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0, 0, "");

        System.out.print(sb);
    }

    static void dfs (int cnt, int idx, String str) {
        if (cnt == M) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = idx ; i < N ; i++) {
            dfs(cnt + 1, i, str + nums[i] + " ");
        }
    }
}
