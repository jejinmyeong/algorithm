import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int e, w;
        Node(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return o.w - this.w;
        }
    }
    static int N, M, S, E;
    static ArrayList<Node> [] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new ArrayList [N + 1];

        for (int i = 0 ; i <= N ; i++) {
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

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean [] visited = new boolean[N + 1];

        queue.offer(new Node(S, Integer.MAX_VALUE));

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.e == E) {
                return now.w;
            }

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (int i = 0 ; i < nodes[now.e].size() ; i++) {
                Node next = nodes[now.e].get(i);

                if (visited[next.e]) continue;
                queue.offer(new Node(next.e, Math.min(now.w, next.w)));
            }
        }

        return -1;
    }

}