package J2023Mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_boj_12852_1로만들기2 {
    static class Node {
        int n, cnt;
        Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean [] visited = new boolean[N + 1];
        int [] before = new int[N + 1];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.n == 1) {
                sb.append(now.cnt).append("\n");
                int start = 1;
                Stack<Integer> stack = new Stack<>();
                while (start != 0) {
                    stack.push(start);
                    start = before[start];
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop()).append(" ");
                }
                break;
            }

            if (now.n % 3 == 0 && !visited[now.n / 3]) {
                queue.offer(new Node(now.n / 3, now.cnt + 1));
                visited[now.n / 3] = true;
                before[now.n / 3] = now.n;
            }

            if (now.n % 2 == 0 && !visited[now.n / 2]) {
                queue.offer(new Node(now.n / 2, now.cnt + 1));
                visited[now.n / 2] = true;
                before[now.n / 2] = now.n;
            }

            if (!visited[now.n - 1]) {
                queue.offer(new Node(now.n - 1, now.cnt + 1));
                visited[now.n - 1] = true;
                before[now.n - 1] = now.n;
            }
        }

        System.out.println(sb);
    }
}
