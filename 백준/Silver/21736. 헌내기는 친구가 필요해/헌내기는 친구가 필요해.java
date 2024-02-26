import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Pos {
        int x, y;

        Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char [][] map = new char[N][M];

        Queue<Pos> queue = new ArrayDeque<>();

        for (int i = 0 ; i < N ; i++) {
            String line = br.readLine();

            for (int j = 0 ; j < M ; j++) {
                if (line.charAt(j) == 'I') {
                    queue.offer(new Pos(i, j));
                }

                map[i][j] = line.charAt(j);
            }
        }

        boolean [][] visited = new boolean[N][M];
        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
        int ans = 0;

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 'X') {
                    continue;
                }

                if (map[nx][ny] == 'P') ans++;

                visited[nx][ny] = true;
                queue.offer(new Pos(nx, ny));
            }
        }

        System.out.println(ans == 0 ? "TT" : ans);
    }
}