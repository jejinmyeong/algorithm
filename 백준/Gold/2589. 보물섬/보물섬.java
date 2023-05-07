import java.io.*;
import java.util.*;

public class Main {
    static int L, W;
    static char [][] map;
    static int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[L][W];

        for (int i = 0 ; i < L ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < W ; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int ans = 0;

        for (int i = 0 ; i < L ; i++) {
            for (int j = 0 ; j < W ; j++) {
                if (map[i][j] == 'W') continue;
                ans = Math.max(ans, bfs(i, j));
            }
        }

        System.out.println(ans);
    }

    static class Point {
        int x, y, c;

        Point(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        boolean [][] visited = new boolean[L][W];

        queue.offer(new Point(x, y, 0));
        visited[x][y] = true;

        int res = 0;
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            res = Math.max(res, now.c);

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (isOverflow(nx, ny) || visited[nx][ny] || map[nx][ny] == 'W') continue;

                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny, now.c + 1));
            }
        }

        return res;
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= L || ny >= W;
    }
}
