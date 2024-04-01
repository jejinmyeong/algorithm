import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static class Lecture implements Comparable<Lecture> {
        int p, d;

        Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture o) {
            return this.d - o.d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lecture [] lectures = new Lecture[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(p, d);
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            Lecture now = lectures[i];

            queue.offer(now.p);

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