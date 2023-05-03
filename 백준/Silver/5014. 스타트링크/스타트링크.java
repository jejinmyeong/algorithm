import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (G == S) {
            System.out.println(0);
            return;
        }

        boolean [] visited = new boolean[F + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = true;

        int ans = 0;

        while (!queue.isEmpty()) {
            ans++;
            int E = queue.size();
            for (int i = 0 ; i < E ; i++) {
                int now = queue.poll();

                if (now == G) {
                    System.out.println(ans - 1);
                    return;
                }

                int next = now + U;
                if (next <= F && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }

                next = now - D;
                if (next > 0 && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        System.out.println("use the stairs");
    }
}