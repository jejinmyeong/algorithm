import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int [][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int min = 101;
        int max = 0;

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int ans = 0;

        for (int h = min - 1 ; h <= max + 1 ; h++) {
            int cnt = bfs(h);

            if (cnt == 0) break;

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }

    static int bfs(int h) {
        Queue<int []> queue = new LinkedList<>();
        boolean [][] visited = new boolean[N][N];
        int [][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (visited[i][j] || map[i][j] <= h) continue;

                queue.offer(new int [] {i, j});
                visited[i][j] = true;
                cnt++;

                while(!queue.isEmpty()) {
                    int [] now = queue.poll();

                    for (int d = 0 ; d < 4 ; d++) {
                        int nx = now[0] + D[d][0];
                        int ny = now[1] + D[d][1];

                        if (isOverflow(nx, ny) || visited[nx][ny] || map[nx][ny] <= h) continue;

                        visited[nx][ny] = true;
                        queue.offer(new int [] {nx, ny});
                    }
                }
            }
        }


        return cnt;
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }
}