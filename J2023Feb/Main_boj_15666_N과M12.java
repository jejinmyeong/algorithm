package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_boj_15666_N과M12 {
    static int N, M;
    static ArrayList<Integer> nums;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (set.contains(num)) continue;
            set.add(num);
            nums.add(num);
        }

        Collections.sort(nums);

        dfs(0, 0, "");

        System.out.print(sb);
    }

    static void dfs (int cnt, int idx, String str) {
        if (cnt == M) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = idx ; i < nums.size() ; i++) {
            dfs(cnt + 1, i, str + nums.get(i) + " ");
        }
    }
}
