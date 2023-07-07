import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] map = new int[N + 1][M + 1];

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        boolean [][] visited = new boolean[N + 1][M + 1];

        Queue<int []> queue = new ArrayDeque<>();

        final int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        int ans = 0;

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                if (map[i][j] == 0 || visited[i][j]) continue;

                queue.offer(new int [] {i, j});
                visited[i][j] = true;

                int cnt = 1;

                while (!queue.isEmpty()) {
                    int [] now = queue.poll();

                    for (int d = 0 ; d < 4 ; d++) {
                        int nx = now[0] + D[d][0];
                        int ny = now[1] + D[d][1];

                        if (nx < 1 || ny < 1 || nx > N || ny > M || visited[nx][ny] || map[nx][ny] == 0) continue;

                        cnt++;
                        visited[nx][ny] = true;
                        queue.offer(new int [] {nx, ny});
                    }
                }

                ans = Math.max(ans, cnt);
            }
        }

        System.out.println(ans);
    }
}