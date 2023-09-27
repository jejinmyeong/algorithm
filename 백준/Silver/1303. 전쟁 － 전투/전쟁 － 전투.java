import java.util.*;
import java.io.*;

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

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String input = br.readLine();
            for (int j = 0 ; j < M ; j++) {
                if (input.charAt(j) == 'W') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        boolean [][] visited = new boolean[N][M];

        int W = 0;
        int H = 0;

        int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;

                boolean isW;

                isW = map[i][j] == 0;

                Queue<Pos> queue = new ArrayDeque<>();

                queue.offer(new Pos(i, j));
                int cnt = 1;

                while (!queue.isEmpty()) {
                    Pos now = queue.poll();

                    for (int d = 0 ; d < 4 ; d++) {
                        int nx = now.x + D[d][0];
                        int ny = now.y + D[d][1];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || isW && map[nx][ny] == 1 || !isW && map[nx][ny] == 0) continue;

                        cnt++;
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny));
                    }
                }

                if (isW) W += Math.pow(cnt, 2);
                else H += Math.pow(cnt, 2);
            }
        }

        System.out.println(W + " " + H);
    }
}