import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;

public class Main {
    static class Point {
        int l, r, c, cnt;
        Point(int l, int r, int c, int cnt) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        while(true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            char [][][] map = new char[L][R][C];
            Point start = null;

            for (int i = 0 ; i < L ; i++) {
                for (int j = 0 ; j < R ; j++) {
                    String input = br.readLine();
                    for (int k = 0 ; k < C ; k++) {
                        char c = input.charAt(k);

                        if (c == 'S') start = new Point(i, j, k, 0);

                        if (c == '#' || c == 'E') map[i][j][k] = c;
                        else map[i][j][k] = '.';;
                    }
                }
                br.readLine();
            }

            Queue<Point> queue = new ArrayDeque<>();

            queue.offer(start);

            int [][] D = {{0, -1, 0},{0, 0, 1},{0, 1, 0},{0, 0, -1},{1, 0, 0},{-1, 0, 0}};

            int ans = -1;

            boolean [][][] visited = new boolean[L][R][C];
            visited[start.l][start.r][start.c] = true;

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if (map[now.l][now.r][now.c] == 'E') {
                    ans = now.cnt;
                    break;
                }

                for (int d = 0 ; d < 6 ; d++) {
                    int nl = now.l + D[d][0];
                    int nr = now.r + D[d][1];
                    int nc = now.c + D[d][2];

                    if (nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C || visited[nl][nr][nc] || map[nl][nr][nc] == '#') continue;

                    visited[nl][nr][nc] = true;
                    queue.offer(new Point(nl, nr, nc, now.cnt + 1));
                }
            }

            if (ans == -1) sb.append("Trapped!").append("\n");
            else sb.append("Escaped in ").append(ans).append(" minute(s).").append("\n");
        }

        System.out.print(sb);

    }
}