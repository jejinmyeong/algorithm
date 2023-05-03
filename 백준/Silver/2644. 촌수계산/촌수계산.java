import java.math.*;
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer> [] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        nodes = new ArrayList[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes[x].add(y);
            nodes[y].add(x);
        }

        System.out.println(bfs(p1, p2));
    }

    static class Point {
        int n, c;

        Point(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }

    static int bfs(int p1, int p2) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(p1, 0));
        boolean [] visited = new boolean[N + 1];
        visited[p1] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.n == p2) {
                return now.c;
            }

            for (int i = 0 ; i < nodes[now.n].size() ; i++) {
                int next = nodes[now.n].get(i);

                if (visited[next]) continue;

                visited[next] = true;
                queue.offer(new Point(next, now.c + 1));
            }
        }

        return -1;
    }
}