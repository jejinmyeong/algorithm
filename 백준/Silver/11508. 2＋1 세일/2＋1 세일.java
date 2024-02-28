import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0 ; i < N ; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;

        while (queue.size() > 2) {
            ans += queue.poll();
            ans += queue.poll();
            queue.poll();
        }

        while (!queue.isEmpty()) {
            ans += queue.poll();
        }

        System.out.println(ans);

    }
}