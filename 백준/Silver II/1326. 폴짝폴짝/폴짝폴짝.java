import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a == b) {
            System.out.println(0);
            return;
        }

        boolean[] visited = new boolean[10001];

        Queue<int[]> queue = new ArrayDeque<>();

        visited[a] = true;

        queue.offer(new int[]{a, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = arr[now[0]];
            int next = now[0];

            while (true) {
                next += num;
                if (next > N) break;
                if (visited[next]) continue;
                visited[next] = true;

                if (next == b) {
                    System.out.println(now[1] + 1);
                    return;
                }
                queue.add(new int[]{next, now[1]+1});
            }

            next = now[0];
            while (true) {
                next -= num;
                if (next < 1) break;
                if (visited[next]) continue;
                visited[next] = true;

                if (next == b) {
                    System.out.println(now[1] + 1);
                    return;
                }

                queue.add(new int[]{next, now[1]+1});
            }

        }
        System.out.println(-1);
    }
}