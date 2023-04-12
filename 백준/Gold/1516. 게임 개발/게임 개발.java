import java.math.*;
import java.util.*;
import java.io.*;

public class Main {
    static class Build implements Comparable<Build> {
        int n, t;
        Build(int n, int t) {
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo(Build o) {
            return this.t - o.t;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int [] times = new int[N + 1];
        ArrayList<Integer> [] list = new ArrayList[N + 1];
        int [] cnt = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            times[i] = t;

            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());

                if (n == -1) break;

                list[n].add(i);
                cnt[i]++;
            }
        }

        PriorityQueue<Build> queue = new PriorityQueue<>();

        for (int i = 1 ; i <= N ; i++) {
            if (cnt[i] == 0) queue.offer(new Build(i, times[i]));
        }

        while (!queue.isEmpty()) {
            int now = queue.poll().n;

            for (int next: list[now]) {
                cnt[next]--;

                if (cnt[next] == 0) {
                    times[next] += times[now];
                    queue.offer(new Build(next, times[next]));
                }
            }
        }

        for (int i = 1 ; i <= N ; i++) {
            sb.append(times[i]).append("\n");
        }

        System.out.print(sb);

    }

}