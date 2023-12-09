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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean [][] map = new boolean[N][M];

        for (int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                if (line.charAt(j) == '|') map[i][j] = true;
            }
        }

        boolean [][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (visited[i][j]) continue;
                Queue<Pos> queue = new ArrayDeque<>();
                queue.offer(new Pos(i, j));
                visited[i][j] = true;
                cnt++;

                while (!queue.isEmpty()) {
                    Pos now = queue.poll();

                    int nx = now.x + (map[i][j] ? 1 : 0);
                    int ny = now.y + (map[i][j] ? 0 : 1);

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != map[i][j]) continue;

                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny));
                }

            }
        }

        System.out.println(cnt);

    }
}