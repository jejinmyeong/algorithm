import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;

        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean [][] visited = new boolean[N][M];
        int pictures = 0;
        int max = 0;

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (map[i][j] != 1 || visited[i][j]) continue;
                Queue<Point> queue = new LinkedList<>();
                visited[i][j] = true;
                queue.offer(new Point(i, j));
                pictures++;
                int cnt = 1;
                while (!queue.isEmpty()) {
                    Point now = queue.poll();

                    for (int d = 0 ; d < 4 ; d++) {
                        int nx = now.x + D[d][0];
                        int ny = now.y + D[d][1];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0) continue;

                        cnt++;
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }

                max = Math.max(max, cnt);
            }
        }

        System.out.println(pictures);
        System.out.println(max);
    }
}