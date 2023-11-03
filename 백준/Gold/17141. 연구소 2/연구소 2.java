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
    static int N, M;
    static int [][] map;
    static ArrayList<Pos> putAble;
    static boolean [] choice;
    static int wall;
    static int ans;
    static final int [][] D = {{-1, 0},{0, 1},{1, 0},{0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        putAble = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    putAble.add(new Pos(i, j));
                }
                if (map[i][j] == 1) {
                    wall++;
                }
            }
        }

        choice = new boolean[putAble.size()];
        ans = Integer.MAX_VALUE;

        dfs(0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }

    static void dfs(int idx, int cnt) {
        if (cnt == M) {
            // 바이러스를 퍼뜨리는 로직
            // 결과로 들어오는 시간 갱신
            int res = bfs();

            if (res != -1) ans = res;
            return;
        }

        for (int i = idx ; i < putAble.size() ; i++) {
            choice[i] = true;
            dfs(i + 1, cnt + 1);
            choice[i] = false;
        }
    }

    static int bfs() {
        boolean [][] visited = new boolean[N][N];
        Queue<Pos> queue = new ArrayDeque<>();
        int cnt = 0;

        for (int i = 0 ; i < putAble.size() ; i++) {
            if (choice[i]) {
                Pos pick = putAble.get(i);
                cnt++;
                visited[pick.x][pick.y] = true;
                queue.offer(pick);
            }
        }

        int time = 0;

        while(true) {
            if (time >= ans) {
                return -1;
            }

            int end = queue.size();
            for (int i = 0 ; i < end ; i++) {
                Pos now = queue.poll();

                for (int d = 0 ; d < 4 ; d++) {
                    int nx = now.x + D[d][0];
                    int ny = now.y + D[d][1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == 1) continue;

                    visited[nx][ny] = true;
                    cnt++;
                    queue.offer(new Pos(nx, ny));
                }
            }

            if (queue.isEmpty()) {
                break;
            }

            time++;
        }

        if (N * N - cnt == wall) {
            return time;
        } else {
            return -1;
        }

    }
}