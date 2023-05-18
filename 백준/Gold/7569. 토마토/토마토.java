import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y, z, c;
        Point(int x, int y, int z, int c) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.c = c;
        }
    }
    static int M, N, H;
    static int [][][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // y
        N = Integer.parseInt(st.nextToken()); // x
        H = Integer.parseInt(st.nextToken()); // z

        map = new int[H][N][M];  // z x y

        Queue<Point> queue = new LinkedList<>();

        boolean [][][] visited = new boolean[H][N][M];

        int yet = 0;

        for (int i = 0 ; i < H ; i++) { // 높이
            for (int j = 0 ; j < N ; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0 ; k < M ; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    // 익은 토마토
                    if (map[i][j][k] == 1) {
                        queue.offer(new Point(j, k, i, 0)); // x y z
                        visited[i][j][k] = true;
                    }
                    // 안익은 토마토
                    if (map[i][j][k] == 0) yet++;
                }
            }
        }

        int [][] D = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};

        int day = 0;

        // 큐가 비면 더 이상 일을 못해
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            day = Math.max(day, now.c);

            for (int d = 0 ; d < 6 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];
                int nz = now.z + D[d][2];

                if (isOverflow(nx, ny, nz) || visited[nz][nx][ny] || map[nz][nx][ny] == -1) continue;

                // 여기에 왔으면, 안 익은 토마토
                visited[nz][nx][ny] = true;
                queue.offer(new Point(nx, ny, nz, now.c + 1));
                yet--;
            }
        }

        if (yet > 0) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }

    static boolean isOverflow(int nx, int ny, int nz) {
        return nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H;
    }
}

