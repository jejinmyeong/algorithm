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
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean [][] visited = new boolean[N][M];
        int [][] D = {{0, -1},{-1, 0},{0, 1},{1, 0}};
        HashMap<Integer, Integer> width = new HashMap<>();

        int cnt = 0;
        int max = 0;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (visited[i][j]) continue;

                Queue<Pos> queue = new ArrayDeque<>();
                ArrayList<Pos> visit = new ArrayList<>();
                queue.offer(new Pos(i, j));
                visit.add(new Pos(i, j));
                visited[i][j] = true;

                int temp = 1;

                while (!queue.isEmpty()) {
                    Pos now = queue.poll();

                    for (int d = 1 ; d < 16 ; d = d << 1) {
                        int nd = map[now.x][now.y] & d;

                        if (nd != 0) continue;

                        int nx = now.x;
                        int ny = now.y;

                        if (d == 1) {
                            nx += D[0][0];
                            ny += D[0][1];
                        } else if (d == 2) {
                            nx += D[1][0];
                            ny += D[1][1];
                        } else if (d == 4) {
                            nx += D[2][0];
                            ny += D[2][1];
                        } else if (d == 8) {
                            nx += D[3][0];
                            ny += D[3][1];
                        }

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

                        temp++;
                        visited[nx][ny] = true;
                        queue.offer(new Pos(nx, ny));
                        visit.add(new Pos(nx, ny));
                    }
                }

                max = Math.max(max, temp);
                width.put(cnt, temp);

                for (Pos v: visit) {
                    map[v.x][v.y] = cnt;
                }

                cnt++;

            }
        }

        int sum = 0;

        for(int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (j + 1 < M && map[i][j] != map[i][j + 1]) {
                    sum = Math.max(sum, width.get(map[i][j]) + width.get(map[i][j + 1]));
                }
                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    sum = Math.max(sum, width.get(map[i][j]) + width.get(map[i + 1][j]));
                }
            }
        }

        sb.append(cnt).append("\n");
        sb.append(max).append("\n");
        sb.append(sum);

        System.out.println(sb);
    }
}