import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static char [][] map;
    static int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];

        for (int i = 0 ; i < 12 ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < 6 ; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int ans = 0;

        while(bfs()) {
            ans++;
            gravity();
        }

        System.out.println(ans);

    }

    static class Point {
        int x, y;
        char p;

        Point (int x, int y, char p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }

    static boolean bfs() {
        Queue<Point> queue = new ArrayDeque<>();

        boolean [][] visited = new boolean[12][6];

        boolean flag = false;

        for (int i = 0 ; i < 12 ; i++) {
            for (int j = 0 ; j < 6 ; j++) {
                if (visited[i][j] || map[i][j] == '.') continue;

                queue.offer(new Point(i, j, map[i][j]));
                visited[i][j] = true;

                Queue<Point> temp = new ArrayDeque<>();
                temp.offer(new Point(i, j, map[i][j]));

                while (!queue.isEmpty()) {
                    Point now = queue.poll();

                    for (int d = 0 ; d < 4 ; d++) {
                        int nx = now.x + D[d][0];
                        int ny = now.y + D[d][1];

                        if (isOverflow(nx, ny) || visited[nx][ny] || map[nx][ny] != now.p) continue;

                        visited[nx][ny] = true;
                        temp.offer(new Point(nx, ny, now.p));
                        queue.offer(new Point(nx, ny, now.p));
                    }
                }

                if (temp.size() >= 4) {
                    flag = true;
                    while (!temp.isEmpty()) {
                        Point now = temp.poll();

                        map[now.x][now.y] = '.';
                    }
                }
            }
        }

        return flag;
    }

    static void gravity() {
        for (int i = 0 ; i < 6 ; i++) {
            int blank = -1;
            for (int j = 11 ; j >= 0 ; j--) {
                if (map[j][i] == '.') {
                    if (blank == -1) blank = j;
                    continue;
                }
                else {
                    if (blank != -1) {
                        map[blank][i] = map[j][i];
                        map[j][i] = '.';
                        blank--;
                    }
                }
            }
        }
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= 12 || ny >= 6;
    }
}
