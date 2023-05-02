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

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char [][] map = new char[R][C];
        boolean [][] visited = new boolean[R][C];
        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        Queue<Point> water = new LinkedList<>();
        Queue<Point> queue = new LinkedList<>();

        Point end = null;

        for (int i = 0 ; i < R ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < C ; j++) {
                char c = input.charAt(j);

                map[i][j] = '.';

                if (c == 'S') {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                }
                else if (c == 'D') {
                    end = new Point(i, j);
                    map[i][j] = c;
                }
                else if (c == '*') {
                    water.offer(new Point(i, j));
                    map[i][j] = c;
                }
                else if (c == 'X') {
                    map[i][j] = c;
                }
            }
        }

        int idx = 0;

        while (!queue.isEmpty()) {
            idx++;
            // 물 먼저
            int last = water.size();

            for (int i = 0 ; i < last ; i++) {
                Point now = water.poll();

                for (int d = 0 ; d < 4 ; d++) {
                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] != '.' || map[nx][ny] == 'X') continue;

                    map[nx][ny] = '*';
                    water.offer(new Point(nx, ny));
                }
            }

            last = queue.size();

            for (int i = 0 ; i < last ; i++) {
                Point now = queue.poll();

                if (now.x == end.x && now.y == end.y) {
                    System.out.println(idx - 1);
                    return;
                }

                for (int d = 0 ; d < 4 ; d++) {
                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == 'X') continue;

                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        System.out.println("KAKTUS");

    }
}