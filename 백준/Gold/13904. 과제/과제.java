import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Task implements Comparable<Task> {
        int d, w;

        Task(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Task o) {
            return this.d - o.d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Task [] tasks = new Task[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(tasks);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            Task now = tasks[i];

            queue.offer(now.w);

            if (queue.size() > now.d) {
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