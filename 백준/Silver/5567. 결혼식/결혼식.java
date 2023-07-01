import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer> [] list = new ArrayList[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        boolean [] visited = new boolean[N + 1];
        visited[1] = true;

        int ans = 0;

        for (int i = 0 ; i < 2 ; i++) {
            int len = queue.size();
            for (int j = 0 ; j < len ; j++) {
                int now = queue.poll();

                for (int k = 0 ; k < list[now].size() ; k++) {
                    int next = list[now].get(k);

                    if (visited[next]) continue;

                    ans++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        System.out.println(ans);

    }
}