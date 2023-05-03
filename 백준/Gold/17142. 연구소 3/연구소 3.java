import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, ans, mount;
    static int [][] map, D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    static ArrayList<Point> viruses;
    static boolean [] choice;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        viruses = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                int now = Integer.parseInt(st.nextToken());

                if (now == 2) viruses.add(new Point(i, j));
                else if (now == 0) mount++;
                map[i][j] = now;
            }
        }

        if (mount == 0) {
            System.out.println(0);
            return;
        }

        choice = new boolean[viruses.size()];
        ans = Integer.MAX_VALUE;

        dfs(0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void dfs(int cnt, int idx) {
        if (cnt == M) {
            ans = Math.min(ans, bfs());
            return;
        }

        for (int i = idx ; i < choice.length ; i++) {
            choice[i] = true;
            dfs(cnt + 1, i + 1);
            choice[i] = false;
        }
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean [][] visited = new boolean[N][N];

        for (int i = 0 ; i < choice.length ; i++) {
            if (choice[i]) {
                queue.offer(viruses.get(i));
                visited[viruses.get(i).x][viruses.get(i).y] = true;
            }
        }

        int time = 0;
        int remove = 0;

        while(!queue.isEmpty()) {
            int last = queue.size();

            for (int i = 0 ; i < last ; i++) {
                Point now = queue.poll();
                if (map[now.x][now.y] == 0) {
                    remove++;
                    if (remove == mount) return time;
                }

                for (int d = 0 ; d < 4 ; d++) {
                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (isOverflow(nx, ny) || map[nx][ny] == 1 || visited[nx][ny]) continue;

                    visited[nx][ny] = true;
                    // 비활성 바이러스에 도착한 경우, 비활성 바이러스가 퍼질 수 있으면 큐에 추가, 그렇지 않으면 추가하지 않음.
                    if (map[nx][ny] == 2) {
                        boolean flag = false;
                        for (int nd = 0 ; nd < 4 ; nd++) {
                            int nnx = nx + D[nd][0];
                            int nny = ny + D[nd][1];

                            if (isOverflow(nnx, nny) || visited[nnx][nny] || map[nnx][nny] == 1) continue;

                            flag = true;
                            break;
                        }

                        if (flag) queue.offer(new Point(nx, ny));
                    } else queue.offer(new Point(nx, ny));
                }
            }
            if (!queue.isEmpty()) time++;
        }

        return Integer.MAX_VALUE;
    }

    static boolean isOverflow(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= N || ny >= N;
    }
}