import java.io.*;
import java.util.*;

public class Main {
    static class Lesson implements Comparable<Lesson> {
        int s, e;
        Lesson(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Lesson o) {
            if (this.s == o.s) return this.e - o.e;
            return this.s - o.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Lesson [] lessons = new Lesson[N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lessons[i] = new Lesson(s, e);
        }

        Arrays.sort(lessons);


        PriorityQueue<Integer> end = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            if (end.isEmpty()) {
                end.offer(lessons[i].e);
                continue;
            }

            if (end.peek() <= lessons[i].s) {
                end.poll();
            }

            end.offer(lessons[i].e);
        }

        System.out.println(end.size());
    }
}
