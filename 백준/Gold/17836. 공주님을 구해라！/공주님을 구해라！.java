import java.util.*;
import java.io.*;

public class Main {
    static class Warrior {
        int x, y, c;
        boolean isGramr;

        Warrior (int x, int y, int c, boolean gramr) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.isGramr = gramr;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Warrior> queue = new ArrayDeque<>();

        boolean [][][] visited = new boolean[2][N][M];

        visited[0][0][0] = true;
        queue.offer(new Warrior(0, 0, 0, false));

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        int ans = -1;

        while (!queue.isEmpty()) {
            Warrior now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                ans = now.c;
                break;
            }

            if (now.c == max) continue;

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (now.isGramr && visited[1][nx][ny] || !now.isGramr && visited[0][nx][ny]) continue;

                if (!now.isGramr && map[nx][ny] == 1) continue;

                if (now.isGramr) visited[1][nx][ny] = true;
                else visited[0][nx][ny] = true;

                if (map[nx][ny] == 2) {
                    queue.offer(new Warrior(nx, ny, now.c + 1, true));
                } else {
                    queue.offer(new Warrior(nx, ny, now.c + 1, now.isGramr));
                }
            }
        }


        if (ans == -1) System.out.println("Fail");
        else System.out.println(ans);
    }
}