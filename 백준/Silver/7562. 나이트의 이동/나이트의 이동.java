import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y, c;
        Point (int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int [][] D = {{-2, -1},{-2, 1},{1, 2},{-1, 2},{2, 1},{2, -1},{-1, -2},{1, -2}};

        while (T-- > 0) {
            int L = Integer.parseInt(br.readLine());

            boolean [][] visited = new boolean[L][L];
            Queue<Point> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            queue.offer(new Point(x, y, 0));
            visited[x][y] = true;

            st = new StringTokenizer(br.readLine());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if (now.x == eX && now.y == eY) {
                    sb.append(now.c).append("\n");
                    break;
                }

                for (int d = 0 ; d < 8 ; d++) {
                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (isOverflow(nx, ny, L) || visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, now.c + 1));
                }
            }

        }
        System.out.print(sb);
    }

    static boolean isOverflow (int nx, int ny, int L) {
        return nx < 0 || ny < 0 || nx >= L || ny >= L;
    }
}