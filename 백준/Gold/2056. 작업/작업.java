import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] times = new int[N + 1];
        int [] cnt = new int[N + 1];
        ArrayList<Integer> [] list = new ArrayList[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            times[i] = t;

            int M = Integer.parseInt(st.nextToken());

            for (int j = 0 ; j < M ; j++) {
                int preTask = Integer.parseInt(st.nextToken());
                list[preTask].add(i);
                cnt[i]++;
            }
        }

        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 1 ; i <= N ; i++) {
            if (cnt[i] == 0) queue.offer(new int [] {i, times[i]});
        }

        while (!queue.isEmpty()) {
            int now = queue.poll()[0];

            for (int i = 0 ; i < list[now].size() ; i++) {
                int next = list[now].get(i);

                cnt[next]--;

                if (cnt[next] == 0) {
                    times[next] += times[now];
                    queue.offer(new int[] {next, times[next]});
                }
            }
        }

        int ans = 0;

        for (int i = 1 ; i <= N ; i++) {
            ans = Math.max(ans, times[i]);
        }

        System.out.println(ans);
    }

}