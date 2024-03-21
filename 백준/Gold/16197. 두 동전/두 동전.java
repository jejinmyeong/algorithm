import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static class Pos {
        int x, y;

        Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Coins {
        Pos coin1, coin2;
        int c;

        Coins (Pos coin1, Pos coin2, int c) {
            this.coin1 = coin1;
            this.coin2 = coin2;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char [][] map = new char[N][M];
        List<Pos> coins = new ArrayList<>();

        for (int  i = 0 ; i < N ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'o') {
                    coins.add(new Pos(i, j));
                }
            }
        }

        Queue<Coins> queue = new ArrayDeque<>();
        queue.offer(new Coins(coins.get(0), coins.get(1), 0));

        boolean [][][][] visited = new boolean[N][M][N][M];
        visited[coins.get(0).x][coins.get(0).y][coins.get(1).x][coins.get(1).y] = true;

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        while (!queue.isEmpty()) {
            Coins now = queue.poll();

            if (now.c >= 10) break;

            for (int d = 0 ; d < 4 ; d++) {
                int nx1 = now.coin1.x + D[d][0];
                int ny1 = now.coin1.y + D[d][1];
                int nx2 = now.coin2.x + D[d][0];
                int ny2 = now.coin2.y + D[d][1];

                int out = 0;
                if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) out++;
                if (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M) out++;

                if (out == 1) {
                    System.out.println(now.c + 1);
                    return;
                } else if (out == 0) {
                    if (map[nx1][ny1] == '#') {
                        nx1 = now.coin1.x;
                        ny1 = now.coin1.y;
                    }

                    if (map[nx2][ny2] == '#') {
                        nx2 = now.coin2.x;
                        ny2 = now.coin2.y;
                    }
                    if (visited[nx1][ny1][nx2][ny2]) continue;

                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.offer(new Coins(new Pos(nx1, ny1), new Pos(nx2, ny2), now.c + 1));
                }
            }
        }

        System.out.println(-1);
    }
}