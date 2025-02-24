import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int num, deps;

        Node(int num, int deps) {
            this.num = num;
            this.deps = deps;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer> [] nodes = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            nodes[b].add(a);
        }

        int sum = 0;

        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(1, 0));
        boolean [] visited = new boolean[N + 1];
        visited[1] = true;


        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (nodes[cur.num].size() == 1) sum += cur.deps;

            for (Integer n : nodes[cur.num]) {
                if (visited[n]) continue;

                q.offer(new Node(n, cur.deps + 1));
                visited[n] = true;
            }
        }

        System.out.println(sum % 2 == 0 ? "No" : "Yes");
    }
}
