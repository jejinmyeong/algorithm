import java.util.*;
import java.io.*;

public class Main {
    static class Pos {
        int x, y, c;

        Pos(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];
        int [][] dist = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][] D = {{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1}};

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                Queue<Pos> queue = new ArrayDeque<>();
                boolean [][] visited = new boolean[N][M];

                queue.offer(new Pos(i, j, 0));
                visited[i][j] = true;
                dist[i][j] = 0;

                while (!queue.isEmpty()) {
                    Pos now = queue.poll();

                    for (int d = 0 ; d < 8 ; d++) {
                        int nx = now.x + D[d][0];
                        int ny = now.y + D[d][1];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1 || visited[nx][ny]) continue;

                        dist[nx][ny] = Math.min(dist[nx][ny], now.c + 1);
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny, now.c + 1));
                    }
                }

            }
        }

        int ans = 0;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                ans = Math.max(dist[i][j], ans);
            }
        }

        System.out.println(ans);

    }
}