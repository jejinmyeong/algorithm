package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_1697_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K <= N) {
            System.out.println(N - K);
            return;
        }

        boolean [] visited = new boolean[(K - 1) * 2 + 1];
        visited[N] = true;

        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {N, 0});

        while (!queue.isEmpty()) {
            int [] now = queue.poll();

            if (now[0] == K) {
                System.out.println(now[1]);
                return;
            }

            // 뒤로 가는 경우
            if (now[0] - 1 >= 0 && !visited[now[0] - 1]) {
                queue.offer(new int[]{now[0] - 1, now[1] + 1});
                visited[now[0] - 1] = true;
            }
            // 앞으로 가는 경우
            if (now[0] + 1 <= K && !visited[now[0] + 1]) {
                queue.offer(new int [] {now[0] + 1, now[1] + 1});
                visited[now[0] + 1] = true;
            }
            // 순간이동 하는 경우
            if (now[0] * 2 < (K - 1) * 2 && !visited[now[0] * 2]) {
                queue.offer(new int [] {now[0] * 2, now[1] + 1});
                visited[now[0] * 2] = true;
            }
        }

    }
}
