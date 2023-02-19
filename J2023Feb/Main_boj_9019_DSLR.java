package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_9019_DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {
            st = new StringTokenizer(br.readLine());

            sb.append(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }
    static String bfs (int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[10000];
        String [] com = new String[10000];

        queue.offer(s);
        visited[s] = true;
        com[s] = "";

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == e) {
                break;
            }

            // D
            int next = (now * 2) % 10000;
            if (!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                com[next] = com[now] + "D";
            }
            // S
            next = now - 1 < 0 ? 9999 : now - 1;
            if (!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                com[next] = com[now] + "S";
            }
            // L
            next = (now % 1000) * 10 + now / 1000;
            if (!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                com[next] = com[now] + "L";
            }
            // R
            next = (now / 10) + (now % 10) * 1000;
            if (!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                com[next] = com[now] + "R";
            }
        }

        return com[e];
    }
}
