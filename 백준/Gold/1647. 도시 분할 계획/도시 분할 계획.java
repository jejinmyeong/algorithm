import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int e, w;

        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    static ArrayList<Node> [] nodes;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[s].add(new Node(e, w));
            nodes[e].add(new Node(s, w));
        }

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean [] visited = new boolean[N + 1];

        queue.offer(new Node(1, 0));

        PriorityQueue<Integer> route = new PriorityQueue<>(Collections.reverseOrder());

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;
            route.offer(now.w);

            for (int i = 0 ; i < nodes[now.e].size() ; i++) {
                Node next = nodes[now.e].get(i);

                if (visited[next.e]) continue;

                queue.offer(new Node(next.e, next.w));
            }
        }

        route.poll();
        int res = 0;
        while (!route.isEmpty()) {
            res += route.poll();
        }

        return res;
    }

}