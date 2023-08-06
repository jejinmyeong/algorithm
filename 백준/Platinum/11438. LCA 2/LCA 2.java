import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static class Node {
        ArrayList<Integer> adjList;
        int depth;

        Node() {
            adjList = new ArrayList<>();
        }
    }
    static Node [] nodes;
    static int [][] parents;
    static int MAX_DEPTH = 18;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        nodes = new Node[N + 1];

        for (int i = 0 ; i <= N ; i++) {
            nodes[i] = new Node();
        }

        for (int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].adjList.add(v);
            nodes[v].adjList.add(u);
        }

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        boolean [] visited = new boolean[N + 1];
        visited[1] = true;

        parents = new int[N + 1][MAX_DEPTH + 1];

        while (!queue.isEmpty()) {
            int now = queue.poll();

            Node nowNode = nodes[now];

            for (int i = 0 ; i < nowNode.adjList.size() ; i++) {
                int next = nowNode.adjList.get(i);
                Node nextNode = nodes[next];

                if (visited[next]) continue;

                nextNode.depth = nowNode.depth + 1;
                parents[next][0] = now;
                visited[next] = true;
                queue.offer(next);
            }
        }

        for (int i = 1 ; i < MAX_DEPTH ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                parents[j][i] = parents[parents[j][i - 1]][i - 1];
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            sb.append(LCA(node1, node2)).append("\n");
        }

        System.out.print(sb);
    }

    static int LCA (int node1, int node2) {
        if (nodes[node1].depth < nodes[node2].depth) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        for (int d = MAX_DEPTH ; d >= 0 ; d--) {
            int diff = nodes[node1].depth - nodes[node2].depth;
            if (diff >= (1 << d)) {
                node1 = parents[node1][d];
            }
        }

        if (node1 == node2) return node1;

        for (int d = MAX_DEPTH ; d >= 0 ; d--) {
            if (parents[node1][d] != parents[node2][d]) {
                node1 = parents[node1][d];
                node2 = parents[node2][d];
            }
        }

        return parents[node1][0];
    }
}