import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    static class FireBall {
        int r, c, m, s, d;

        FireBall (int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    static int N, M, K;
    static int [][] D = {{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<FireBall> init = new ArrayList<>();

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            // r, c 범위를 1 ~ N에서 0 ~ N - 1 로 번경
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            init.add(new FireBall(r, c, m, s, d));
        }

        System.out.println(bfs(init));

    }

    static int bfs(ArrayList<FireBall> init) {
        Queue<FireBall> queue = new ArrayDeque<>();

        init.forEach((f) -> {queue.offer(f);});

        while (K-- > 0) {
            int len = queue.size();

            ArrayList<FireBall> [][] temp = new ArrayList[N][N];

            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < N ; j++) {
                    temp[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0 ; i < len ; i++) {
                FireBall now = queue.poll();

                // 행, 열의 마지막과 앞은 서로 연결되어 있음
                int nr = (now.r + D[now.d][0] * now.s + N * 250) % N;
                int nc = (now.c + D[now.d][1] * now.s + N * 250) % N;

                temp[nr][nc].add(new FireBall(nr, nc, now.m, now.s, now.d));
            }

            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < N ; j++) {
                    if (temp[i][j].size() == 0) continue;

                    if (temp[i][j].size() == 1) {
                        queue.offer(temp[i][j].get(0));
                    } else {
                        int m = temp[i][j].get(0).m;
                        int s = temp[i][j].get(0).s;
                        boolean flag = true;

                        for (int f = 1 ; f < temp[i][j].size() ; f++) {
                            m += temp[i][j].get(f).m;
                            s += temp[i][j].get(f).s;

                            if (temp[i][j].get(f - 1).d % 2 != temp[i][j].get(f).d % 2) {
                                flag = false;
                            }
                        }

                        if (m / 5 == 0) continue;

                        int r = temp[i][j].get(0).r;
                        int c = temp[i][j].get(0).c;
                        m = m / 5;
                        s = s / temp[i][j].size();

                        for (int d = 0 ; d < 8 ; d++) {
                            if ((flag && d % 2 == 1) || (!flag && d % 2 == 0)) continue;

                            queue.offer(new FireBall(r, c, m, s, d));
                        }
                    }
                }
            }
        }

        int res = 0;

        while (!queue.isEmpty()) {
            FireBall now = queue.poll();

            res += now.m;
        }

        return res;
    }
}