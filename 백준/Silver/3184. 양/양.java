import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static class Pos {
        int x, y;

        Pos(int x, int y) {
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

        for (int i = 0 ; i < R ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < C ; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        boolean [][] visited = new boolean[R][C];
        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        int V = 0;
        int O = 0;

        for (int i = 0 ; i < R ; i++) {
            for (int j = 0 ; j < C ; j++) {
                if (visited[i][j] || map[i][j] == '#') continue;

                visited[i][j] = true;
                int v = 0;
                int o = 0;

                Queue<Pos> queue = new ArrayDeque<>();
                if (map[i][j] == 'v') v++;
                else if (map[i][j] == 'o') o++;
                queue.offer(new Pos(i, j));

                while (!queue.isEmpty()) {
                    Pos now = queue.poll();

                    for (int d = 0 ; d < 4 ; d++) {
                        int nx = now.x + D[d][0];
                        int ny = now.y + D[d][1];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == '#' || visited[nx][ny]) continue;

                        if (map[nx][ny] == 'v') v++;
                        else if (map[nx][ny] == 'o') o++;

                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny));
                    }
                }

                if (v < o) {
                    O += o;
                } else {
                    V += v;
                }
            }
        }

        System.out.println(O + " " + V);
    }
}