package J2023Feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_boj_16953_AtoB {

    static int A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int res = bfs();

        System.out.println(res == -1 ? -1 : res + 1);
    }

    static class Node implements Comparable<Node>{
        int num, c;
        Node (int num, int c) {
            this.num = num;
            this.c = c;
        }

        @Override
        public int compareTo (Node o) {
            return this.c - o.c;
        }
    }
    static int bfs () {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean [] visited = new boolean[B + 1];

        queue.offer(new Node(A, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.num == B) return now.c;

            if (visited[now.num]) continue;

            visited[now.num] = true;

            long next = now.num * 2L;
            if (next <= B && !visited[(int) next]) {
                queue.offer(new Node((int) next, now.c + 1));
            }
            next = now.num * 10L + 1L;
            if (next <= B && !visited[(int) next]) {
                queue.offer(new Node((int) next, now.c + 1));
            }
        }

        return -1;
    }
}
