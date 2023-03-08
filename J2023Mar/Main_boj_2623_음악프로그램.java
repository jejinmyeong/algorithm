package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_boj_2623_음악프로그램 {

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

        for (int i = 1 ; i <= N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        inDegree = new int[N + 1];
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());

            for (int j = 1 ; j < s ; j++) {
                int singer = Integer.parseInt(st.nextToken());
                nodes[before].add(singer);
                inDegree[singer]++;

                before = singer;
            }
        }

        ArrayList<Integer> res = bfs();

        if (res == null) {
            sb.append(0);
        } else {
            for (int i = 0 ; i < res.size() ; i++) {
                sb.append(res.get(i)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static ArrayList<Integer> bfs () {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1 ; i <= N ; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            res.add(now);

            for (int i = 0 ; i < nodes[now].size() ; i++) {
                int next = nodes[now].get(i);
                inDegree[next]--;

                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        if (res.size() != N) return null;

        return res;
    }
}
