package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_15663_N과M9 {
    static int N, M, max;
    static int [] nums;
    static boolean [] check;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        nums = new int[N];
        check = new boolean[N];

        for (int i = 0 ; i < N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(nums[i], max);
        }

        Arrays.sort(nums);

        dfs(0, "");

        System.out.print(sb);
    }

    static void dfs (int cnt, String str) {
        if (cnt >= M) {
            sb.append(str).append("\n");
            return;
        }

        boolean [] visited = new boolean[max + 1];

        for (int i = 0 ; i < N ; i++) {
            if (visited[nums[i]] || check[i]) continue;
            visited[nums[i]] = true;
            check[i] = true;
            dfs(cnt + 1, str + nums[i] + " ");
            check[i] = false;
        }

    }
}
