import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N + 1][M];

        for (int i = 1 ; i <= N ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        boolean [][] visited = new boolean[N + 1][M];
        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        for (int i = 0 ; i < M ; i++) {
            if (visited[0][i]) continue;

            Queue<Pos> queue = new ArrayDeque<>();
            queue.offer(new Pos(0, i));
            visited[0][i] = true;

            while (!queue.isEmpty()) {
                Pos now = queue.poll();

                for (int d = 0 ; d < 4 ; d++) {
                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (nx >= N) {
                        System.out.println("YES");
                        return;
                    }

                    if (nx < 0 || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 1) continue;

                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }

        System.out.println("NO");

    }
}