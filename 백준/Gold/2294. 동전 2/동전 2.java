import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int c, v;
        Node (int c, int v) {
            this.c = c;
            this.v = v;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] values = new int[N];

        for (int i = 0 ; i < N ; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        boolean [] visited = new boolean[K + 1];

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0 ; i < N ; i++) {
            if (values[i] > K) continue;
            queue.offer(new Node(1, values[i]));
            visited[values[i]] = true;
        }

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.v == K) {
                System.out.println(now.c);
                return;
            }

            for (int i = 0 ; i < N ; i++) {
                int next = now.v + values[i];

                if (next > K || visited[next]) continue;

                queue.offer(new Node(now.c + 1, next));
                visited[next] = true;
            }
        }

        System.out.println(-1);
    }
}