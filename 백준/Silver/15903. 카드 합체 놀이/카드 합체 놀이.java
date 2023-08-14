import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            queue.offer(Long.parseLong(st.nextToken()));
        }

        while (M-- > 0) {
            long a = queue.poll();
            long b = queue.poll();

            long sum = a + b;

            queue.offer(sum);
            queue.offer(sum);
        }

        long score = 0;

        while (!queue.isEmpty()) {
            score += queue.poll();
        }

        System.out.println(score);
    }
}
