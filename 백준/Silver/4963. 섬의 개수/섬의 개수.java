import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int [][] D = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        while(true) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            int [][] map = new int[h][w];

            for (int i = 0 ; i < h ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0 ; j < w ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean [][] visited = new boolean[h][w];

            Queue<Point> queue = new LinkedList<>();

            int cnt = 0;

            for (int i = 0 ; i < h ; i++) {
                for (int j = 0 ; j < w ; j++) {
                    if (visited[i][j] || map[i][j] == 0) continue;

                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                    cnt++;

                    while (!queue.isEmpty()) {
                        Point now = queue.poll();

                        for (int d = 0 ; d < 8 ; d++) {
                            int nx = now.x + D[d][0];
                            int ny = now.y + D[d][1];

                            if (isOverflow(nx, ny, h, w) || visited[nx][ny] || map[nx][ny] == 0) continue;

                            queue.offer(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static boolean isOverflow(int nx, int ny, int h, int w) {
        return nx < 0 || ny < 0 || nx >= h || ny >= w;
    }
}