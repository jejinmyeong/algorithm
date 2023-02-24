package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_boj_15654_N과M5 {
    static StringBuilder sb;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) continue;
            set.add(num);
            list.add(num);
        }

        Collections.sort(list);

        visited = new boolean[list.size()];
        dfs(list, 0, M, new int [M]);

        System.out.print(sb);
    }

    static void dfs (ArrayList<Integer> list, int idx, int M, int [] seq) {
        if (idx == M) {
            for (int i = 0 ; i < M ; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0 ; i < list.size() ; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            seq[idx] = list.get(i);
            dfs (list, idx + 1, M, seq);
            visited[i] = false;
        }
    }
}
