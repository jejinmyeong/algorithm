import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean [][][] visited = new boolean[A + 1][B + 1][C + 1];
        Queue<int []> queue = new ArrayDeque<>();

        queue.offer(new int[] {0, 0, C});
        visited[0][0][C] = true;

        TreeSet<Integer> set = new TreeSet<>();
        set.add(C);

        while (!queue.isEmpty()) {
            int [] now = queue.poll();

            // C -> A
            if (now[2] != 0) {
                int na;
                int nb = now[1];
                int nc;
                if (now[0] + now[2] <= A) {
                    na = now[0] + now[2];
                    nc = 0;

                } else {
                    na = A;
                    nc = now[2] - (A - now[0]);

                }
                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;

                    queue.offer(new int [] {na, nb, nc});
                }
            }

            // C -> B
            if (now[2] != 0) {
                int na = now[0];
                int nb;
                int nc;
                if (now[1] + now[2] <= B) {
                    nb = now[1] + now[2];
                    nc = 0;

                } else {
                    nb = B;
                    nc = now[2] - (B - now[1]);

                }
                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;
                    if (na == 0) set.add(nc);

                    queue.offer(new int [] {na, nb, nc});
                }
            }

            // A -> B
            if (now[0] != 0) {
                int na;
                int nb;
                int nc = now[2];

                if (now[0] + now[1] <= B) {
                    nb = now[0] + now[1];
                    na = 0;
                } else {
                    nb = B;
                    na = now[0] - (B - now[1]);
                }

                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;
                    if (na == 0) set.add(nc);

                    queue.offer(new int [] {na, nb, nc});
                }
            }

            // A -> C
            if (now[0] != 0) {
                int na;
                int nb = now[1];
                int nc;

                if (now[0] + now[2] <= C) {
                    nc = now[0] + now[2];
                    na = 0;
                } else {
                    nc = C;
                    na = now[0] - (C - now[2]);
                }

                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;
                    if (na == 0) set.add(nc);

                    queue.offer(new int [] {na, nb, nc});
                }
            }

            // B -> A
            if (now[1] != 0) {
                int na;
                int nb;
                int nc = now[2];

                if (now[0] + now[1] <= A) {
                    na = now[0] + now[1];
                    nb = 0;
                } else {
                    na = A;
                    nb = now[1] - (A - now[0]);
                }

                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;

                    queue.offer(new int [] {na, nb, nc});
                }
            }

            // B -> C
            if (now[1] != 0) {
                int na = now[0];
                int nb;
                int nc;

                if (now[1] + now[2] <= C) {
                    nc = now[1] + now[2];
                    nb = 0;
                } else {
                    nc = C;
                    nb = now[1] - (C - now[2]);
                }

                if (!visited[na][nb][nc]) {
                    visited[na][nb][nc] = true;
                    if (na == 0) set.add(nc);

                    queue.offer(new int [] {na, nb, nc});
                }
            }
        }

        for (int a : set) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);

    }
}