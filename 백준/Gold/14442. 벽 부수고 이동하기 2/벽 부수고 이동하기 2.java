import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int [][] map, D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1 ; i <= N ; i++) {
            String input = br.readLine();
            for (int j = 1 ; j <= M ; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs());
    }

    static class Point {
        int x, y, c, k;
        Point (int x, int y, int c, int k) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.k = k;
        }
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean [][][] visited = new boolean[N + 1][M + 1][K + 1];

        queue.offer(new Point(1, 1, 0, 0));
        visited[1][1][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == N && now.y == M) {
                return now.c + 1;
            }

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (isOverflow(nx, ny) || (map[nx][ny] == 1 && (now.k == K || visited[nx][ny][now.k + 1])) || (map[nx][ny] == 0 && visited[nx][ny][now.k])) continue;

                if (map[nx][ny] == 1) {
                    visited[nx][ny][now.k + 1] = true;
                    queue.offer(new Point(nx, ny, now.c + 1, now.k + 1));
                } else {
                    visited[nx][ny][now.k] = true;
                    queue.offer(new Point(nx, ny, now.c + 1, now.k));
                }
            }
        }

        return -1;
    }

    static boolean isOverflow(int nx, int ny) {
        return nx <= 0 || ny <= 0 || nx > N || ny > M;
    }
}
