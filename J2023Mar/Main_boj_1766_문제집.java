package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_boj_1766_문제집 {

    static ArrayList<Integer> [] nodes;
    static int [] inDegree;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];
        inDegree = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) nodes[i] = new ArrayList<>();

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            nodes[before].add(after);
            inDegree[after]++;
        }

        ArrayList<Integer> res = bfs();

        for (int i = 0 ; i < N ; i++) {
            sb.append(res.get(i)).append(" ");
        }

        System.out.print(sb);
    }

    static ArrayList<Integer> bfs() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1 ; i <= N ; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            res.add(now);

            for (int i = 0; i < nodes[now].size(); i++) {
                int next = nodes[now].get(i);
                inDegree[next]--;

                if (inDegree[next] == 0) queue.offer(next);
            }

        }

        return res;
    }
}
