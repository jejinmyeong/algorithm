import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 1 ; i < N ; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;

        if (queue.isEmpty()) {
            System.out.println(ans);
            return;
        }

        while(queue.peek() >= dasom) {
            int now = queue.poll();

            ans++;
            dasom++;
            queue.offer(now - 1);
        }

        System.out.println(ans);
    }
}
