import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                int now = Integer.parseInt(st.nextToken());

                if (queue.size() < N) {
                    queue.offer(now);
                    continue;
                }

                if (queue.peek() < now) {
                    queue.poll();
                    queue.offer(now);
                }
            }
        }

        System.out.println(queue.poll());
    }
}
