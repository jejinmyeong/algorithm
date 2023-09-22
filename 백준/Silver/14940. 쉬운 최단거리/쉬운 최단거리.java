import java.util.*;
import java.io.*;

public class Main {
    static class Pos {
        int x, y, c;

        Pos(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];
        int [][] res = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            Arrays.fill(res[i], -1);
        }

        Pos start = new Pos(-1, -1, 0);

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    start.x = i;
                    start.y = j;
                } else if (num == 0) {
                    res[i][j] = num;
                }

                map[i][j] = num;
            }
        }

        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(start);
        res[start.x][start.y] = 0;

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        while (!queue.isEmpty()) {
            Pos now = queue.poll();

            for (int d = 0 ; d < 4 ; d++) {
                int nx = now.x + D[d][0];
                int ny = now.y + D[d][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || res[nx][ny] != -1) continue;

                res[nx][ny] = now.c + 1;
                queue.offer(new Pos(nx, ny, now.c + 1));
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }


        System.out.print(sb);
    }
}
