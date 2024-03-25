import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Problem implements Comparable<Problem> {
        int d, c;

        Problem(int d, int c) {
            this.d = d;
            this.c = c;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.d == o.d) return o.c - this.c;
            return this.d - o.d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Problem [] problems = new Problem[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            problems[i] = new Problem(d, c);
        }

        Arrays.sort(problems);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            Problem now = problems[i];

            queue.offer(now.c);

            while (queue.size() > now.d) {
                queue.poll();
            }
        }

        int ans = 0;

        while (!queue.isEmpty()) {
            ans += queue.poll();
        }

        System.out.println(ans);
    }
}